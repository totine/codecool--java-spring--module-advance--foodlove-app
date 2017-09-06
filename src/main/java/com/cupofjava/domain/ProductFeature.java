package com.cupofjava.domain;

import javax.persistence.*;

@Entity
public class ProductFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isVegetarian;
    private boolean isRestaurantBox;
    private boolean isShopProduct;
    @OneToOne(mappedBy = "productFeature")
    private Product product;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean getIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean getIsRestaurantBox() {
        return isRestaurantBox;
    }

    public void setIsRestaurantBox(boolean restaurantBox) {
        isRestaurantBox = restaurantBox;
    }

    public boolean getIsShopProduct() {
        return isShopProduct;
    }

    public void setIsShopProduct(boolean shopProduct) {
        isShopProduct = shopProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductFeature{" +
                "isVegetarian=" + isVegetarian +
                ", isRestaurantBox=" + isRestaurantBox +
                ", isShopProduct=" + isShopProduct +
                '}';
    }
}
