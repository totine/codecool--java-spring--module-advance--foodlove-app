package com.cupofjava.services;

import com.cupofjava.domain.Product;
import com.cupofjava.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;


    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
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

    @Override ///metoda prawdopodobnie do usunięcia
    public Product saveOrUpdateProduct(Product product) {
        Product savedProduct = saveOrUpdate(product);
        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
}