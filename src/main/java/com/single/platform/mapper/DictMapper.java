package com.single.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.single.platform.entity.Dict;
import com.single.platform.vo.DictVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:43
 */
@Repository
@Mapper
public interface DictMapper extends BaseMapper<Dict> {

    @Select("select * from t_dict where type = #{type} and is_valid = 1")
    List<DictVO> findByType(String type);

    @Select("select * from t_dict where is_valid = 1")
    List<DictVO> findAll();

    @Select("select * from t_dict where type =#{type} and value=#{value}")
    Dict getByTypeAndValue(@Param("type") String type ,@Param("value") Integer value);
}
