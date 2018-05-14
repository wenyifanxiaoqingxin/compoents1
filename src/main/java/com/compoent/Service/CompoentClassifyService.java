package com.compoent.Service;

import com.compoent.entity.ComponentType;

import java.util.List;

/**
 * Created by fx on 2018/5/14.
 */
public interface CompoentClassifyService {


    List<ComponentType> queryList();


    int insertOne(ComponentType ComponentType);

    List<ComponentType> queryOne(String id);

    int deleteOne(String id);

    int updataOne(ComponentType ComponentType);
    List<ComponentType> queryTypeList(String parentId);
}
