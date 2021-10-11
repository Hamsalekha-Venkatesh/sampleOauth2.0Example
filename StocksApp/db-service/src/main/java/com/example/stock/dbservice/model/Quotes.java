package com.example.stock.dbservice.model;

//used for interaction with the user to get the quotes information

import java.util.List;

public class Quotes {

    private String userName;
    List<String> quotes;

    public Quotes() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }
}
