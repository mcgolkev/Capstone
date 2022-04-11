package com.techelevator.dao;

import com.techelevator.model.Apartment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcApartmentDao implements ApartmentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcApartmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Apartment> findAll() {
        List<Apartment> apartments = new ArrayList<>();
        String sql = "select * from apartments";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Apartment apartment = mapRowToApartment(results);
            apartments.add(apartment);
        }
        return apartments;
    }



    private Apartment mapRowToApartment(SqlRowSet rs) {
        Apartment apartment = new Apartment();
        apartment.setPropertyId(rs.getLong("property_id"));
        apartment.setAddress(rs.getString("username"));
        apartment.setPrice(rs.getDouble("password_hash"));
        apartment.setPicture(rs.getString("role"));
        apartment.setDateAvailable(rs.getString("available"));
        //^ maybe date should be set as date rather than string? can change later
        apartment.setNumBedrooms(rs.getDouble("num_bedrooms"));
        apartment.setNumBathrooms(rs.getDouble("num_bathrooms"));
        apartment.setSquareFeet(rs.getInt("square_feet"));
        apartment.setShortDescription(rs.getString("short_description"));
        apartment.setLongDescription(rs.getString("long_description"));
        return apartment;
    }
}
