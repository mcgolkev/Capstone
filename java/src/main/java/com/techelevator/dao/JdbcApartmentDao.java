package com.techelevator.dao;

import com.techelevator.model.Apartment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.time.LocalDate;
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
        while (results.next()) {
            Apartment apartment = mapRowToApartment(results);
            apartments.add(apartment);
        }
        return apartments;
    }
    @Override
    public void createApartment(Apartment apartment){
        String sql = "INSERT INTO apartments (address_line_1, address_line_2, city," +
                "state, zip, price, picture, available, num_bedrooms," +
                "num_bathrooms, square_feet, short_description, long_description)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
        LocalDate date = LocalDate.parse(apartment.getDateAvailable());
       jdbcTemplate.update(sql, apartment.getAddressLine1(), apartment.getAddressLine2(),
                apartment.getCity(), apartment.getState(), apartment.getZip(), apartment.getPrice(),
                apartment.getPicture(), date, apartment.getNumBedrooms(),
                apartment.getNumBathrooms(), apartment.getSquareFeet(), apartment.getShortDescription(),
                apartment.getLongDescription());
    }

    public Apartment findApartment(Long propertyId){
      Apartment apartment = new Apartment();
        String sql = "SELECT * FROM apartments WHERE property_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
        if(results.next()){
           apartment = mapRowToApartment(results);
        }return apartment;
    }


    public List<Apartment> findAptForCurrentUser(Principal principal){
        List<Apartment> apartments = new ArrayList<>();
        String sql = "SELECT * FROM apartments WHERE property_id in (SELECT property_id " +
                "FROM ownership WHERE landlord in (SELECT user_id FROM users WHERE username = ?)" +
                " or renter in (SELECT user_id FROM users WHERE username = ?) )";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, principal.getName(),principal.getName());
        while(results.next()){
            Apartment apartment = mapRowToApartment(results);
            apartments.add(apartment);
        }return apartments;
    }
    //todo: try catch if the search is blank




    @Override
    public void updateApartment(Apartment apartment, Long id) {
        String sql = "UPDATE apartments SET address_line_1 = ?, address_line_2 = ?, city = ?," +
                "state = ?, zip = ?, price = ?, picture = ?, available = ?, num_bedrooms = ?," +
                "num_bathrooms = ?, square_feet = ?, short_description = ?, long_description = ?" +
                "WHERE property_id =?; ";
        LocalDate date = LocalDate.parse(apartment.getDateAvailable());
        jdbcTemplate.update(sql, apartment.getAddressLine1(), apartment.getAddressLine2(),
                apartment.getCity(), apartment.getState(), apartment.getZip(), apartment.getPrice(),
                apartment.getPicture(), date, apartment.getNumBedrooms(),
                apartment.getNumBathrooms(), apartment.getSquareFeet(), apartment.getShortDescription(),
                apartment.getLongDescription(), id);
    }

    public  void deleteApartment(Long propertyId){
        String sql = "DELETE\n" +
                "FROM apartments\n" +
                "WHERE property_id = ?;";
        jdbcTemplate.update(sql, propertyId);
    }


    private Apartment mapRowToApartment(SqlRowSet rs) {
        Apartment apartment = new Apartment();
        apartment.setPropertyId(rs.getLong("property_id"));
        apartment.setAddressLine1(rs.getString("address_line_1"));
        apartment.setAddressLine2(rs.getString("address_line_2"));
        apartment.setCity(rs.getString("city"));
        apartment.setState(rs.getString("state"));
        apartment.setZip(rs.getInt("zip"));
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
