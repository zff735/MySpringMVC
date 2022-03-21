package com.atguigu.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class TestAtturibute {
    //通过原生ServletAPI共享request域数据
    @RequestMapping(value ="/testByServletAPI")
    public String testByServletAPI(HttpServletRequest req){
        req.setAttribute("requestdata","hello world");
        return "success";
    }

    //通过MoudelAndView共享request域数据
    @RequestMapping(value="/testModelAndview")
    public ModelAndView testModelAndView(){
        //1.创建ModelAndView对象
        ModelAndView mav=new ModelAndView();
        //2.向request域中添加数据
        mav.addObject("requestdata","ModelAndView");
        //3.设置视图,实现页面跳转
        mav.setViewName("success");
        return mav;
    }

    //通过Model共享request域数据
    @RequestMapping(value="/testModel")
    public String testModel(Model model){
        //向request域中添加数据
        model.addAttribute("requestdata","hello Model");
        return "success";
    }

    //通过map集合共享request域数据
    @RequestMapping(value="/testMap")
    public String testMap(Map<String,Object> map){
        //向request中添加数据
        map.put("requestdata","hello map");
        return "success";
    }

    //通过ModelMap共享request域数据
    @RequestMapping(value="/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("requestdata","hello modelMap");
        return "success";

    }
}
