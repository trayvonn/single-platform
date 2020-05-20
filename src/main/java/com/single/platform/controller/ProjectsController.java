package com.single.platform.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.single.platform.base.R;
import com.single.platform.service.ProjectsService;
import com.single.platform.vo.ProjectsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "项目模块")
@RequestMapping("api/v1/projects")
@RestController
@AllArgsConstructor
@CrossOrigin
public class ProjectsController {

    private final ProjectsService service;

    @ApiOperation(value = "获取项目列表")
    @ApiOperationSupport(author = "吴邪")
    @GetMapping("list")
    public R<List<ProjectsVO>> list() {
        return R.success(service.listVO());
    }

}
