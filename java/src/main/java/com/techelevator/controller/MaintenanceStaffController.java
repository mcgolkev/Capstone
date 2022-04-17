package com.techelevator.controller;

import com.techelevator.dao.MaintenanceStaffDao;
import com.techelevator.model.MaintenaceStaff;
import com.techelevator.model.Maintenance;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class MaintenanceStaffController {

    private MaintenanceStaffDao maintenanceStaffDao;
    private MaintenaceStaff maintenaceStaff;

    public MaintenanceStaffController(MaintenanceStaffDao maintenanceStaffDao,
                                      MaintenaceStaff maintenaceStaff) {
        this.maintenanceStaffDao = maintenanceStaffDao;
        this.maintenaceStaff = maintenaceStaff;
    }

    @RequestMapping(value = "/maintstaff", method = RequestMethod.GET)
    public List<MaintenaceStaff> findAll(){
        return maintenanceStaffDao.findAll();}

    @RequestMapping(value = "/maintstaff/{svcDept}", method = RequestMethod.GET)
    public List<MaintenaceStaff> findAllBySvcDept(@PathVariable String svcDept){
        return maintenanceStaffDao.findAllBySvcDept(svcDept);}
}
