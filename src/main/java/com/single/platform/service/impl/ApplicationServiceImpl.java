package com.single.platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.single.platform.entity.Application;
import com.single.platform.mapper.ApplicationMapper;
import com.single.platform.service.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:42
 */
@Service
@AllArgsConstructor
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {


}
