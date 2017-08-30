package com.cupofjava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by oskar on 29.08.17.
 */
@Controller
public class RestaurantController {

    @RequestMapping("/restaurators/{id}/restaurants/{id}")
    public String restaurantPanel(){
        return "restaurant/restaurantPanel";
    }

}

