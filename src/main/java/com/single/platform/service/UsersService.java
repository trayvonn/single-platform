package com.single.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.single.platform.entity.Users;
import com.single.platform.exception.MyException;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:41
 */
public interface UsersService extends IService<Users> {

    Users getByOpenId(String openId);

    void bind(String openId,String name,String nickName) throws MyException;

    Users getByNameOrNickName(String name ,String nickName);
}
