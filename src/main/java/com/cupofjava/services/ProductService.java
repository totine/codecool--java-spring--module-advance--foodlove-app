package com.cupofjava.services;

import com.cupofjava.domain.Attribute;
import com.cupofjava.domain.Product;
import com.cupofjava.domain.ProductFeature;


import java.util.List;
import java.util.Set;

public interface ProductService {

    List<Product> listAll();

    Product getById(Long id);

    Product saveOrUpdate(Product product);

    void delete(Long id);

    void saveProductData(Product product, ProductFeature productFeature, Long restaurant_id,
                         Set<Attribute> selectedAttributes);
}

