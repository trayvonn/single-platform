package com.single.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.single.platform.entity.Projects;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:43
 */
@Repository
@Mapper
public interface ProjectsMapper extends BaseMapper<Projects> {

}
