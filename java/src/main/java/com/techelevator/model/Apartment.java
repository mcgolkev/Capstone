package com.techelevator.model;

public class Apartment {

    private Long propertyId;
    private String address;
    private Double price;
    private String picture;
    private double numBedrooms;
    private double numBathrooms;
    private Integer squareFeet;
    private String shortDescription;
    private String longDescription;
    private String dateAvailable; // YYYY-mm-dd

    public Apartment(Long propertyId, String address, Double price, String picture, double numBedrooms, double numBathrooms, Integer squareFeet, String shortDescription, String longDescription, String dateAvailable) {
        this.propertyId = propertyId;
        this.address = address;
        this.price = price;
        this.picture = picture;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.squareFeet = squareFeet;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.dateAvailable = dateAvailable;
    }

    public Apartment() {

    }

    //-----------getters------------------------------

    public Long getPropertyId() {
        return propertyId;
    }
    public String getAddress() {
        return address;
    }

    public Double getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public double getNumBedrooms() {
        return numBedrooms;
    }

    public double getNumBathrooms() {
        return numBathrooms;
    }

    public Integer getSquareFeet() {
        return squareFeet;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public String getDateAvailable() {
        return dateAvailable;
    }


    //-------------------------------setters


    public void setPropertyId(Long propertyId) {
        this.propertyId = propertyId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setNumBedrooms(double numBedrooms) {
        this.numBedrooms = numBedrooms;
    }

    public void setNumBathrooms(double numBathrooms) {
        this.numBathrooms = numBathrooms;
    }

    public void setSquareFeet(Integer squareFeet) {
        this.squareFeet = squareFeet;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public void setDateAvailable(String dateAvailable) {
        this.dateAvailable = dateAvailable;
    }



    //---------------methods---------------------------
    public String toString() {
        return "Apartment{" +
                "property_id=" + propertyId +
                ", address='" + address + //'\'' +
                ", price='" + price + //'\'' +
                ", picture='" + picture + //'\'' +
                ", available='" + dateAvailable + //'\'' +
                ", numBathrooms=" + numBathrooms +
                ", numBedrooms=" + numBedrooms +
                ", square_feet=" + squareFeet + //'\'' +
                ", short_description=" + shortDescription +
                ", long_description=" + longDescription +
                // ..... other info
                '}';
    }
}
