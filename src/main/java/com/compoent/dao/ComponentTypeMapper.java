package com.compoent.dao;

import com.compoent.entity.ComponentType;
import com.compoent.entity.ComponentTypeExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ComponentTypeMapper extends Mapper<ComponentType> {
    long countByExample(ComponentTypeExample example);

    List<ComponentType> selectTypeList(String id);
}