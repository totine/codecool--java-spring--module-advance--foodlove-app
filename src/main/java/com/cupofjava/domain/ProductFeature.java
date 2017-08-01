package com.cupofjava.domain;

import javax.persistence.*;

@Entity
@Table(name = "product_feature")
public class ProductFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isVegetarian;
    private boolean isRestaurantBox;
    private boolean isShopProduct;


    public ProductFeature() {
        this.isVegetarian = false;
        this.isRestaurantBox = true;
        this.isShopProduct = false;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean isRestaurantBox() {
        return isRestaurantBox;
    }

    public void setRestaurantBox(boolean restaurantBox) {
        isRestaurantBox = restaurantBox;
    }

    public boolean isShopProduct() {
        return isShopProduct;
    }

    public void setShopProduct(boolean shopProduct) {
        isShopProduct = shopProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
