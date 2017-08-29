package com.cupofjava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by oskar on 29.08.17.
 */

@Controller
public class PromotionController {


    @RequestMapping("/")
    public String mainPage(){
        return "promotion/main";
    }

    @RequestMapping("/promotions/{id}")
    public String promotionDetails(){
        return "promotion/promotionDetails";
    }
    @RequestMapping("/restaurators/1/restaurants/1/promotions/add")
    public String createPromotion(){
        return "promotion/createPromotionForm";
    }



}
