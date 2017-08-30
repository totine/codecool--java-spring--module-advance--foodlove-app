package com.cupofjava.domain;

import javax.persistence.*;

/**
 * Created by oskar on 30.08.17.
 */

@Entity
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name = "restaurator_id")
    private Restaurator restaurator;

    public Restaurant(String name, String address) {
        this.name = name;
        this.address = address;
        this.restaurator = restaurator;
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

    public Restaurator getRestaurator() {
        return restaurator;
    }

    public void setRestaurator(Restaurator restaurator) {
        this.restaurator = restaurator;
    }
}
