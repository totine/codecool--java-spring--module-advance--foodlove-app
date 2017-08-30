package com.cupofjava.services;

import com.cupofjava.domain.Restaurant;
import com.cupofjava.repositories.RestaurantRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oskar on 30.08.17.
 */
public class RestaurantServiceImpl implements RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Override
    public List<Restaurant> listAll() {
        List<Restaurant> restaurators = new ArrayList<>();
        restaurantRepository.findAll().forEach(restaurators::add); //fun with Java 8
        return restaurators;
    }

    @Override
    public Restaurant getById(Long id) {
        return restaurantRepository.findOne(id);
    }

    @Override
    public Restaurant saveOrUpdate(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.delete(id);

    }
}
