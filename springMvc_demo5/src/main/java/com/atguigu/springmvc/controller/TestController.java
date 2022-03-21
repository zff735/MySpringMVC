package com.atguigu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value="/**/testInterceptor")
    public String testInterceptor(){
        return "success";
    }

    @RequestMapping(value="/testException")
    public String testException(){
        System.out.println(1 / 0);
        return "success";
    }
}
