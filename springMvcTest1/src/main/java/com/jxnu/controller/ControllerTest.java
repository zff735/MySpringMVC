package com.jxnu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {
    @RequestMapping("/index")
    public String test(){
        return "index";
    }
    @RequestMapping("/get")
    public String test1(Model model){
        String name="springmvc";
        model.addAttribute("name", name);
        model.addAttribute("name", name);
        model.addAttribute("age",18);
        model.addAttribute("age",18);
        model.addAttribute("age",18);
        return "show";
    }

}
