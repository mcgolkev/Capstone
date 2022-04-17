package com.techelevator.dao;

import com.techelevator.model.MaintenaceStaff;
import com.techelevator.model.Maintenance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMaintenanceStaffDao implements  MaintenanceStaffDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcMaintenanceStaffDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<MaintenaceStaff> findAll() {
        List<MaintenaceStaff> maintenanceStaffs = new ArrayList<>();
        String sql = "SELECT *\n" +
                "From maint_staff;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            MaintenaceStaff maintenaceStaff = mapRowToMaintenanceStaff(results);
            maintenanceStaffs.add(maintenaceStaff);
        }
        return maintenanceStaffs;
    }

    @Override
    public List<MaintenaceStaff> findAllBySvcDept(String svcDept) {
        List<MaintenaceStaff> maintenanceStaffs = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM maint_staff\n" +
                "WHERE service_dept = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, svcDept);
        while(results.next()){
            MaintenaceStaff maintenaceStaff = mapRowToMaintenanceStaff(results);
            maintenanceStaffs.add(maintenaceStaff);
        }
        return maintenanceStaffs;
    }

    private MaintenaceStaff mapRowToMaintenanceStaff(SqlRowSet rs){
        MaintenaceStaff maintenanceStaff = new MaintenaceStaff();
        maintenanceStaff.setMaintStaffId(rs.getLong("maint_staff_id"));
        maintenanceStaff.setStaffUserId(rs.getLong("staff_user_id"));
        maintenanceStaff.setStaffName(rs.getString("staff_name"));
        maintenanceStaff.setServiceDept(rs.getString("service_dept"));

        return maintenanceStaff;
    }
}
