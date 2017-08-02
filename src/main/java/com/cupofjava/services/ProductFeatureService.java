package com.cupofjava.services;

import com.cupofjava.domain.Product;
import com.cupofjava.domain.ProductFeature;

import java.util.List;


public interface ProductFeatureService {

    List<ProductFeature> listAll();

    ProductFeature getById(Long id);

    ProductFeature saveOrUpdate(ProductFeature productFeature);

    void delete(Long id);
}

