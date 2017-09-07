package com.cupofjava.repositories;

import com.cupofjava.domain.Restaurant;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by oskar on 30.08.17.
 */
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}