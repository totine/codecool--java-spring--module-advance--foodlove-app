package com.cupofjava.services;

import com.cupofjava.domain.Restaurant;


import java.util.List;

/**
 * Created by oskar on 30.08.17.
 */
public interface RestaurantService {
    List<Restaurant> listAll();

    Restaurant getById(Long id);

    Restaurant saveOrUpdate(Restaurant restaurant);

    void delete(Long id);

}
