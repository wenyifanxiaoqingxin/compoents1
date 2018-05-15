package com.compoent.control;

import com.compoent.Service.CompoentClassifyService;
import com.compoent.Service.CompoentService;
import com.compoent.Service.CompoentTypeService;
import com.compoent.Vo.CompoentVo;
import com.compoent.common.ReturnData;
import com.compoent.config.WebSecurityConfig;
import com.compoent.entity.ComponeCnt;
import com.compoent.entity.ComponentType;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    @Autowired
    private CompoentTypeService compoentTypeService;

    @Autowired
    private CompoentClassifyService compoentClassifyService;
    @RequestMapping("/html")
    public String html(Model model, HttpSession session){
        List<ComponentType> compoentClassifys = new ArrayList<>();
         compoentClassifys = compoentClassifyService.queryList();
        List<ComponentType> compoentTypes = compoentTypeService.queryList(compoentClassifys.get(0).getId());
        model.addAttribute("classifyList",compoentClassifys);
        model.addAttribute("typeList",compoentTypes);
        model.addAttribute("username",session.getAttribute(WebSecurityConfig.SESSION_KEY));
        return "/index/index";
    }

    @RequestMapping("/user")
    public String userhtml(Model model, HttpSession session){
        List<ComponentType> compoentClassifys = new ArrayList<>();
        compoentClassifys = compoentClassifyService.queryList();
        List<ComponentType> compoentTypes = compoentTypeService.queryList(compoentClassifys.get(0).getId());
        model.addAttribute("classifyList",compoentClassifys);
        model.addAttribute("typeList",compoentTypes);
        model.addAttribute("username",session.getAttribute(WebSecurityConfig.SESSION_KEY));
        return "/user/index";
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
            List<ComponeCnt> componeCnts = compoentService.queryOne(id);
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
    public ReturnData queryType(String classify){

        ReturnData returnData = new ReturnData();
        try {
            returnData.setData(compoentTypeService.queryList(classify));
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
