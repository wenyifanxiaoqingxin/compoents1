package com.compoent.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fx on 2018/5/14.
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String html(){

        return "login";
    }
}
