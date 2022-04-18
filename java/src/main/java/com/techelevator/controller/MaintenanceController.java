package com.techelevator.controller;

import com.techelevator.dao.MaintenanceDao;
import com.techelevator.model.Maintenance;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")

public class MaintenanceController {
    private MaintenanceDao maintenanceDao;
    private Maintenance maintenance;


    @RequestMapping(path = "/maintenance", method = RequestMethod.POST)
    public void createApartment(@RequestBody Maintenance maintenance){
        maintenanceDao.createMaintenanceRequest(maintenance);}

    @RequestMapping(value = "/maintenance/{id}", method = RequestMethod.GET)
    public List<Maintenance> findMaintenanceRequest(@PathVariable long id){
        return maintenanceDao.findMaintenanceById(id);}

    @RequestMapping(value = "/maintenance", method = RequestMethod.GET)
    public List<Maintenance> findAllMaintenanceRequests(){
        return maintenanceDao.findAllMaintenance();}

    @RequestMapping(value = "/maintenance/incomplete", method = RequestMethod.GET)
    public List<Maintenance> findIncompleteMaintenanceRequests(Principal principal){
        return maintenanceDao.findIncompleteMaintenance(principal.getName());}

    @RequestMapping(path = "/maintenance/{id}", method = RequestMethod.PUT)
    public void updateMaintenanceRequest (@RequestBody Maintenance maintenance, @PathVariable long id){
        maintenanceDao.updateMaintenanceStatus(maintenance, id);}

}
