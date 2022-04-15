package com.techelevator.controller;

import com.techelevator.dao.MaintenanceDao;
import com.techelevator.model.Maintenance;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class MaintenanceController {
    private MaintenanceDao maintenanceDao;
    private Maintenance maintenance;


    @RequestMapping(path = "/maintenance", method = RequestMethod.POST)
    public void createApartment(@RequestBody Maintenance maintenance){
        maintenanceDao.createMaintenanceRequest(maintenance);}

    @RequestMapping(value = "/maintenance/{id}", method = RequestMethod.GET)
    public Maintenance findMaintenanceRequest(@PathVariable long id){
        return maintenanceDao.findMaintenanceById(id);}

    @RequestMapping(value = "/maintenance", method = RequestMethod.GET)
    public List<Maintenance> findAllMaintenanceRequests(){
        return maintenanceDao.findAllMaintenance();}

    @RequestMapping(path = "/maintenance/{id}", method = RequestMethod.PUT)
    public void updateMaintenanceRequest (@RequestBody Maintenance maintenance, @PathVariable long id){
        maintenanceDao.updateMaintenanceStatus(maintenance, id);}

}
