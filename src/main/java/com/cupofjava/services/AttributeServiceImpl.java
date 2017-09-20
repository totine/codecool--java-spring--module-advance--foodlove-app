package com.cupofjava.services;

import com.cupofjava.domain.Attribute;
import com.cupofjava.repositories.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    private AttributeRepository attributeRepository;

    @Autowired
    public AttributeServiceImpl(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    @Override
    public List<Attribute> listAll() {
        List<Attribute> attributes = new ArrayList<>();
        attributeRepository.findAll().forEach(attributes::add); //fun with Java 8
        return attributes;
    }

    @Override
    public Attribute getById(Long id) {
        return attributeRepository.findOne(id);
    }

    @Override
    public Attribute saveOrUpdate(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @Override
    public void delete(Long id) {
        attributeRepository.delete(id);
    }
}
