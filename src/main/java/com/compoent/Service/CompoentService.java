package com.compoent.Service;

import com.compoent.Vo.CompoentVo;
import com.compoent.entity.ComponeCnt;

import java.util.List;

/**
 * Created by fx on 2018/1/2.
 */
public interface CompoentService {

    List<ComponeCnt> queryList(CompoentVo compoentVo);

    List<String> queryType();

    int insertOne(ComponeCnt componeCnt);

    List<ComponeCnt> queryOne(String id);

    int deleteOne(String id);

    int updataOne(ComponeCnt componeCnt);
}
