package com.cupofjava.services;

import com.cupofjava.domain.Promotion;

import java.util.List;

/**
 * Created by oskar on 03.09.17.
 */
public interface PromotionService {

    List<Promotion> listAll();

    Promotion getById(Long id);

    Promotion saveOrUpdate(Promotion promotion);

    void delete(Long id);

}

