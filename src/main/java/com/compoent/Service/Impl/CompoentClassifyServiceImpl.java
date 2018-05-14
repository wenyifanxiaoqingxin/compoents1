package com.compoent.Service.Impl;

import com.compoent.Service.CompoentClassifyService;
import com.compoent.dao.CompoentTypeMapper;
import com.compoent.dao.ComponentTypeMapper;
import com.compoent.entity.CompoentType;
import com.compoent.entity.CompoentTypeExample;
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
public class CompoentClassifyServiceImpl implements CompoentClassifyService {

        private ComponentTypeMapper componentTypeMapper;

    @Override
    public List<ComponentType> queryList() {

        CompoentTypeExample compoentTypeExample = new CompoentTypeExample();
        CompoentTypeExample.Criteria criteria = compoentTypeExample.createCriteria();
        criteria.andTypeParentIdIsNull();

        return componentTypeMapper.selectByExample(compoentTypeExample);
    }

    @Override
    public int insertOne(ComponentType componentType) {
        componentType.setId(UUID.randomUUID().toString());
        return componentTypeMapper.insert(componentType);
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
    @Override
    public List<ComponentType> queryTypeList(String parentId) {

        CompoentTypeExample compoentTypeExample = new CompoentTypeExample();
        CompoentTypeExample.Criteria criteria = compoentTypeExample.createCriteria();
        criteria.andTypeParentIdEqualTo(parentId);

        return componentTypeMapper.selectByExample(compoentTypeExample);
    }

}
