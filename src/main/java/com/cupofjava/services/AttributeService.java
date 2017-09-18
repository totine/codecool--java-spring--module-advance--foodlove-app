package com.cupofjava.services;

import com.cupofjava.domain.Attribute;

import java.util.List;

public interface AttributeService {
    List<Attribute> listAll();

    Attribute getById(Long id);

    Attribute saveOrUpdate(Attribute attribute);

    void delete(Long id);

}
