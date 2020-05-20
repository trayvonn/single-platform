package com.single.platform.service;

import com.single.platform.dto.WechatAccessTokenDTO;
import com.single.platform.dto.WechatJsapiDTO;
import com.single.platform.dto.WechatTicketDTO;
import com.single.platform.exception.MyException;

/**
 * @author: 吴邪
 * @date: 2020/5/14 14:53
 */
public interface WechatService {

    /**
     * 根据前端传来的code，向微信服务器发起获取accessToken请求，返回accessToken对象
     * @param code
     * @return
     * @throws Exception
     */
    WechatAccessTokenDTO accessToken(String code) throws Exception;

    /**
     * 刷新accessToken
     * @param key
     */
    void refreshToken(String key);

    /**
     * 检查token是否有效
     * @param dto
     * @return
     */
    boolean checkToken(WechatAccessTokenDTO dto);

    /**
     * 将accessToken对象从缓存取出
     * @param key
     */
    WechatAccessTokenDTO getAccessTokenDTO(String key);

    /**
     * 将accessToken对象放入缓存
     * @param key
     * @param dto
     */
    void putAccessTokenDTO(String key,WechatAccessTokenDTO dto);

    WechatTicketDTO getJsapiTicket(String key) throws MyException;

    WechatJsapiDTO getJsapisignature(String ticket) throws MyException;
}
