package com.single.platform.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.single.platform.entity.Users;
import com.single.platform.exception.MyException;
import com.single.platform.mapper.UsersMapper;
import com.single.platform.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:42
 */
@Service
@AllArgsConstructor
public class UsersServiceImpl extends ServiceImpl<UsersMapper,Users> implements UsersService {

    private final UsersMapper mapper;

    @Override
    public Users getByOpenId(String openId) {
        return mapper.selectOne(Wrappers.<Users>lambdaQuery().eq(Users::getOpenId,openId));
    }

    @Override
    public void bind(String openId, String name, String nickName) throws MyException {
        Users user = this.getByNameOrNickName(name, nickName);
        if(user==null){
            throw new MyException("用户不存在");
        }
        user.setOpenId(openId);
        mapper.updateById(user);
    }

    @Override
    public Users getByNameOrNickName(String name, String nickName) {

        if(StrUtil.isNotEmpty(name)&&StrUtil.isEmpty(nickName)){
            return mapper.selectOne(Wrappers.<Users>lambdaQuery().eq(Users::getName,name));
        }else if(StrUtil.isNotEmpty(nickName)&&StrUtil.isEmpty(name)){
            return mapper.selectOne(Wrappers.<Users>lambdaQuery().eq(Users::getNickName,nickName));
        }else if(StrUtil.isNotEmpty(name)&&StrUtil.isNotEmpty(nickName)){
            return mapper.selectOne(Wrappers.<Users>lambdaQuery().eq(Users::getName,name)
                                                                    .eq(Users::getNickName,nickName));
        }

        return null;
    }
}
