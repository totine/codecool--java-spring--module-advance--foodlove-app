package com.cupofjava.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Restaurator {

    private Long id;
    private String name;
    private String imgUrl;
    private Set<Restaurant> restaurants = new HashSet<>();

    public Restaurator(String name, Set<Restaurant> restaurants) {
        this.name = name;
        this.restaurants = restaurants;
        this.imgUrl = "http://www.goodgrubbs.com/portals/0/iconBiz.png";
    }

    public Restaurator() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @JoinColumn
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
