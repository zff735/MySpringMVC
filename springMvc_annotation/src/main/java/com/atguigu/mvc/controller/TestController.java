package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value ="testannotation")
    public String testAnnotation(){
        int i=1/0;
        return "success";
    }
}
