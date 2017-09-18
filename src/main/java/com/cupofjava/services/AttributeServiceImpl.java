package com.cupofjava.services;

import com.cupofjava.domain.Attribute;
import com.cupofjava.repositories.AttributeRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    private AttributeRepositry attributeRepositry;

    @Autowired
    public AttributeServiceImpl(AttributeRepositry attributeRepository) {
        this.attributeRepositry = attributeRepository;
    }

    @Override
    public List<Attribute> listAll() {
        List<Attribute> restaurators = new ArrayList<>();
        attributeRepositry.findAll().forEach(restaurators::add); //fun with Java 8
        return restaurators;
    }

    @Override
    public Attribute getById(Long id) {
        return attributeRepositry.findOne(id);
    }

    @Override
    public Attribute saveOrUpdate(Attribute attribute) {
        return attributeRepositry.save(attribute);
    }

    @Override
    public void delete(Long id) {
        attributeRepositry.delete(id);
    }
}
