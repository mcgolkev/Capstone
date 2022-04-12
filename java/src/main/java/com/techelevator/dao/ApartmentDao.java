package com.techelevator.dao;

import com.techelevator.model.Apartment;


import java.util.List;


public interface ApartmentDao {

    List<Apartment> findAll();

    void updateProperty(Apartment apartment, Long id);

    Apartment findApartment(Long id);
}
