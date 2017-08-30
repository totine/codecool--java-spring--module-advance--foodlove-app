package com.cupofjava.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by oskar on 30.08.17.
 */

@Entity
@Table(name = "restaurators")
public class Restaurator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "restaurator", cascade = CascadeType.ALL)
    private Set<Restaurant> restaurants;

    public Restaurator(String name, Set<Restaurant> restaurants) {
        this.name = name;
        this.restaurants = restaurants;
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

    public Set<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }
}
