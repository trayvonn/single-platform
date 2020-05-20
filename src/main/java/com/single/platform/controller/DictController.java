package com.single.platform.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.single.platform.base.R;
import com.single.platform.service.DictService;
import com.single.platform.vo.DictVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Api(tags = "字典模块")
@RequestMapping("api/v1/dict")
@RestController
@AllArgsConstructor
@CrossOrigin
public class DictController {

    private final DictService dictService;

    @ApiOperation(value = "根据type获取字典列表")
    @ApiOperationSupport(author = "吴邪")
    @GetMapping("type")
    public R<List<DictVO>> type(String type) {
        return R.success(dictService.findByType(type));
    }

    @ApiOperation(value = "获取所有字典列表")
    @ApiOperationSupport(author = "吴邪")
    @GetMapping("all")
    public R<List<DictVO>> all() {
        return R.success(dictService.findAll());
    }
}
