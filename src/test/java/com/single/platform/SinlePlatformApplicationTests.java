package com.single.platform;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.single.platform.entity.Daily;
import com.single.platform.entity.Projects;
import com.single.platform.entity.Timesheet;
import com.single.platform.entity.Users;
import com.single.platform.mapper.DailyMapper;
import com.single.platform.mapper.ProjectsMapper;
import com.single.platform.mapper.TimesheetMapper;
import com.single.platform.mapper.UsersMapper;
import com.single.platform.service.DailyService;
import com.single.platform.service.DictService;
import com.single.platform.vo.DictVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SinlePlatformApplicationTests {

    @Autowired
    TimesheetMapper timesheetMapper;
    @Autowired
    DailyService dailyService;
    @Autowired
    DailyMapper dailyMapper;
    @Autowired
    UsersMapper usersMapper;
    @Autowired
    DictService dictService;
    @Autowired
    ProjectsMapper projectsMapper;

    @Test
    public void transfer() {
        List<Timesheet> timesheets = timesheetMapper.selectList(Wrappers.emptyWrapper());
        List<DictVO> all = dictService.findAll();
        ArrayList<Daily> dailies = new ArrayList<>();
        Projects other = projectsMapper.selectOne(Wrappers.<Projects>lambdaQuery().eq(Projects::getName, "其他"));
        timesheets.forEach(e->{
            Users users = usersMapper.selectOne(Wrappers.<Users>lambdaQuery().eq(Users::getName, e.getName()));
            List<DictVO> action = all.stream().filter(a -> e.getAction().equals(a.getLabel())).collect(Collectors.toList());
            Integer a = CollectionUtil.isEmpty(action)?0:action.get(0).getValue();
            List<DictVO> status = all.stream().filter(b -> e.getStatus().equals(b.getLabel())).collect(Collectors.toList());
            Integer s= CollectionUtil.isEmpty(status)?0:status.get(0).getValue();
            Projects p = projectsMapper.selectOne(Wrappers.<Projects>lambdaQuery().eq(Projects::getName, e.getModule()));
            Daily daily = new Daily(null, users.getId(), p==null?other.getId():p.getId(), a, s, e.getDescription(), e.getEstimatedTime()==null?0:e.getEstimatedTime().intValue(), e.getCreateTime());
            dailies.add(daily);
        });
        dailyService.saveBatch(dailies);
    }

}
