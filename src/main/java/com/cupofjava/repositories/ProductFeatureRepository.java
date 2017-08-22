package com.cupofjava.repositories;

import com.cupofjava.domain.ProductFeature;
import org.springframework.data.repository.CrudRepository;


public interface ProductFeatureRepository extends CrudRepository<ProductFeature, Long> {
}
