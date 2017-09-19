package com.cupofjava.controllers;

import com.cupofjava.domain.Product;
import com.cupofjava.domain.ProductFeature;
import com.cupofjava.services.AttributeService;
import com.cupofjava.services.ProductFeatureService;
import com.cupofjava.services.ProductService;
import com.cupofjava.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class ProductController {
    private ProductService productService;
    private ProductFeatureService productFeatureService;
    private RestaurantService restaurantService;
    private AttributeService attributeService;

    @Autowired
    public ProductController(ProductService productService, ProductFeatureService productFeatureService,
                             RestaurantService restaurantService, AttributeService attributeService) {
        this.productService = productService;
        this.productFeatureService = productFeatureService;
        this.restaurantService = restaurantService;
        this.attributeService = attributeService;
    }

    @RequestMapping("restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/")
    public String listProducts(Model model, @PathVariable(name = "restaurant_id") String restaurant_id){
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("products", restaurantService.getById(Long.valueOf(restaurant_id)).getProducts());
        model.addAttribute("productsFeatures", productFeatureService.listAll());
        return "dashboard/restaurant-products";
    }

    @RequestMapping("restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/{id}")
    public String getProduct(@PathVariable String id, @PathVariable String restaurant_id, Model model){
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("product", productService.getById(Long.valueOf(id)));
        return "dashboard/restaurant-product-show";
    }

    @RequestMapping("/restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/edit/{product_id}")
    public String editProduct(@PathVariable(name = "product_id") String product_id,
                              @PathVariable(name = "restaurant_id") String restaurant_id,
                              Model model){
        Product product = productService.getById(Long.valueOf(product_id));
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("productForm", product);
        model.addAttribute("productFeatureForm", product.getProductFeature());
        return "dashboard/restaurant-product-add";
    }

    @RequestMapping("/restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/add")
    public String newProduct(@PathVariable(name = "restaurant_id") String restaurant_id, Model model){
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("productForm", new Product());
        model.addAttribute("productFeatureForm", new ProductFeature());
        model.addAttribute("attributes", attributeService.listAll());
        return "dashboard/restaurant-product-add";
    }

    @RequestMapping(value = "/restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid Product product, ProductFeature productFeature, BindingResult bindingResult,
                                      @PathVariable(name = "restaurant_id") String restaurant_id,
                                      @RequestParam("selected_attribute_id") String selected_attribute_id){
        if(bindingResult.hasErrors()){
            return "dashboard/restaurant-product-add";
        }
        System.out.println("\n\n");
        System.out.println(selected_attribute_id);
        System.out.println("\n\n");

        productService.saveProductData(product, productFeature, Long.valueOf(restaurant_id));
        return "redirect:/restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/" + product.getId();
    }

    @RequestMapping("/restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/delete/{product_id}")
    public String delete(@PathVariable(name = "restaurant_id") String restaurant_id,
                         @PathVariable(name = "product_id") String product_id){
        restaurantService.getById(Long.valueOf(restaurant_id)).getProducts()
                .remove(productService.getById(Long.valueOf(product_id)));
        productService.delete(Long.valueOf(product_id));
        return "redirect:/restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/";
    }
}
