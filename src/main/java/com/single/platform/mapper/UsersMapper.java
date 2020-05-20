package com.single.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.single.platform.entity.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:43
 */
@Repository
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

    @Cacheable("users")
    @Select("select * from t_users where id = #{id}")
    Users selectById(Integer id);
}
