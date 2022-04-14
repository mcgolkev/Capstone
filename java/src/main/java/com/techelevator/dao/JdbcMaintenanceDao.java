package com.techelevator.dao;

import com.techelevator.model.Maintenance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMaintenanceDao implements  MaintenanceDao{
    private JdbcTemplate jdbcTemplate;

    public JdbcMaintenanceDao(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Maintenance> findAll() {
        List<Maintenance> maintenances = new ArrayList<>();
        String sql = "select maintenance_id, ownership_id, maint_staff_id, description, complete, assigned, new_request, date_submitted\n" +
                "from maintenance;"
    }


    //todo get certain maintenance requests()

    //todo update a maintenance request to complete it()

    //todo notification for landlord upon
}
