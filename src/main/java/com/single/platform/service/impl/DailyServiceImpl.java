package com.single.platform.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.single.platform.entity.Daily;
import com.single.platform.entity.Projects;
import com.single.platform.entity.Users;
import com.single.platform.exception.MyException;
import com.single.platform.mapper.DailyMapper;
import com.single.platform.mapper.ProjectsMapper;
import com.single.platform.mapper.UsersMapper;
import com.single.platform.service.DailyService;
import com.single.platform.service.DictService;
import com.single.platform.vo.DailyVO;
import com.single.platform.vo.ProjectsVO;
import com.single.platform.vo.UsersDailyVO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:42
 */
@Service
@AllArgsConstructor
public class DailyServiceImpl extends ServiceImpl<DailyMapper,Daily> implements DailyService {

    private final DailyMapper mapper;
    private final ProjectsMapper projectsMapper;
    private final UsersMapper usersMapper;
    private final DictService dictService;

    public void saveEntity(Daily entity) throws MyException {
        DateTime begin = DateUtil.beginOfDay(new Date());
        DateTime end = DateUtil.endOfDay(new Date());
        List<Daily> dailies = mapper.selectList(Wrappers.<Daily>lambdaQuery().between(Daily::getCreateTime, begin, end)
                                                                            .eq(Daily::getUserId,entity.getUserId()));
        if(CollectionUtil.isNotEmpty(dailies)){
            throw new MyException("今天已经提交过日报了，不能再次提交");
        }
        this.save(entity);
    }

    @Override
    public void modify(Daily entity) {
        Daily daily = mapper.selectById(entity.getId());
        daily.setContent(entity.getContent());
        mapper.updateById(daily);
    }

    @Override
    public List<DailyVO> findVOByUserId(Integer userId, String createTime) {
        //获取当天开始时间
        Date createTimeBegin = DateUtil.beginOfDay(new Date());
        //获取当天结束时间
        Date createTimeEnd = DateUtil.endOfDay(new Date());
        if(StrUtil.isNotEmpty(createTime)){
            //如果传入日期，按照格式解析
            Date parse = DateUtil.parse(createTime);
            createTimeBegin = DateUtil.beginOfDay(parse);
            createTimeEnd = DateUtil.endOfDay(parse);
        }
        List<Daily> dailies = mapper.selectList(Wrappers.<Daily>lambdaQuery().eq(Daily::getUserId, userId)
                                                                            .between(Daily::getCreateTime,createTimeBegin,createTimeEnd));

        return wrapper2VO(dailies);
    }

    private List<DailyVO> wrapper2VO(List<Daily> list){
        List<DailyVO> dvos = new ArrayList<>();
        list.forEach(d->{
            Projects p = projectsMapper.selectById(d.getProjectId());
            Users pown = usersMapper.selectById(p.getOwnerId());
            ProjectsVO pvo = new ProjectsVO(p.getId(), p.getName(), p.getPcode(), p.getRcode(), pown==null?null:pown.getNickName(), p.getProjectTime(),
                    dictService.getByTypeAndValue("priority", p.getPriority()).getLabel(), p.getEstimatedDays(), null);

            DailyVO dvo = new DailyVO(d.getId(), d.getUserId(), pvo,
                    dictService.getByTypeAndValue("dailyAction", d.getAction()).getLabel(),
                    dictService.getByTypeAndValue("dailyStatus", d.getStatus()).getLabel(),
                    d.getContent(), d.getEstimatedTime(),d.getCreateTime());
            dvos.add(dvo);
        });
        return dvos;
    }

    @Override
    public Page<DailyVO> findPageByUserId(Page page, Integer userId) {
        page = mapper.selectPage(page, Wrappers.<Daily>lambdaQuery().eq(Daily::getUserId, userId)
                                                            .orderByDesc(Daily::getCreateTime));
        page.setRecords(wrapper2VO(page.getRecords()));
        return page;
    }

    @Override
    public List<UsersDailyVO> getMyFollowerDaily(Integer userId, String createTime) {
        List<Users> followers = usersMapper.selectList(Wrappers.<Users>lambdaQuery().eq(Users::getLeaderId, userId));
        List<UsersDailyVO> udvos = new ArrayList<>();
        followers.forEach(e->{
            List<DailyVO> voByUserId = this.findVOByUserId(e.getId(), createTime);
            UsersDailyVO udvo = new UsersDailyVO(e.getId(), e.getName(), e.getNickName(), e.getJobLevel(),
                    dictService.getByTypeAndValue("jobTitle", e.getJobTitle()).getLabel(),
                    e.getIsLeader(), voByUserId);
            udvos.add(udvo);
        });
        return udvos;
    }
}
