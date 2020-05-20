package com.single.platform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.single.platform.entity.Dict;
import com.single.platform.vo.DictVO;

import java.util.List;

/**
 * @author: 吴邪
 * @date: 2020/5/13 13:41
 */
public interface DictService extends IService<Dict> {

    List<DictVO> findByType(String type);

    List<DictVO> findAll();

    Dict getByTypeAndValue(String type ,Integer value);
}
