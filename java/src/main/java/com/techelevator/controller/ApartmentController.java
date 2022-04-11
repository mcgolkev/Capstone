package com.techelevator.controller;

import com.techelevator.dao.ApartmentDao;
import com.techelevator.model.Apartment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.AnnotatedParameterizedType;
import java.util.List;

@RestController
public class ApartmentController {
    private ApartmentDao apartmentDao;

    public ApartmentController(ApartmentDao apartmentDao){
        this.apartmentDao = apartmentDao;
    }

@RequestMapping(value = "/properties", method = RequestMethod.GET)
    public List<Apartment> findAll(){
        return apartmentDao.findAll();}

}
