package com.example.btlthadr.Activity.Domain;

public class Price {
    private int Id;
    private String Value;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public Price(){

    }

    @Override
    public String toString() {
        return Value ;
    }
}