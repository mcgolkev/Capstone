package com.techelevator.dao;

import com.techelevator.model.Maintenance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMaintenanceDao implements  MaintenanceDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcMaintenanceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Maintenance> findAllMaintenance() {
        List<Maintenance> maintenance = new ArrayList<>();
        String sql = "SELECT *" +
                "FROM maintenance;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Maintenance maintenance1 = mapRowToMaintenance(results);
            maintenance.add(maintenance1);
        }return maintenance;
    }

    @Override
    public Maintenance findMaintenanceById(Long id) {
        Maintenance maintenance = new Maintenance();
        String sql = "SELECT * FROM maintenance WHERE property_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            Maintenance maintenance1 = mapRowToMaintenance(results);
        }
        return maintenance;
    }

    @Override
    public void updateMaintenanceStatus(Maintenance maintenance, Long id) {
        String sql = "UPDATE maintenance SET complete = ?, assigned = ?, new_request " +
                "WHERE maintenance_id = ?";
    }


    private Maintenance mapRowToMaintenance(SqlRowSet rs){
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(rs.getLong("maintenance_id"));
        maintenance.setOwnershipId(rs.getLong("ownership_id"));
        maintenance.setMaintenanceId(rs.getLong("maintenance_staff_id"));
        maintenance.setDescription(rs.getString("description"));
        maintenance.setComplete(rs.getBoolean("complete"));
        maintenance.setAssigned(rs.getBoolean("assigned"));
        maintenance.setNewRequest(rs.getBoolean("new_request"));
        return maintenance;
    }

}

