package com.cupofjava.controllers;

import com.cupofjava.domain.Product;
import com.cupofjava.domain.ProductFeature;
import com.cupofjava.services.ProductFeatureService;
import com.cupofjava.services.ProductService;
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

    @Autowired
    public void setProductService(ProductService productService, ProductFeatureService productFeatureService) {
        this.productService = productService;
        this.productFeatureService = productFeatureService;
    }


    @RequestMapping("restaurators/{id}/restaurants/{id}/products/")
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        model.addAttribute("productsFeatures", productFeatureService.listAll());
        return "product/list";
    }

    @RequestMapping("restaurators/{id}/restaurants/{id}/products/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", productService.getById(Long.valueOf(id)));
        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Product product = productService.getById(Long.valueOf(id));
        model.addAttribute("productForm", product);
        return "product/productform";
    }

    @RequestMapping("/restaurators/{id}/restaurants/{id}/products/add")
    public String newProduct(Model model){
        model.addAttribute("productForm", new Product());
        model.addAttribute("productFeatureForm", new ProductFeature());
        return "product/productform";
    }

    @RequestMapping(value = "/restaurators/{id}/restaurants/{id}/products/", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid Product product, ProductFeature productFeature, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        ProductFeature savedProductFeature = productFeatureService.saveOrUpdateProductFeature(productFeature);
        Product savedProduct = productService.saveOrUpdateProduct(product);

        savedProduct.setProductFeature(savedProductFeature);
        savedProductFeature.setProduct(savedProduct);
        return "redirect:/restaurators/{id}/restaurants/{id}/products/" + savedProduct.getId();
    }

    @RequestMapping("/restaurators/{id}/restaurants/{id}/products/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(Long.valueOf(id));
        return "redirect:/restaurators/{id}/restaurants/{id}/products/";
    }
}
