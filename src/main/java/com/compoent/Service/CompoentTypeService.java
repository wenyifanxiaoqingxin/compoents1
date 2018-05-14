package com.compoent.Service;

import com.compoent.entity.CompoentType;

import java.util.List;

/**
 * Created by fx on 2018/5/14.
 */
public interface CompoentTypeService {


    List<CompoentType> queryList(String parentId);


    int insertOne(CompoentType CompoentType);

    List<CompoentType> queryOne(String id);

    int deleteOne(String id);

    int updataOne(CompoentType CompoentType);
}
