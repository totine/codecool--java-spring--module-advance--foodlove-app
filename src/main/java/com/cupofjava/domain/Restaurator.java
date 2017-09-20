package com.cupofjava.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Restaurator {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;
    private String imgUrl;
    @OneToMany(mappedBy = "restaurator")
    @OrderBy("id")
    private Set<Restaurant> restaurants = new HashSet<>();

    public Restaurator(String name, Set<Restaurant> restaurants) {
        this.name = name;
        this.restaurants = restaurants;
        this.imgUrl = "http://www.goodgrubbs.com/portals/0/iconBiz.png";
    }

    public Restaurator() {
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
