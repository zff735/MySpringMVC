package com.atguigu.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class TestSessionAtturibute {
    //向session中添加共享数据
    @RequestMapping(value="/testSession")
    public String testSessionAtturibute(HttpSession session){
        session.setAttribute("sessionText","hello session");
        return "success";
    }
    
    //向application域中共享数据
    @RequestMapping(value="/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("applicationText","hello,application");
        return "success";
    }
}
