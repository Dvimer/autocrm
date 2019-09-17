package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model theModel) {
        theModel.addAttribute("theDate", new java.util.Date());
        return "helloworld";
    }

    @GetMapping("/emptest")
    public String sayHello1(Model theModel) {
        Employee employee = new Employee();
        employee.setDate(new Date());
        employee.setFirstName("Dima");
        employee.setLastName("Familia");

        Employee employee1 = new Employee();
        employee.setDate(new Date());
        employee.setFirstName("Nikita");
        employee.setLastName("Druzina");
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        theModel.addAttribute("employees", list);

        return "employees/list-employees";
    }
}








