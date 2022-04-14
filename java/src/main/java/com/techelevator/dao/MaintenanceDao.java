package com.techelevator.dao;

import com.techelevator.model.Maintenance;

import java.util.List;

public interface MaintenanceDao {

    List<Maintenance> findAll();




    /**
     * Maintenance findMaintenanceRequest(id)
     *
     * void updateMaintenanceRequest(Maintenance maintenance, id)
     */
}
