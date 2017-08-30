package com.cupofjava.services;

import com.cupofjava.domain.Restaurator;
import com.cupofjava.repositories.RestauratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oskar on 30.08.17.
 */
@Service
public class RestauratorServiceImpl implements RestauratorService {
    private RestauratorRepository restauratorRepository;

    @Autowired
    public RestauratorServiceImpl(RestauratorRepository restauratorRepository) {
        this.restauratorRepository = restauratorRepository;
    }

    @Override
    public List<Restaurator> listAll() {
        List<Restaurator> restaurators = new ArrayList<>();
        restauratorRepository.findAll().forEach(restaurators::add); //fun with Java 8
        return restaurators;
    }

    @Override
    public Restaurator getById(Long id) {
        return restauratorRepository.findOne(id);
    }

    @Override
    public Restaurator saveOrUpdate(Restaurator restaurator) {
        restauratorRepository.save(restaurator);
        return restaurator;
    }

    @Override
    public void delete(Long id) {
        restauratorRepository.delete(id);

    }
}
