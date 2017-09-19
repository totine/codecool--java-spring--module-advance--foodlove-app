package com.cupofjava.controllers;

import com.cupofjava.domain.Attribute;
import com.cupofjava.domain.Restaurant;
import com.cupofjava.domain.Restaurator;
import com.cupofjava.services.AttributeService;
import com.cupofjava.services.RestaurantService;
import com.cupofjava.services.RestauratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
public class RestauratorController{

    private RestauratorService restauratorService;
    private RestaurantService restaurantService;
    private AttributeService attributeService;

    @Autowired
    public RestauratorController(RestauratorService restauratorService, RestaurantService restaurantService,
                                 AttributeService attributeService) {
        this.restauratorService = restauratorService;
        this.restaurantService = restaurantService;
        this.attributeService = attributeService;
    }

    @RequestMapping("/restaurators/login")
    public String loginPage(Model model){
        model.addAttribute("restaurators", restauratorService.listAll());
        return "restaurator/login";
    }

    @RequestMapping("/restaurators/create")
    public String createBasicRestaurantorsRestaurantsAttributes(){
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

        restaurant1.setRestaurator(restaurator);
        restaurant2.setRestaurator(restaurator);

        restaurant3.setRestaurator(restaurator2);
        restaurant4.setRestaurator(restaurator2);

        restaurantService.saveOrUpdate(restaurant1);
        restaurantService.saveOrUpdate(restaurant2);
        restaurantService.saveOrUpdate(restaurant3);
        restaurantService.saveOrUpdate(restaurant4);    ///Trzeba zrobić to jakoś w konstruktorze(chyba), zeby samo dodawało własciciela do restauracji, ale to skomplikowane.

        Attribute glutenFree = new Attribute("Gluten free");
        Attribute lactoseFree = new Attribute("Lactose free");
        Attribute sugarFree = new Attribute("Sugar free");
        Attribute vegan = new Attribute("Vegan");
        Attribute vegetarian = new Attribute("Vegetarian");
        Attribute soup = new Attribute("Soup");
        Attribute meat = new Attribute("Meat");
        Attribute sweets = new Attribute("Sweets");
        Attribute dessert = new Attribute("Dessert");
        Attribute salad = new Attribute("Salad");
        Attribute sandwich = new Attribute("Sandwich");
        Attribute beef = new Attribute("Beef");
        Attribute chicken = new Attribute("Chicken");
        Attribute pork = new Attribute("Pork");
        Attribute curry = new Attribute("Curry");
        Attribute quiche = new Attribute("Quiche");
        Attribute beverage = new Attribute("Beverage");
        Attribute coffee = new Attribute("Coffee");
        Attribute juice = new Attribute("Juice");
        Attribute smoothie = new Attribute("Smoothie");

        attributeService.saveOrUpdate(glutenFree);
        attributeService.saveOrUpdate(lactoseFree);
        attributeService.saveOrUpdate(sugarFree);
        attributeService.saveOrUpdate(vegan);
        attributeService.saveOrUpdate(vegetarian);
        attributeService.saveOrUpdate(soup);
        attributeService.saveOrUpdate(meat);
        attributeService.saveOrUpdate(sweets);
        attributeService.saveOrUpdate(dessert);
        attributeService.saveOrUpdate(salad);
        attributeService.saveOrUpdate(sandwich);
        attributeService.saveOrUpdate(beef);
        attributeService.saveOrUpdate(chicken);
        attributeService.saveOrUpdate(pork);
        attributeService.saveOrUpdate(curry);
        attributeService.saveOrUpdate(quiche);
        attributeService.saveOrUpdate(beverage);
        attributeService.saveOrUpdate(coffee);
        attributeService.saveOrUpdate(juice);
        attributeService.saveOrUpdate(smoothie);

        return "redirect:/restaurators/login";
    }

    @RequestMapping("/restaurators/{id}")
    public String restauratorPanel(@PathVariable String id, Model model){
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.addAll(restauratorService.getById(Long.valueOf(id)).getRestaurants());
        model.addAttribute("restaurantList", restaurantList);
        return "/dashboard/base";
    }
}
