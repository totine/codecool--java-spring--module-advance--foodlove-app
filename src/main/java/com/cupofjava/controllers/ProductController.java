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

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/product/list";
    }

    @RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
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

    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("productForm", new Product());
        return "product/productform";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid Product product, ProductFeature productFeature, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "product/productform";
        }

        ProductFeature savedProductFeature = productFeatureService.saveOrUpdateProductFeature(productFeature);
        Product savedProduct = productService.saveOrUpdateProduct(product);

        savedProduct.setProductFeature(savedProductFeature);
        savedProductFeature.setProduct(savedProduct);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(Long.valueOf(id));
        return "redirect:/product/list";
    }
}
