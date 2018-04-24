package com.compoent.compoent.Service.Impl;

import com.compoent.compoent.Service.CompoentService;
import com.compoent.compoent.Vo.CompoentVo;
import com.compoent.compoent.dao.ComponeCntMapper;
import com.compoent.compoent.entity.ComponeCnt;
import com.compoent.compoent.entity.ComponeCntExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by fx on 2018/1/2.
 */
@Service
public class CompoentServiceImpl implements CompoentService{


    @Autowired
    private ComponeCntMapper componeCntMapper;

    @Override
    public List<ComponeCnt> queryList(CompoentVo compoentVo) {
        ComponeCntExample componeCntExample = new ComponeCntExample();
        ComponeCntExample.Criteria criteria = componeCntExample.createCriteria();
        if(!"".equals(compoentVo.getName())&&compoentVo.getName()!=null){

            criteria.andNameLike("%"+compoentVo.getName()+"%");
        }
        if(!"".equals(compoentVo.getType())&&compoentVo.getType()!=null){

            criteria.andTypeEqualTo(compoentVo.getType());
        }


        return componeCntMapper.selectByExample(componeCntExample);
    }

    @Override
    public List<String> queryType() {
        return componeCntMapper.queryType();
    }

    @Override
    public int insertOne(ComponeCnt componeCnt) {
        componeCnt.setId(UUID.randomUUID().toString());
        return componeCntMapper.insert(componeCnt);
    }

    @Override
    public List<ComponeCnt> queryOne(String id) {
        ComponeCntExample componeCntExample = new ComponeCntExample();

        componeCntExample.createCriteria().andIdEqualTo(id);
        List<ComponeCnt> componeCnts = componeCntMapper.selectByExample(componeCntExample);
        return componeCnts;
    }

    @Override
    public int deleteOne(String id) {
        return componeCntMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updataOne(ComponeCnt componeCnt) {
        return componeCntMapper.updateByPrimaryKeySelective(componeCnt);
    }
}
