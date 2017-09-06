package com.cupofjava.controllers;

import com.cupofjava.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/restaurators/{restaurator_id}/restaurants/{restaurant_id}")
    public String restaurantPanel(@PathVariable("restaurant_id") String restaurant_id, Model model) {
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
 //       return "restaurant/restaurantPanel";
        return "dashboard/restaurant";
    }
}

