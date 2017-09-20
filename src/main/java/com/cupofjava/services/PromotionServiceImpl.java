package com.cupofjava.services;

import com.cupofjava.domain.Promotion;
import com.cupofjava.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    private PromotionRepository promotionRepository;
    private ProductService productService;
    private RestaurantService restaurantService;

    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository, ProductService productService,
                                RestaurantService restaurantService) {
        this.promotionRepository = promotionRepository;
        this.productService = productService;
        this.restaurantService = restaurantService;
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

    @Override
    public void savePromotionData(Promotion promotion, Long restaurant_id) {
        promotion.setRestaurant(restaurantService.getById(restaurant_id));
        this.saveOrUpdate(promotion);
    }
}
