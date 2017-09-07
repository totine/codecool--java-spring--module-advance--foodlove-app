package com.cupofjava.services;

import com.cupofjava.domain.Product;
import com.cupofjava.domain.ProductFeature;
import com.cupofjava.domain.Restaurant;
import com.cupofjava.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductFeatureService productFeatureService;
    private RestaurantService restaurantService;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductFeatureService productFeatureService,
                              RestaurantService restaurantService) {
        this.productRepository = productRepository;
        this.productFeatureService = productFeatureService;
        this.restaurantService = restaurantService;
    }

    @Override
    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add); //fun with Java 8
        return products;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public void saveProductData(Product product, ProductFeature productFeature, Long restaurant_id) {
        ProductFeature savedProductFeature = productFeatureService.saveOrUpdateProductFeature(productFeature);
        Product savedProduct = this.saveOrUpdate(product);
        savedProduct.setProductFeature(savedProductFeature);
        savedProduct.setRestaurant(restaurantService.getById(restaurant_id));
        savedProductFeature.setProduct(savedProduct);
        Restaurant restaurant = restaurantService.getById(restaurant_id);
        restaurant.getProducts().add(savedProduct);
        restaurantService.saveOrUpdate(restaurant);
    }
}
