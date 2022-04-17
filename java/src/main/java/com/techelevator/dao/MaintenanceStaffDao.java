package com.techelevator.dao;

import com.techelevator.model.MaintenaceStaff;
import com.techelevator.model.Maintenance;
import java.security.Principal;
import java.util.List;

public interface MaintenanceStaffDao {

    List<MaintenaceStaff> findAll();

    List<MaintenaceStaff> findAllBySvcDept(String svcDept);
}
