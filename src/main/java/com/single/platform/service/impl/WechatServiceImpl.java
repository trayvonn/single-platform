package com.single.platform.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.single.platform.config.WechatProperties;
import com.single.platform.dto.WechatAccessTokenDTO;
import com.single.platform.dto.WechatJsapiDTO;
import com.single.platform.dto.WechatTicketDTO;
import com.single.platform.enums.HttpEnum;
import com.single.platform.exception.MyException;
import com.single.platform.service.WechatService;
import com.single.platform.utils.WechatUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 吴邪
 * @date: 2020/5/14 14:54
 */
@Slf4j
@Service
@AllArgsConstructor
public class WechatServiceImpl implements WechatService {

    private final WechatProperties wechatProperties;

    private final CacheManager cacheManager;

    private static final String CACHE_WECHAT = "wechat";
    private static final String CACHE_ACCESSTOKEN = "AT";
    private static final String CACHE_TICKET = "T";

    @Override
    public WechatAccessTokenDTO accessToken(String code) throws Exception {
        HashMap<String, Object> params = new HashMap<>();
        params.put("appid",wechatProperties.getAppId());
        params.put("secret",wechatProperties.getAppSecret());
        params.put("code",code);
        params.put("grant_type","authorization_code");

        String result = HttpUtil.get(wechatProperties.getAccessTokenUrl(), params);
        log.info(result);

        WechatAccessTokenDTO wechatAccessTokenDTO = JSONUtil.toBean(result, WechatAccessTokenDTO.class);
        if(StrUtil.isEmpty(wechatAccessTokenDTO.getOpenid())){
            throw new MyException(HttpEnum.WECHAT_CODE_INVALID);
        }

//        this.putAccessTokenDTO(wechatAccessTokenDTO.getOpenid(),wechatAccessTokenDTO);

        return wechatAccessTokenDTO;
    }

    @Override
    public void refreshToken(String key) {
        WechatAccessTokenDTO dto = this.getAccessTokenDTO(key);
        if(dto==null)return;
        HashMap<String, Object> params = new HashMap<>();
        params.put("appid",wechatProperties.getAppId());
        params.put("refresh_token",dto.getRefreshToken());
        params.put("grant_type","refresh_token");

        String result = HttpUtil.get(wechatProperties.getRefreshTokenUrl(), params);
        log.info(result);

        dto = JSONUtil.toBean(result, WechatAccessTokenDTO.class);
        this.putAccessTokenDTO(key,dto);
    }

    @Override
    public boolean checkToken(WechatAccessTokenDTO dto) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("access_token",dto.getAccessToken());
        params.put("openid",dto.getOpenid());

        String result = HttpUtil.get(wechatProperties.getCheckTokenUrl(), params);
        Map<String, Object> resultMap =  JSONUtil.toBean(result, Map.class);
        if (resultMap.get("errcode").equals(0)) {
            return true;
        }
        return false;
    }

    @Override
    public WechatAccessTokenDTO getAccessTokenDTO(String key) {
        Cache cache = cacheManager.getCache(CACHE_WECHAT);
        Cache.ValueWrapper vw = cache != null ? cache.get(CACHE_ACCESSTOKEN + "_" + key) : null;
        return (WechatAccessTokenDTO) (vw != null ? vw.get() : null);
    }

    @Override
    public void putAccessTokenDTO(String key,WechatAccessTokenDTO dto) {
        Cache cache = cacheManager.getCache(CACHE_WECHAT);
        cache.put(CACHE_ACCESSTOKEN+"_"+key,dto);
    }

    @Override
    public WechatTicketDTO getJsapiTicket(String key) throws MyException {
        WechatAccessTokenDTO dto = this.getAccessTokenDTO(key);
        if (!this.checkToken(dto)) {
            this.refreshToken(key);
        }

        HashMap<String, Object> params = new HashMap<>();
        params.put("access_token",dto.getAccessToken());
        params.put("type","jsapi");

        String result = HttpUtil.get(wechatProperties.getRefreshTokenUrl(), params);
        log.info(result);

        WechatTicketDTO wechatTicketDTO = JSONUtil.toBean(result, WechatTicketDTO.class);
        if(StrUtil.isEmpty(wechatTicketDTO.getTicket())){
            throw new MyException("ticket获取失败");
        }
        return wechatTicketDTO;
    }

    @Override
    public WechatJsapiDTO getJsapisignature(String key) throws MyException {
        WechatTicketDTO wechatTicketDTO = this.getJsapiTicket(key);
        long timestamp = System.currentTimeMillis() / 1000;
        String randomStr = RandomUtil.randomString(16);
        String jsapiTicket = wechatTicketDTO.getTicket();
        String signature = WechatUtil.sha1GenWithAmple("jsapi_ticket=" + jsapiTicket,
                "noncestr=" + randomStr, "timestamp=" + timestamp, "url=" + null);
        return new WechatJsapiDTO(randomStr,timestamp,signature);
    }

}
