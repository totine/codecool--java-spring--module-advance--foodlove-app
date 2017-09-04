package com.cupofjava.services;

import com.cupofjava.domain.Promotion;
import com.cupofjava.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oskar on 03.09.17.
 */
@Service
public class PromotionServiceImpl implements PromotionService {

    private PromotionRepository promotionRepository;

    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }

    @Override
    public List<Promotion> listAll() {
        List<Promotion> promotions = new ArrayList<>();
        promotionRepository.findAll().forEach(promotions::add);
        return promotions;
    }


    @Override
    public Promotion getById(Long id) {
        return promotionRepository.findOne(id);
    }

    @Override
    public Promotion saveOrUpdate(Promotion promotion) {
        promotionRepository.save(promotion);
        return promotion;
    }

    @Override
    public void delete(Long id) {
        promotionRepository.delete(id);
    }
}
