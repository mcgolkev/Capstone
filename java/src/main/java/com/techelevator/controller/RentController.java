package com.techelevator.controller;

import com.techelevator.dao.RentDao;
import com.techelevator.model.Apartment;
import com.techelevator.model.Rent;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class RentController {
 private RentDao rentDao;
 private Rent rent;

 public RentController(RentDao rentDao, Rent rent){
     this.rentDao = rentDao; this.rent = rent;
    }

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.GET)
    public Rent findRent(@PathVariable long id){
        return rentDao.findRentDueByRenterId(id);}

    @RequestMapping(path = "/rent/{id}", method = RequestMethod.PUT)
    public void updateRent(@RequestBody Rent rent, @PathVariable long id){
        rentDao.updateRent(rent, id);}

    @RequestMapping(path = "/rent/{id}", method = RequestMethod.DELETE)
    public void deleteRentalAccount(@PathVariable long id){
        rentDao.deleteRentalAccount(id);}
}
