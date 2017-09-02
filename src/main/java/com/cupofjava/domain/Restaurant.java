package com.cupofjava.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by oskar on 30.08.17.
 */

@Entity
public class Restaurant {

    private Long id;
    private String name;
    private String address;
    private Restaurator restaurator;
    private String imgUrl;
    private Set<Product> products = new HashSet<>();
    private Set<Promotion> promotions = new HashSet<>();

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.imgUrl  = "http://www.safetysignsandnotices.co.uk/images/D/gs12.gif";
    }

    public Restaurant() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    @ManyToOne
    public Restaurator getRestaurator() {
        return restaurator;
    }


    public void setRestaurator(Restaurator restaurator) {
        this.restaurator = restaurator;
    }
}
