package com.cupofjava.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by oskar on 21.08.17.
 */
@RestController
@Controller
public class IndexController implements ErrorController {

    private static final String PATH = "/error";


    @RequestMapping(value = PATH)
    public String error() {
        return "errors/error";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
