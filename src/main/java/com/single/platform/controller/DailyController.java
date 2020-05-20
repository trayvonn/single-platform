package com.single.platform.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.single.platform.base.R;
import com.single.platform.entity.Daily;
import com.single.platform.exception.MyException;
import com.single.platform.service.DailyService;
import com.single.platform.vo.DailyVO;
import com.single.platform.vo.UsersDailyVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "日报模块")
@RequestMapping("api/v1/daily")
@RestController
@AllArgsConstructor
@CrossOrigin
public class DailyController {

    private final DailyService service;

    @ApiOperation(value = "提交日报")
    @ApiOperationSupport(author = "吴邪")
    @PostMapping("save")
    public R save(Daily entity) throws MyException {
        service.saveEntity(entity);
        return R.success();
    }

    @ApiOperation(value = "修改日报内容")
    @ApiOperationSupport(author = "吴邪")
    @PostMapping("modify")
    public R modify(Daily entity) throws MyException {
        service.modify(entity);
        return R.success();
    }

    @ApiOperation(value = "获取我的日报")
    @ApiOperationSupport(author = "吴邪")
    @GetMapping("getMyDaily")
    public R<Page<DailyVO>> getMyDaily(Page page, Integer userId) {
        return R.success(service.findPageByUserId(page,userId));
    }

    @ApiOperation(value = "获取我的下属日报")
    @ApiOperationSupport(author = "吴邪")
    @GetMapping("getMyFollowerDaily")
    public R<List<UsersDailyVO>> getMyFollowerDaily(Integer userId, String createTime) {
        return R.success(service.getMyFollowerDaily(userId,createTime));
    }

}
