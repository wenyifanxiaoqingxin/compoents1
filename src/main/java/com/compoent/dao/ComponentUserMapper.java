package com.compoent.dao;

import com.compoent.entity.ComponentUser;
import com.compoent.entity.ComponentUserExample;
import tk.mybatis.mapper.common.Mapper;

public interface ComponentUserMapper extends Mapper<ComponentUser> {
    long countByExample(ComponentUserExample example);
}