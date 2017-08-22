package com.cupofjava.domain;

import javax.persistence.*;

@Entity
@Table(name = "product_feature")
public class ProductFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isVegetarian = false;
    private boolean isRestaurantBox = false;
    private boolean isShopProduct = true;
    @OneToOne(mappedBy = "productFeature")
    private Product product;

    public boolean getIsVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean getIsRestaurantBox() {
        return isRestaurantBox;
    }

    public void setRestaurantBox(boolean restaurantBox) {
        isRestaurantBox = restaurantBox;
    }

    public boolean getIsShopProduct() {
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
