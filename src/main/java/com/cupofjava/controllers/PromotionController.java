package com.cupofjava.controllers;

import com.cupofjava.domain.Promotion;
import com.cupofjava.services.PromotionService;
import com.cupofjava.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class PromotionController {

    private RestaurantService restaurantService;
    private PromotionService promotionService;

    @Autowired
    public PromotionController(RestaurantService restaurantService, PromotionService promotionService) {
        this.restaurantService = restaurantService;
        this.promotionService = promotionService;
    }


    @RequestMapping("/")
    public String mainPage(Model model){
        model.addAttribute("promotions", promotionService.listAll());
        return "MDB-Free/index";
    }

    @RequestMapping("/promotions/{id}")
    public String promotionDetails(){
        return "MDB-Free/productView2";
    }

    @RequestMapping("/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/edit/{promotion_id}")
    public String editPromotion(@PathVariable(name = "promotion_id") String promotion_id,
                                @PathVariable(name = "restaurant_id") String restaurant_id,
                                Model model){
        Promotion promotion = promotionService.getById(Long.valueOf(promotion_id));
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("promotion", promotion);
        model.addAttribute("products", restaurantService.getById(Long.valueOf(restaurant_id)).getProducts());
        return "dashboard/restaurant-promotion-add";
    }


    @GetMapping("/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/add")
    public String createPromotion(@PathVariable(name = "restaurant_id") String restaurant_id, Model model){
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("products", restaurantService.getById(Long.valueOf(restaurant_id)).getProducts());
        model.addAttribute("promotion", new Promotion());
        return "dashboard/restaurant-promotion-add";
    }

    @RequestMapping(value = "/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/", method = RequestMethod.GET)
    public String promotionList(@PathVariable(name = "restaurant_id") String restaurant_id, Model model){
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("promotions", restaurantService.getById(Long.valueOf(restaurant_id)).getPromotions());
        return "dashboard/restaurant-promotions";
    }

    @RequestMapping(value = "/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/", method = RequestMethod.POST)
    public String promotionList(@Valid Promotion promotion, BindingResult bindingResult,
                                @PathVariable(name = "restaurant_id") String restaurant_id, Model model){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getModel());
            return "errors/error";
        }
        promotionService.savePromotionData(promotion, Long.valueOf(restaurant_id));
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        return "redirect:/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/" + promotion.getId();

    }
    @RequestMapping(value = "/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/{promotion_id}")
    public String viewPromotion(@PathVariable(name = "restaurant_id") String restaurant_id,
                                @PathVariable(name = "promotion_id") String promotion_id,Model model){
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("promotion", promotionService.getById(Long.valueOf(promotion_id)));
        return "dashboard/restaurant-promotion-show";
    }

    @RequestMapping("/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/delete/{id}")
    public String delete(@PathVariable String id){
        promotionService.delete(Long.valueOf(id));
        return "redirect:/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/";
    }
}
