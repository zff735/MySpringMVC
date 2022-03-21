package com.atguigu.rest.controller;

import com.atguigu.rest.bean.Employee;
import com.atguigu.rest.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao dao;
    //查询所有员工
    @RequestMapping(value ="/employee",method= RequestMethod.GET)
    public String allEmployee(Model model){
        Collection<Employee> all = dao.getAll();
        model.addAttribute("allEmployee",all);
        return "employee_list";
    }

    //以id删除一个员工
    @RequestMapping(value="/employee/{id}",method=RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") int id){
        dao.delete(id);
//        forward的请求方式和原来的一致
//        redirect的请求方式为get请求
        return "redirect:/employee";
    }

    //添加一个员工
    @RequestMapping(value="/employee",method=RequestMethod.POST)
    public String save(Employee e){
        dao.save(e);
        return "redirect:employee";
    }

    //通过员工id获取其信息
    @RequestMapping(value="/employee/{id}",method=RequestMethod.GET)
    public String getOneEmp(@PathVariable("id") int id,Model model){
        Employee e = dao.get(id);
        model.addAttribute("e",e);
        return "employee_updata";
    }

    //
    @RequestMapping(value="/employee" ,method = RequestMethod.PUT)
    public String updata(Employee e){
        dao.save(e);
        return "redirect:employee";

    }
}
