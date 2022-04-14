package com.techelevator.dao;

import com.techelevator.model.Apartment;
import com.techelevator.model.Rent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcRentDao implements RentDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcRentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Rent findRentDue(long id) {
        Rent rent = new Rent();
        String sql = "SELECT balance_due FROM account WHERE ownership_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if(results.next()){
            rent = mapRowToRent(results);
        }
        return rent;
    }

    @Override
    public void updateRent(Rent rent, long id) {
    String sql = "UPDATE account SET balance_due = ?, past_due = ?, monthly_rent_amt = ? WHERE owndership_id =?";
    jdbcTemplate.update(sql, rent.getBalanceDue(), rent.isPastDue(), rent.getMonthlyRentAmount(), id);
    }


    @Override
    public void deleteRentalAccount(long id) {
        String sql = "DELETE FROM account WHERE ownership_id = ?;";
        jdbcTemplate.update(sql, id);
    }


    //todo update rent status (paid and status)
    private Rent mapRowToRent(SqlRowSet rs) {
        Rent rent = new Rent();
        rent.setOwnershipId(rs.getLong("owner_id"));
        rent.setBalanceDue(rs.getBigDecimal("balance_due"));
        rent.setPastDue(rs.getBoolean("past_due"));
        rent.setMonthlyRentAmount(rs.getBigDecimal("monthly_rent_amt"));
        return rent;
    }
}
