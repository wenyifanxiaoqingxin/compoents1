package com.compoent.dao;

import com.compoent.entity.ComponentType;
import com.compoent.entity.ComponentTypeExample;
import tk.mybatis.mapper.common.Mapper;

public interface ComponentTypeMapper extends Mapper<ComponentType> {
    long countByExample(ComponentTypeExample example);
}