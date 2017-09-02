package com.cupofjava.controllers;

import com.cupofjava.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PromotionController {

    private RestaurantService restaurantService;

    @Autowired
    public PromotionController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/")
    public String mainPage(){
        return "promotion/main";
    }

    @RequestMapping("/promotions/{id}")
    public String promotionDetails(){
        return "promotion/promotionDetails";
    }
    @RequestMapping("/restaurators/{id}/restaurants/{restaurant_id}/promotions/add")
    public String createPromotion(@PathVariable(name = "restaurant_id") String restaurant_id, Model model){
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        return "promotion/createPromotionForm";
    }
    @RequestMapping("/restaurators/{id}/restaurants/{restaurant_id}/promotions/")
    public String promotionList(@PathVariable(name = "restaurant_id") String restaurant_id, Model model){
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        return "promotion/list";
    }



}
