package com.cupofjava.repositories;

import com.cupofjava.domain.ProductFeature;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by oskar on 02.08.17.
 */
public interface ProductFeatureRepository extends CrudRepository<ProductFeature, Long> {
}
