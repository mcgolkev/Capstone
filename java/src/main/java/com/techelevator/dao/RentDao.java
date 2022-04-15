package com.techelevator.dao;

import com.techelevator.model.Rent;

public interface RentDao {
    /**
     * Rent findRentDue(id)
     *
     * void updateRent(rent, id)
     */
    Rent findRentDueByRenterId(long id);

    void updateRent(Rent rent, long id);


    void deleteRentalAccount(long id);

}
