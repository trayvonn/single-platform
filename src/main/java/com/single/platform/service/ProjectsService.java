package com.single.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.single.platform.entity.Projects;
import com.single.platform.vo.ProjectsVO;

import java.util.List;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:41
 */
public interface ProjectsService extends IService<Projects> {

    List<ProjectsVO> listVO();
}
