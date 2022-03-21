package com.atguigu.springmvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*拦截器
* 先继承HandlerInterceptor接口
* 到springMVC.xml中配置拦截器*/

@Component
public class FirstInterceptor implements HandlerInterceptor {
//    在请求方法之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("hello,preHandle");
//        false表示拦截,则控制器方法和下面两个方法都不会执行,true表示不拦截
        return true;
    }

//    在请求方法之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("hello,postHandle");
    }

//    在视图渲染之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("hello,afterCompletion");
    }
}
