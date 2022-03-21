package com.atguigu.springmvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//基于注解的异常处理
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({ArithmeticException.class})
    public String handlerException(Model model,Exception ex){
        model.addAttribute("ex",ex);
        return "error";
    }
}
