package com.cupofjava.services;

import com.cupofjava.commands.ProductForm;
import com.cupofjava.converters.ProductFormToProduct;
import com.cupofjava.domain.Product;
import com.cupofjava.domain.ProductFeature;
import com.cupofjava.repositories.ProductFeatureRepository;
import com.cupofjava.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductFormToProduct productFormToProduct;
    private ProductFeatureRepository productFeatureRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductFormToProduct productFormToProduct) {
        this.productRepository = productRepository;
        this.productFormToProduct = productFormToProduct;
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
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        ProductFeature productFeature = new ProductFeature();
        System.out.println(productFeature);
        productFeatureRepository.save(productFeature);
        productForm.setProductFeature(productFeature);
        Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));
        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
}