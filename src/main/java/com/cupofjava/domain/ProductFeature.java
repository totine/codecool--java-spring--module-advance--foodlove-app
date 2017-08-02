package com.cupofjava.domain;



import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


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
    @OneToOne(mappedBy = "productFeature")
    private Product product;



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

//    @GenericGenerator(name = "generator", strategy = "foreign",
//            parameters = @Parameter(name = "property", value = "product"))

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
}
