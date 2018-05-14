package com.compoent.Service.Impl;

import com.compoent.Service.CompoentTypeService;
import com.compoent.dao.ComponentTypeMapper;
import com.compoent.entity.ComponeCntExample;
import com.compoent.entity.ComponentType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by fx on 2018/5/14.
 */
@Service
@AllArgsConstructor
public class CompoentTypeServiceImpl implements CompoentTypeService {

        private ComponentTypeMapper componentTypeMapper;

    @Override
    public List<ComponentType> queryList(String parentId) {
        return componentTypeMapper.selectTypeList(parentId);
    }

    @Override
    public int insertOne(ComponentType compoentType) {
        compoentType.setId(UUID.randomUUID().toString());
        return componentTypeMapper.insert(compoentType);
    }

    @Override
    public List<ComponentType> queryOne(String id) {
        ComponeCntExample componeCntExample = new ComponeCntExample();

        componeCntExample.createCriteria().andIdEqualTo(id);
        List<ComponentType> componeCnts = componentTypeMapper.selectByExample(componeCntExample);
        return componeCnts;
    }

    @Override
    public int deleteOne(String id) {
        return componentTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updataOne(ComponentType componentType) {
        return componentTypeMapper.updateByPrimaryKeySelective(componentType);
    }
}
