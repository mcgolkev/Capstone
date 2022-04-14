package com.techelevator.controller;

import com.techelevator.dao.ApartmentDao;
import com.techelevator.dao.RentDao;
import com.techelevator.model.Apartment;
import com.techelevator.model.Rent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class GeneralController {
    private ApartmentDao apartmentDao;
    private Apartment apartment;

    private RentDao rentDao;
    private Rent rent;

    public GeneralController(ApartmentDao apartmentDao, Apartment apartment, RentDao rentDao, Rent rent){
        this.apartment =apartment; this.apartmentDao = apartmentDao; this.rent = rent; this.rentDao = rentDao;
    }
    @RequestMapping(value = "/general", method = RequestMethod.GET)
    public List<Apartment> findAll(id){

        return apartmentDao.findAll(), rentDao.findRentDue(id);}
}
