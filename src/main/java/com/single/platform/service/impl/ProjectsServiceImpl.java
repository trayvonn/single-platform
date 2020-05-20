package com.single.platform.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.single.platform.entity.Application;
import com.single.platform.entity.Projects;
import com.single.platform.entity.Users;
import com.single.platform.mapper.ApplicationMapper;
import com.single.platform.mapper.ProjectsMapper;
import com.single.platform.mapper.UsersMapper;
import com.single.platform.service.DictService;
import com.single.platform.service.ProjectsService;
import com.single.platform.vo.ApplicationVO;
import com.single.platform.vo.ProjectsVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:42
 */
@Service
@AllArgsConstructor
public class ProjectsServiceImpl extends ServiceImpl<ProjectsMapper,Projects> implements ProjectsService {

    private final ProjectsMapper mapper;
    private final ApplicationMapper applicationMapper;
    private final UsersMapper usersMapper;
    private final DictService dictService;

    @Override
    public List<ProjectsVO> listVO() {
        List<Projects> projects = mapper.selectList(Wrappers.emptyWrapper());
        List<ProjectsVO> pvos = new ArrayList<>();
        projects.forEach(p->{
            Application a = applicationMapper.selectById(p.getApplicationId());
            ApplicationVO avo = null;
            if(a!=null){
                Users aown = usersMapper.selectById(a.getOwnerId());
                avo = new ApplicationVO(a.getCode(),a.getName(),aown==null?null:aown.getNickName());
            }
            Users pown = usersMapper.selectById(p.getOwnerId());
            ProjectsVO pvo = new ProjectsVO(p.getId(), p.getName(), p.getPcode(), p.getRcode(), pown==null?null:pown.getNickName(), p.getProjectTime(),
                    dictService.getByTypeAndValue("priority", p.getPriority()).getLabel(), p.getEstimatedDays(), avo);
            pvos.add(pvo);
        });

        return pvos;
    }
}
