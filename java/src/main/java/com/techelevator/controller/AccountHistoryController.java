package com.techelevator.controller;


import com.techelevator.dao.AccountHistoryDao;
import com.techelevator.model.AccountHistory;
import com.techelevator.model.Notification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("hasRole('LANDLORD')")
public class AccountHistoryController {

    private AccountHistoryDao accountHistoryDao;
    private AccountHistory accountHistory;

    public AccountHistoryController(AccountHistoryDao accountHistoryDao, AccountHistory accountHistory) {
        this.accountHistoryDao = accountHistoryDao;
        this.accountHistory = accountHistory;
    }


    @RequestMapping(path = "/account_history", method = RequestMethod.GET)
    public List<AccountHistory> allHistoryByLoggedOnUser(Principal principal){
        return accountHistoryDao.allHistoryByLoggedOnUser(principal.getName());
    }

    @RequestMapping(path = "/pay_rent", method = RequestMethod.POST)
    public void payRent(@RequestBody AccountHistory accountHistory){
        accountHistoryDao.payRent(accountHistory);
    }

}
