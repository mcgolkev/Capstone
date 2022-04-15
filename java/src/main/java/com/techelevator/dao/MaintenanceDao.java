package com.techelevator.dao;

import com.techelevator.model.Maintenance;

import java.util.List;

public interface MaintenanceDao {

    List<Maintenance> findAllMaintenance();

    Maintenance findMaintenanceById(Long id);

    void updateMaintenanceStatus(Maintenance maintenance, Long id);

    void createMaintenanceRequest(Maintenance maintenance);
}
