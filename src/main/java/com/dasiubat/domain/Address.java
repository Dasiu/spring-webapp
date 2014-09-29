package com.dasiubat.domain;

/**
 * Created by adam-bat-usr on 25/09/2014.
 */
public class Address {
    private String street;
    private int number;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "[" + "Ulica: " + street + " numer: " + number + "]";
    }
}
