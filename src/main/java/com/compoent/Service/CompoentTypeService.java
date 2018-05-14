package com.compoent.Service;

import com.compoent.entity.ComponentType;

import java.util.List;

/**
 * Created by fx on 2018/5/14.
 */
public interface CompoentTypeService {


    List<ComponentType> queryList(String parentId);


    int insertOne(ComponentType CompoentType);

    List<ComponentType> queryOne(String id);

    int deleteOne(String id);

    int updataOne(ComponentType CompoentType);
}
