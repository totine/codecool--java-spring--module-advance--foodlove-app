package com.cupofjava.controllers;

import com.cupofjava.services.RestaurantService;
import com.cupofjava.services.RestauratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by oskar on 29.08.17.
 */
@Controller
public class RestaurantController {


    private RestauratorService restauratorService;
    private RestaurantService restaurantService;

    public RestaurantController(RestauratorService restauratorService, RestaurantService restaurantService) {
        this.restauratorService = restauratorService;
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/restaurators/{restaurator_id}/restaurants/{restaurant_id}")
    public String restaurantPanel(@PathVariable("restaurator_id") String restaurator_id, @PathVariable("restaurant_id") String restaurant_id, Model model) {
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        return "restaurant/restaurantPanel";
    }

}

