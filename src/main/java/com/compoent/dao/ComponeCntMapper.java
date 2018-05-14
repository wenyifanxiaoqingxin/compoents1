package com.compoent.dao;

import com.compoent.entity.ComponeCnt;
import com.compoent.entity.ComponeCntExample;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ComponeCntMapper extends Mapper<ComponeCnt> {
    long countByExample(ComponeCntExample example);

    List<String> queryType();
}