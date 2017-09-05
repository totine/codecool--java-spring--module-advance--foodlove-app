package com.cupofjava.controllers;

import com.cupofjava.domain.Product;
import com.cupofjava.domain.ProductFeature;
import com.cupofjava.domain.Restaurant;
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

import javax.validation.Valid;


@Controller
public class ProductController {
    private ProductService productService;
    private ProductFeatureService productFeatureService;
    private RestaurantService restaurantService;

    @Autowired
    public ProductController(ProductService productService, ProductFeatureService productFeatureService, RestaurantService restaurantService) {
        this.productService = productService;
        this.productFeatureService = productFeatureService;
        this.restaurantService = restaurantService;
    }

    @RequestMapping("restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/")
    public String listProducts(Model model, @PathVariable(name = "restaurant_id") String restaurant_id){
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("products", restaurantService.getById(Long.valueOf(restaurant_id)).getProducts());
        model.addAttribute("productsFeatures", productFeatureService.listAll());
        return "product/list";
    }

    @RequestMapping("restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/{id}")
    public String getProduct(@PathVariable String id, @PathVariable String restaurant_id, Model model){
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("product", productService.getById(Long.valueOf(id)));
        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Product product = productService.getById(Long.valueOf(id));
        model.addAttribute("productForm", product);
        return "product/productform";
    }

    @RequestMapping("/restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/add")
    public String newProduct(@PathVariable(name = "restaurator_id") String restaurator_id,
                             @PathVariable(name = "restaurant_id") String restaurant_id, Model model){
        model.addAttribute("restaurator_id", restaurator_id);
        model.addAttribute("restaurant_id", restaurant_id);
        model.addAttribute("restaurant", restaurantService.getById(Long.valueOf(restaurant_id)));
        model.addAttribute("productForm", new Product());
        model.addAttribute("productFeatureForm", new ProductFeature());
        return "product/productform";
    }

    @RequestMapping(value = "/restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid Product product, ProductFeature productFeature, BindingResult bindingResult,
    @PathVariable(name = "restaurator_id") String restaurator_id, @PathVariable(name = "restaurant_id") String restaurant_id){
        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        ProductFeature savedProductFeature = productFeatureService.saveOrUpdateProductFeature(productFeature);
        Product savedProduct = productService.saveOrUpdateProduct(product);
        savedProduct.setProductFeature(savedProductFeature);
        savedProductFeature.setProduct(savedProduct);
        Restaurant restaurant = restaurantService.getById(Long.valueOf(restaurant_id));
        restaurant.getProducts().add(savedProduct);
        restaurantService.saveOrUpdate(restaurant);
        return "redirect:/restaurators/{restaurator_id}/restaurants/{restaurant_id}/products/" + savedProduct.getId();
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
