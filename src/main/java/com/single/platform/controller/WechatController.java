package com.single.platform.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.single.platform.base.R;
import com.single.platform.service.WechatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "微信模块")
@RequestMapping("api/v1/wx")
@RestController
@AllArgsConstructor
@CrossOrigin
public class WechatController {

    private final WechatService wechatService;

    @ApiOperation(value = "获取openid")
    @ApiOperationSupport(author = "吴邪")
    @GetMapping("openId")
    public R openId(String code) throws Exception {
        return R.success(wechatService.accessToken(code).getOpenid());
    }
}
