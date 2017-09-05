package com.cupofjava.domain;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name = "restaurator_id")
    private Restaurator restaurator;
    private String imgUrl;
    @OneToMany(mappedBy = "restaurant", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Product> products;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private Set<Promotion> promotions;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.imgUrl  = "http://www.safetysignsandnotices.co.uk/images/D/gs12.gif";
    }

    public Restaurant() {
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

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


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }


    public Restaurator getRestaurator() {
        return restaurator;
    }


    public void setRestaurator(Restaurator restaurator) {
        this.restaurator = restaurator;
    }
}
