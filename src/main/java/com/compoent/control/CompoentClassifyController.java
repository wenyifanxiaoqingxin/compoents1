package com.compoent.control;

import com.compoent.common.ReturnData;
import com.compoent.Service.CompoentClassifyService;
import com.compoent.Vo.CompoentVo;
import com.compoent.entity.ComponentType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fx on 2018/5/14.
 */
@Controller
@AllArgsConstructor
@RequestMapping("/classify")
public class CompoentClassifyController {

    private CompoentClassifyService compoentClassifyService;

    @RequestMapping("/html")
    public String html(){

        return "/classify/index";
    }

    @RequestMapping("/list")
    @ResponseBody
    public ReturnData queryList(CompoentVo compoentVo){
        ReturnData returnData = new ReturnData();
        PageHelper.startPage(Integer.parseInt(compoentVo.getPageNumber()),Integer.parseInt(compoentVo.getPageSize()));

        try {
            List<ComponentType> componentTypes = new ArrayList<>();
            componentTypes = compoentClassifyService.queryList();
            PageInfo<ComponentType> pageInfo = new PageInfo<>(componentTypes);
            returnData.setData(pageInfo);
            returnData.setMessage("查询成功");
            returnData.setCode(ReturnData.RESULT_CODE_0000);
        }catch (Exception e){

            returnData.setCode(ReturnData.RESULT_CODE_0001);
            returnData.setMessage("查询失败");
            System.out.println(e.getMessage());

        }
       return returnData;
    }

    @RequestMapping("/findOne/{id}")
    @ResponseBody
    public ReturnData findOne(@PathVariable("id") String id){
        ReturnData returnData = new ReturnData();

        try {
            List<ComponentType> componeCnts = compoentClassifyService.queryOne(id);
            returnData.setData(componeCnts);
            returnData.setCode(ReturnData.RESULT_CODE_0000);
            returnData.setMessage("查询成功");
        }catch (Exception e){
            e.printStackTrace();
            returnData.setCode(ReturnData.RESULT_CODE_0001);
            returnData.setMessage("查询失败"+e.getMessage());
        }
        return  returnData;
    }

    @RequestMapping("/change")
    @ResponseBody
    public ReturnData changOne(ComponentType componentType){
        ReturnData returnData = new ReturnData();
        try {
            returnData.setData(compoentClassifyService.updataOne(componentType));
            returnData.setCode(ReturnData.RESULT_CODE_0000);
            returnData.setMessage("查询成功");
        }catch (Exception e){
            e.printStackTrace();
            returnData.setCode(ReturnData.RESULT_CODE_0001);
            returnData.setMessage("查询失败");
        }
        return  returnData;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ReturnData insertOne(ComponentType componentType,Model model){
        ReturnData returnData = new ReturnData();
        try {
            returnData.setData(compoentClassifyService.insertOne(componentType));
            returnData.setCode(ReturnData.RESULT_CODE_0000);
            returnData.setMessage("查询成功");
        }catch (Exception e){
            e.printStackTrace();
            returnData.setCode(ReturnData.RESULT_CODE_0001);
            returnData.setMessage("插入失败");
        }

        return returnData;
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public ReturnData deleteOne(@PathVariable("id") String id){

        ReturnData returnData = new ReturnData();
        try {
            returnData.setData(compoentClassifyService.deleteOne(id));
            returnData.setCode(ReturnData.RESULT_CODE_0000);
            returnData.setMessage("查询成功");
        }catch (Exception e){
            e.printStackTrace();
            returnData.setCode(ReturnData.RESULT_CODE_0001);
            returnData.setMessage("查询失败");
        }
        return returnData;
    }
}
