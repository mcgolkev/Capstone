package com.techelevator.dao;

import com.techelevator.model.Apartment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //anytime that a ApartmentDao gets injected, create an object of JdbcApartmentDao to use
public class JdbcApartmentDao implements ApartmentDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcApartmentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Apartment> findAll() {
        List<Apartment> apartments = new ArrayList<>();
        String sql = "SELECT * FROM apartments;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            Apartment apartment = mapRowToApartment(results);
            apartments.add(apartment);
        }
        return apartments;
    }
/*
    @Override
    public Apartment createApartment(Apartment apartment) {
        Apartment newApartment = null;
        String sql = "INSERT INTO apartments(park_name, date_established, area, has_camping)\n" +
                "VALUES (?,?,?,?) RETURNING park_id;";
        //queryForObject(sql, object to return.Class, params to replace ?
        long newParkId = jdbcTemplate.queryForObject(sql,Long.class,park.getParkName(),
                park.getDateEstablished(),park.getArea(),park.getHasCamping());

        newPark = getPark(newParkId);//read the new park from the database based on the id

        return newPark;
    }
*/



    private Apartment mapRowToApartment(SqlRowSet rs) {
        Apartment apartment = new Apartment();
        apartment.setPropertyId(rs.getLong("property_id"));
        apartment.setAddress(rs.getString("address"));
        apartment.setPrice(rs.getDouble("price"));
        apartment.setPicture(rs.getString("picture"));
        apartment.setDateAvailable(rs.getString("available"));
        //todo: date should be set as date rather than string? can change later
        apartment.setNumBedrooms(rs.getDouble("num_bedrooms"));
        apartment.setNumBathrooms(rs.getDouble("num_bathrooms"));
        apartment.setSquareFeet(rs.getInt("square_feet"));
        apartment.setShortDescription(rs.getString("short_description"));
        apartment.setLongDescription(rs.getString("long_description"));
        return apartment;
    }
}
