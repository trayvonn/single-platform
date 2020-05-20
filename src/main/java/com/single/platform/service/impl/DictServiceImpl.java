package com.single.platform.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.single.platform.entity.Dict;
import com.single.platform.mapper.DictMapper;
import com.single.platform.service.DictService;
import com.single.platform.vo.DictVO;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:42
 */
@Service
@AllArgsConstructor
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    private final DictMapper mapper;

    @Override
    @Cacheable("dict")
    public List<DictVO> findByType(String type) {
        return mapper.findByType(type);
    }

    @Override
    @Cacheable("dict")
    public List<DictVO> findAll() {
        return mapper.findAll();
    }

    @Override
    @Cacheable("dict")
    public Dict getByTypeAndValue(String type, Integer value) {
        return mapper.getByTypeAndValue(type,value);
    }
}
