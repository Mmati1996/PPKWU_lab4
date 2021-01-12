package com.example.VCard;

import lombok.Data;

@Data
public class Adress {

    String street;
    String locality;
    String country;
    String postalCode;

    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + "<br>"+
                ", locality='" + locality + "<br>" +
                ", country='" + country + "<br>" +
                ", postalCode='" + postalCode + "<br>" +
                '}';
    }
}
