package com.managment.palladium.controllers;

import com.managment.palladium.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeService empService;

    @GetMapping("/")
    public String displayHome(){

        return "index";
    }



}
