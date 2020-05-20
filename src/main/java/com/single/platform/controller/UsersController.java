package com.single.platform.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.single.platform.base.R;
import com.single.platform.entity.Users;
import com.single.platform.exception.MyException;
import com.single.platform.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@Api(tags = "员工模块")
@RequestMapping("api/v1/users")
@RestController
@AllArgsConstructor
@CrossOrigin
public class UsersController {

    private final UsersService service;


    @ApiOperation(value = "根据openId获取用户信息")
    @ApiOperationSupport(author = "吴邪")
    @GetMapping("infoByOpenId")
    public R<Users> infoByOpenId(String openId) {
        return  R.success(service.getByOpenId(openId));
    }

    @ApiOperation(value = "根据姓名/花名和openid绑定用户")
    @ApiOperationSupport(author = "吴邪")
    @PostMapping("bind")
    public R<Users> bind(String openId,String name,String nickName) throws MyException {
        service.bind(openId,name,nickName);
        return  R.success();
    }
}
