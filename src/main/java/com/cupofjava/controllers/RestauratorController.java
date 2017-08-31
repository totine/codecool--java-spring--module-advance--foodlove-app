package com.cupofjava.controllers;

import com.cupofjava.domain.Product;
import com.cupofjava.domain.Restaurant;
import com.cupofjava.domain.Restaurator;
import com.cupofjava.services.RestaurantService;
import com.cupofjava.services.RestaurantServiceImpl;
import com.cupofjava.services.RestauratorService;
import com.cupofjava.services.RestauratorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by oskar on 29.08.17.
 */
@Controller
public class RestauratorController{

    private RestauratorService restauratorService;
    private RestaurantService restaurantService;

    @Autowired
    public RestauratorController(RestauratorService restauratorService, RestaurantService restaurantService) {
        this.restauratorService = restauratorService;
        this.restaurantService = restaurantService;
    }

    @RequestMapping("/restaurators/login")
    public String loginPage(Model model){
        model.addAttribute("restaurators", restauratorService.listAll());
        return "restaurator/login";
    }

    @RequestMapping("/restaurators/create")
    public String create2Restaurators(){
        Restaurant restaurant1 = new Restaurant("Marcello Ristorante", "Połnocna 2 Krakow");
        Restaurant restaurant2 = new Restaurant("U Funkiera", "Zachodnia 2 Kraków");
        Restaurant restaurant3 = new Restaurant("Atelier Amaro", "Ślusarska 2 Krakow");
        Restaurant restaurant4 = new Restaurant("Studio Kulinarne", "Inna 2 Kraków");
        Set<Restaurant> restaurantSet = new HashSet<>();
        restaurantSet.add(restaurant1);
        restaurantSet.add(restaurant2);
        Set<Restaurant> restaurantSet2 = new HashSet<>();
        restaurantSet2.add(restaurant3);
        restaurantSet2.add(restaurant4);
        Restaurator restaurator = new Restaurator("Magda Gessler", restaurantSet);
        Restaurator restaurator2 = new Restaurator("Modest Amaro", restaurantSet2);
        restaurantService.saveOrUpdate(restaurant1);
        restaurantService.saveOrUpdate(restaurant2);
        restaurantService.saveOrUpdate(restaurant3);
        restaurantService.saveOrUpdate(restaurant4);
        restauratorService.saveOrUpdate(restaurator);
        restauratorService.saveOrUpdate(restaurator2);
        return "redirect:/restaurators/login";
    }

    @RequestMapping("/restaurators/{id}")
    public String restauratorPanel(@PathVariable String id, Model model){
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.addAll(restauratorService.getById(Long.valueOf(id)).getRestaurants());
        model.addAttribute("restaurantList", restaurantList);
        return "restaurator/restauratorPanel";
    }



}
