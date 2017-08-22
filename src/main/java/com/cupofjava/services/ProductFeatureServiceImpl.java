package com.cupofjava.services;

import com.cupofjava.domain.ProductFeature;
import com.cupofjava.repositories.ProductFeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductFeatureServiceImpl implements ProductFeatureService {

    private ProductFeatureRepository productFeatureRepository;

    @Autowired
    public ProductFeatureServiceImpl(ProductFeatureRepository productFeatureRepository) {
        this.productFeatureRepository = productFeatureRepository;
    }

    @Override
    public List<ProductFeature> listAll() {
        List<ProductFeature> productFeatures = new ArrayList<>();
        productFeatureRepository.findAll().forEach(productFeatures::add); //fun with Java 8
        return productFeatures;
    }

    @Override
    public ProductFeature getById(Long id) {
        return productFeatureRepository.findOne(id);
    }

    @Override
    public ProductFeature saveOrUpdate(ProductFeature productFeature) {
        productFeatureRepository.save(productFeature);
        return productFeature;
    }

    @Override
    public ProductFeature saveOrUpdateProductFeature(ProductFeature productFeature) {
        ProductFeature savedProductFeature = saveOrUpdate(productFeature);
        System.out.println("Saved Product Feature Id: " + savedProductFeature.getId());
        return productFeature;
    }

    @Override
    public void delete(Long id) {
        productFeatureRepository.delete(id);
    }
}
