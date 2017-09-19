package com.cupofjava.services;

import com.cupofjava.domain.Promotion;


import java.util.List;


public interface PromotionService {

    List<Promotion> listAll();

    Promotion getById(Long id);

    Promotion saveOrUpdate(Promotion promotion);

    void delete(Long id);

    void savePromotionData(Promotion promotion, Long id);

}

