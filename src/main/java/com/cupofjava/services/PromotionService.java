package com.cupofjava.services;

import com.cupofjava.domain.Product;
import com.cupofjava.domain.Promotion;
import com.cupofjava.domain.Restaurant;

import java.util.List;

/**
 * Created by oskar on 03.09.17.
 */
public interface PromotionService {

    List<Promotion> listAll();

    Promotion getById(Long id);

    Promotion saveOrUpdate(Promotion promotion);

    void delete(Long id);

    void savePromotionData(Promotion promotion, Long id);

}

