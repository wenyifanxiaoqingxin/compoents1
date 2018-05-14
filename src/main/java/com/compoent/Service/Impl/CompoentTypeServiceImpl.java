package com.compoent.Service.Impl;

import com.compoent.Service.CompoentTypeService;
import com.compoent.dao.CompoentTypeMapper;
import com.compoent.entity.CompoentType;
import com.compoent.entity.ComponeCntExample;
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

        private CompoentTypeMapper compoentTypeMapper;

    @Override
    public List<CompoentType> queryList(String parentId) {
        return compoentTypeMapper.selectTypeList(parentId);
    }

    @Override
    public int insertOne(CompoentType compoentType) {
        compoentType.setId(UUID.randomUUID().toString());
        return compoentTypeMapper.insert(compoentType);
    }

    @Override
    public List<CompoentType> queryOne(String id) {
        ComponeCntExample componeCntExample = new ComponeCntExample();

        componeCntExample.createCriteria().andIdEqualTo(id);
        List<CompoentType> componeCnts = compoentTypeMapper.selectByExample(componeCntExample);
        return componeCnts;
    }

    @Override
    public int deleteOne(String id) {
        return compoentTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updataOne(CompoentType compoentType) {
        return compoentTypeMapper.updateByPrimaryKeySelective(compoentType);
    }
}
