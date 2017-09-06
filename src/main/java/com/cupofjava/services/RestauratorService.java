package com.cupofjava.services;



import com.cupofjava.domain.Restaurator;

import java.util.List;


public interface RestauratorService {

    List<Restaurator> listAll();

    Restaurator getById(Long id);

    Restaurator saveOrUpdate(Restaurator restaurator);

    void delete(Long id);

}
