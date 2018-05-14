package com.compoent.dao;

import com.compoent.entity.CompoentType;
import com.compoent.entity.CompoentTypeExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CompoentTypeMapper extends Mapper<CompoentType> {
    long countByExample(CompoentTypeExample example);
    List<CompoentType> selectTypeList(String id);
}