package com.techelevator.dao;

import com.techelevator.model.Rent;

public interface RentDao {
    /**
     * Rent findRentDue(id)
     *
     * void updateRent(rent, id)
     */
    Rent findRentDue(long id);

    void updateRent(Rent rent, long id);


    void deleteRentalAccount(long id);

}
