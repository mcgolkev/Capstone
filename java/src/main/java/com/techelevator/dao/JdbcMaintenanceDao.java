package com.techelevator.dao;

import com.techelevator.model.Maintenance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.time.LocalDate;
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
    public List<Maintenance> findMaintenanceById(Long id) {
        List<Maintenance> maintenances = new ArrayList<>();
        String sql = "SELECT * FROM maintenance WHERE property_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        while (results.next()) {
            Maintenance maintenance = mapRowToMaintenance(results);
            maintenances.add(maintenance);
        }
        return maintenances;
    }

    @Override
    public void updateMaintenanceStatus(Maintenance maintenance, Long id) {
        String sql = "UPDATE maintenance SET complete = ?, assigned = ?, new_request " +
                "WHERE maintenance_id = ?";
    }
    @Override
    public void createMaintenanceRequest(Maintenance maintenance) {
        String sql = "INSERT INTO maintenance (ownership_id, maint_staff_id, description, complete," +
                "assigned, new_request, date_submitted)" +
                "VALUES (?,?,?,?,?,?)";
        LocalDate date = LocalDate.parse(maintenance.getDateSubmitted());
        jdbcTemplate.update(sql, maintenance.getOwnershipId(), maintenance.getMaintenanceId(), maintenance.getDescription()
                , maintenance.isComplete(), maintenance.isAssigned(), maintenance.isNewRequest(), date);
    }


    private Maintenance mapRowToMaintenance(SqlRowSet rs){
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(rs.getLong("maintenance_id"));
        maintenance.setOwnershipId(rs.getLong("ownership_id"));
        maintenance.setMaintenanceId(rs.getLong("maint_staff_id"));
        maintenance.setDescription(rs.getString("description"));
        maintenance.setComplete(rs.getBoolean("complete"));
        maintenance.setAssigned(rs.getBoolean("assigned"));
        maintenance.setNewRequest(rs.getBoolean("new_request"));
        return maintenance;
    }

}
