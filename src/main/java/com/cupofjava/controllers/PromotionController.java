package com.cupofjava.controllers;

import com.cupofjava.domain.Product;
import com.cupofjava.domain.Promotion;
import com.cupofjava.domain.Restaurant;
import com.cupofjava.services.ProductService;
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
    private ProductService productService;

    @Autowired
    public PromotionController(RestaurantService restaurantService, PromotionService promotionService, ProductService productService) {
        this.restaurantService = restaurantService;
        this.promotionService = promotionService;
        this.productService = productService;
    }


    @RequestMapping("/")
    public String mainPage(Model model){
        model.addAttribute("promotions", promotionService.listAll());
        return "promotion/main";
    }

    @RequestMapping("/promotions/{id}")
    public String promotionDetails(){
        return "promotion/promotionDetails";
    }


    @GetMapping("/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/add")
    public String createPromotion(@PathVariable(name = "restaurant_id") String restaurant_id,
                                  @PathVariable(name = "restaurator_id") String restaurator_id,Model model){
        model.addAttribute("restaurator_id", restaurator_id);
        model.addAttribute("restaurant_id", restaurant_id);
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("products", restaurantService.getById(Long.valueOf(restaurant_id)).getProducts());
        model.addAttribute("promotionForm", new Promotion());
        return "promotion/createPromotionForm";
    }

    @RequestMapping(value = "/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/", method = RequestMethod.GET)
    public String promotionList(@PathVariable(name = "restaurant_id") String restaurant_id,
                                @PathVariable(name = "restaurator_id") String restaurator_id,Model model){
        model.addAttribute("restaurator_id", restaurator_id);
        model.addAttribute("restaurant_id", restaurant_id);
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("promotions", restaurantService.getById(Long.valueOf(restaurant_id)).getPromotions());
        return "promotion/list";
    }

    @RequestMapping(value = "/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/", method = RequestMethod.POST)
    public String promotionList(@Valid Promotion promotion, BindingResult bindingResult,
            @PathVariable(name = "restaurant_id") String restaurant_id, Model model){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getModel());
            return "errors/error";
        }
        Long productId =  promotion.getProductId();
        promotion.setProduct(productService.getById(productId));
        Promotion savedPromotion = promotionService.saveOrUpdate(promotion);
        Restaurant restaurant = restaurantService.getById(Long.valueOf(restaurant_id));
        restaurant.getPromotions().add(promotion);
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        return "redirect:/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/" + savedPromotion.getId();

    }
    @RequestMapping(value = "/restaurators/{restaurator_id}/restaurants/{restaurant_id}/promotions/{promotion_id}")
    public String viewPromotion(@PathVariable(name = "restaurant_id") String restaurant_id,
                                @PathVariable(name = "restaurator_id") String restaurator_id,
                                @PathVariable(name = "promotion_id") String promotion_id,Model model){
        model.addAttribute("restaurator_id", restaurator_id);
        model.addAttribute("restaurant_id", restaurant_id);
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("promotion", promotionService.getById(Long.valueOf(promotion_id)));
        return "promotion/show";
    }


}
