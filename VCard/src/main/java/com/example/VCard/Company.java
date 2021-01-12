package com.example.VCard;

import lombok.Data;

import java.net.URL;

@Data
public class Company {
    String name;
    int phoneNumber;
    String mail;
    URL url;
    Adress adress;


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + "<br>" +
                ", phoneNumber=" + phoneNumber + "<br>" +
                ", mail='" + mail + "<br>" +
                ", url=" + url + "<br>" +
                ", adress=" + adress.toString() +" }<br>" +
                '}';
    }
}
