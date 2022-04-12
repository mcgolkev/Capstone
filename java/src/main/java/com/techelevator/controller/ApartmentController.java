package com.techelevator.controller;

import com.techelevator.dao.ApartmentDao;
import com.techelevator.model.Apartment;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.AnnotatedParameterizedType;
import java.util.List;

@RestController
@CrossOrigin
public class ApartmentController {
    private ApartmentDao apartmentDao;
    private Apartment apartment;

    public ApartmentController(ApartmentDao apartmentDao, Apartment apartment){
        this.apartmentDao = apartmentDao; this.apartment = apartment;
    }

@RequestMapping(value = "/properties", method = RequestMethod.GET)
    public List<Apartment> findAll(){
        return apartmentDao.findAll();}

    @RequestMapping(value = "/properties/{id}", method = RequestMethod.GET)
    public Apartment findApartment(@PathVariable long id){
        return apartmentDao.findApartment(id);}

    @RequestMapping(path = "/properties/{id}", method = RequestMethod.PUT)
    public void updateApartment(@RequestBody Apartment apartment, @PathVariable long id){
      apartmentDao.updateApartment(apartment, id);}

    @RequestMapping(path = "/properties", method = RequestMethod.POST)
    public void createApartment (@RequestBody Apartment apartment){
        apartmentDao.createApartment(apartment);}

}



