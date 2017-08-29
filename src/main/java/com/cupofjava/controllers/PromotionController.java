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
    @RequestMapping("/restaurators/{id}/restaurants/{id}/promotions/add")
    public String createPromotion(){
        return "promotion/createPromotionForm";
    }
    @RequestMapping("/restaurators/{id}/restaurants/{id}/promotions/")
    public String promotionList(){
        return "promotion/list";
    }



}
