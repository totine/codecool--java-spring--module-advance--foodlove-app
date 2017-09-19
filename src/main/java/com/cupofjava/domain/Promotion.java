package com.cupofjava.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

import java.time.LocalDateTime;


@Entity
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
//    private LocalDateTime dateFrom;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'hh:mm")
//    private LocalDateTime dateTo;
    @DecimalMax("100.0")
    @DecimalMin("0.0")
    private double discount;
    private BigDecimal promotionalPrice;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    private Boolean isActive = false;

    public Promotion(double discount) {
//        this.dateFrom = dateFrom;
//        this.dateTo = dateTo;
        this.discount = discount;
        this.promotionalPrice = CountPromotionalPrice(discount, product.getPrice());
    }

    public Promotion() {
    }


    private static BigDecimal CountPromotionalPrice(double discount, BigDecimal price){
         BigDecimal promotionalPrice  = price.multiply(new BigDecimal(discount));
         return promotionalPrice;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
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

//    public LocalDateTime getDateFrom() {
//        return dateFrom;
//    }
//
//    public void setDateFrom(String dateFrom) {
//        this.dateFrom = LocalDateTime.parse(dateFrom);
//    }
//
//    public LocalDateTime getDateTo() {
//        return dateTo;
//    }
//
//    public void setDateTo(String dateTo) {
//        this.dateTo = LocalDateTime.parse(dateTo);
//    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public BigDecimal getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(BigDecimal promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}

