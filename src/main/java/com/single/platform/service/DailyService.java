package com.single.platform.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.single.platform.entity.Daily;
import com.single.platform.exception.MyException;
import com.single.platform.vo.DailyVO;
import com.single.platform.vo.UsersDailyVO;

import java.util.List;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:41
 */
public interface DailyService extends IService<Daily> {

    void saveEntity(Daily entity) throws MyException;

    void modify(Daily entity);

    List<DailyVO> findVOByUserId(Integer userId, String createTime);

    Page<DailyVO> findPageByUserId(Page page,Integer userId);

    List<UsersDailyVO> getMyFollowerDaily(Integer userId, String createTime);
}
