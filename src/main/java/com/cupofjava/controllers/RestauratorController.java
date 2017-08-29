package com.cupofjava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by oskar on 29.08.17.
 */
@Controller
public class RestauratorController{

    @RequestMapping("/restaurators/login")
    public String loginPage(){
        return "restaurator/login";
    }

    @RequestMapping("/restaurators/{id}")
    public String restauratorPanel(){
        return "restaurator/restauratorPanel";
    }



}
