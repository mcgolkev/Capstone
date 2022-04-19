package com.techelevator.dao;

import com.techelevator.model.Apartment;


import java.security.Principal;
import java.util.List;


public interface ApartmentDao {

    List<Apartment> findAll();

    void updateApartment(Apartment apartment, Long id);

    Apartment findApartment(Long id);

    void createApartment(Apartment apartment);

    void deleteApartment(Long id);

    List<Apartment> findAptForCurrentUser(String principal);

    void updatePropertyDetailsForRenter(Long id);

    void assignRenterIdToProperty(Long renterId, Long propertyId);
}
