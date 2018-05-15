package com.compoent.control;

import com.compoent.Service.ComponentUserService;
import com.compoent.common.ReturnData;
import com.compoent.config.WebSecurityConfig;
import com.compoent.entity.ComponentUser;
import javafx.scene.chart.PieChartBuilder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

/**
 * Created by fx on 2018/5/14.
 */
@Controller
@AllArgsConstructor
public class LoginController {

    private ComponentUserService componentUserService;

    @RequestMapping("/login")
    public String html(){

        return "login";
    }

    @RequestMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY) String userName,@SessionAttribute(WebSecurityConfig.SESSION_ROLE) String roles, Model model){


        //管理员
        if("1".equals(roles)){
            return "redirect:/compoent/html";

        }else{

            return "redirect:/compoent/user";
        }
    }

    @RequestMapping("/loginPost")
    @ResponseBody
    public ReturnData loginPost(String userName, String password,String roles, HttpSession session){
            ReturnData returnData = new ReturnData();

              ComponentUser componentUser =  componentUserService.selectOne(userName,password,roles);
            if(componentUser==null||componentUser.getId()==null){
                returnData.setMessage("用户名或密码错误");
                returnData.setCode(ReturnData.RESULT_CODE_0001);
                return returnData;

            }
            session.setAttribute(WebSecurityConfig.SESSION_KEY,userName);
            session.setAttribute(WebSecurityConfig.SESSION_ROLE,roles);
            returnData.setCode(ReturnData.RESULT_CODE_0000);
            returnData.setMessage("登录成功");
            return returnData;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // 移除session
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "redirect:/login";
    }
}
