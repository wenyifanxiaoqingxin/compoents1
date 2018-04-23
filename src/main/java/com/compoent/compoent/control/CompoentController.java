package com.compoent.compoent.control;

import com.compoent.compoent.Service.CompoentService;
import com.compoent.compoent.Vo.CompoentVo;
import com.compoent.compoent.common.ReturnData;
import com.compoent.compoent.entity.ComponeCnt;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fx on 2018/1/2.
 */
@RequestMapping("/compoent")
@Controller
public class CompoentController {

    @Autowired
    private CompoentService compoentService;

    @RequestMapping("/html")
    public String html(Model model){

        List<String> componeCnts = compoentService.queryType();
        model.addAttribute("typeList",componeCnts);
        return "/index/index";
    }
    @RequestMapping("/data")
    @ResponseBody
    public ReturnData getData(CompoentVo compoentVo){

        ReturnData returnData = new ReturnData();

        try{
            PageHelper.startPage(Integer.parseInt(compoentVo.getPageNumber()),Integer.parseInt(compoentVo.getPageSize()));

            List<ComponeCnt> componeCnts = new ArrayList<>();

            componeCnts = compoentService.queryList(compoentVo);

            PageInfo pages = new PageInfo(componeCnts);
            returnData.setCode(ReturnData.RESULT_CODE_0000);
            returnData.setData(pages);

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
            ComponeCnt componeCnt = compoentService.queryOne(id);
            returnData.setData(componeCnt);
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
    public ReturnData changOne(ComponeCnt componeCnt){
        ReturnData returnData = new ReturnData();
        try {
            returnData.setData(compoentService.updataOne(componeCnt));
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
    public ReturnData insertOne(ComponeCnt componeCnt,Model model){
        ReturnData returnData = new ReturnData();
        try {
            returnData.setData(compoentService.insertOne(componeCnt));
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
            returnData.setData(compoentService.deleteOne(id));
            returnData.setCode(ReturnData.RESULT_CODE_0000);
            returnData.setMessage("查询成功");
        }catch (Exception e){
            e.printStackTrace();
            returnData.setCode(ReturnData.RESULT_CODE_0001);
            returnData.setMessage("查询失败");
        }
        return returnData;
    }

    @RequestMapping("/queryType")
    @ResponseBody
    public ReturnData queryType(){

        ReturnData returnData = new ReturnData();
        try {
            returnData.setData(compoentService.queryType());
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
