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
    public Rent findRentDueByRenterId(long renterUserId) {
        Rent rent = new Rent();
        String sql = "SELECT * \n" +
                "FROM account \n" +
                "JOIN ownership on account.ownership_id = ownership.ownership_id\n" +
                "JOIN users on ownership.renter = users.user_id\n" +
                "WHERE users.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, renterUserId);
        if(results.next()){
            rent = mapRowToRent(results);
        }
        return rent;
    }

    @Override
    public void updateRent(Rent rent, long accountId) {
    String sql = "UPDATE account \n" +
            "SET balance_due = ?, monthly_rent_amt = ? , past_due = ?\n" +
            "WHERE account_id =?";
    jdbcTemplate.update(sql, rent.getBalanceDue(), rent.isPastDue(), rent.getMonthlyRentAmount(), accountId);
    }


    @Override
    public void deleteRentalAccount(long accountId) {
        String sql = "DELETE FROM account WHERE account_id = ?;";
        jdbcTemplate.update(sql, accountId);
    }


    //todo update rent status (paid and status)
    private Rent mapRowToRent(SqlRowSet rs) {
        Rent rent = new Rent();
        rent.setOwnershipId(rs.getLong("ownership_id"));
        rent.setBalanceDue(rs.getBigDecimal("balance_due"));
        rent.setPastDue(rs.getBoolean("past_due"));
        rent.setMonthlyRentAmount(rs.getBigDecimal("monthly_rent_amt"));
        rent.setAccountId(rs.getLong("account_id"));
        return rent;
    }
}
