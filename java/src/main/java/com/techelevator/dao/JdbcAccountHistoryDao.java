package com.techelevator.dao;

import com.techelevator.model.AccountHistory;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class JdbcAccountHistoryDao implements AccountHistoryDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountHistoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<AccountHistory> allHistoryByLoggedOnUser(String principal) {
        List<AccountHistory> accountHistories = new ArrayList<>();
        String sql = "SELECT account_history.account_history_id, account_history.account_id, account_history.date, account_history.memo, account_history.amount, account_history.balance\n" +
                "FROM account_history \n" +
                "JOIN account on account_history.account_id = account.account_id\n" +
                "JOIN ownership on account.ownership_id = ownership.ownership_id\n" +
                "JOIN users on (ownership.landlord = users.user_id OR ownership.renter = users.user_id)\n" +
                "WHERE users.username = ?\n" +
                "ORDER BY account_history.account_id ASC, account_history.date ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, principal);
        while (results.next()){
            AccountHistory accountHistory = mapRowToAccountHistory(results);
            accountHistories.add(accountHistory);
        }
        return accountHistories;
    }

    @Override
    public void payRent(AccountHistory accountHistory) {

        String sql1 = "UPDATE account SET balance_due = balance_due - ? WHERE account_id = ?;";
        jdbcTemplate.update(sql1, accountHistory.getAmount(), accountHistory.getAccountId());
        
        int newBalance = 0;
        String sql2 = "INSERT INTO account_history\n" +
                "                (account_id, date, memo, amount, balance)\n" +
                "                VALUES (?, ?, ?, ?,(select balance_due from account where account.account_id = ?));";
        LocalDate date = LocalDate.parse(accountHistory.getDate());
        jdbcTemplate.update(sql2, accountHistory.getAccountId(),date, accountHistory.getMemo(),accountHistory.getAmount(), accountHistory.getAccountId());

        String sql3 = "UPDATE account SET past_due = true WHERE account_id = ? " +
                "AND balance_due > monthly_rent_amt;";
        jdbcTemplate.update(sql3, accountHistory.getAccountId());

        String sql4 = "UPDATE account SET past_due = false WHERE account_id = ? " +
                "AND balance_due <= monthly_rent_amt;";
        jdbcTemplate.update(sql4, accountHistory.getAccountId());
    }

    private AccountHistory mapRowToAccountHistory(SqlRowSet rs){
        AccountHistory accountHistory = new AccountHistory();
        accountHistory.setAccountHistoryId(rs.getLong("account_history_id"));
        accountHistory.setAccountId(rs.getLong("account_id"));
        accountHistory.setDate(rs.getString("date"));
        accountHistory.setMemo(rs.getString("memo"));
        accountHistory.setAmount(rs.getInt("amount"));
        accountHistory.setBalance(rs.getInt("balance"));
        return accountHistory;
    }
}
