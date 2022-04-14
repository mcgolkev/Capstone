package com.techelevator.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Rent {
private long ownershipId;
private BigDecimal balanceDue;
private boolean pastDue;
private BigDecimal monthlyRentAmount;


    public Rent(long ownershipId, BigDecimal balanceDue, boolean pastDue, BigDecimal monthlyRentAmount) {
        this.ownershipId = ownershipId;
        this.balanceDue = balanceDue;
        this.pastDue = pastDue;
        this.monthlyRentAmount = monthlyRentAmount;
    }

    public BigDecimal getBalanceDue() {
        return balanceDue;
    }

    public BigDecimal getMonthlyRentAmount() {
        return monthlyRentAmount;
    }

    public boolean isPastDue(){return pastDue;}

    public long getOwnershipId() {
        return ownershipId;
    }

    public void setBalanceDue(BigDecimal balanceDue) {
        this.balanceDue = balanceDue;
    }

    public void setMonthlyRentAmount(BigDecimal monthlyRentAmount) {
        this.monthlyRentAmount = monthlyRentAmount;
    }

    public void setOwnershipId(long ownershipId) {
        this.ownershipId = ownershipId;
    }

    public void setPastDue(boolean pastDue) {
        this.pastDue = pastDue;
    }
    public Rent(){

    }

    public String toString(){
        return "Rent{" +
                "ownership_id=" + ownershipId +
                ", balance_due='" + balanceDue + //'\'' +
                ", past_due='" + pastDue + //'\'' +
                ", monthly_rent_amt='" + monthlyRentAmount + //'\'' +
                '}';
    }

}
