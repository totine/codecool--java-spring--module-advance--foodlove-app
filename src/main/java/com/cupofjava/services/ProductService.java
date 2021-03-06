package com.cupofjava.services;

import com.cupofjava.domain.Product;
import com.cupofjava.domain.ProductFeature;


import java.util.List;

public interface ProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

    void saveProductData(Product product, ProductFeature productFeature, Long restaurant_id);
}

