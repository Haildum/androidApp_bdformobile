package com.example.foodproj.Domain.Model;


import androidx.room.ColumnInfo;

public class Contact {
    @ColumnInfo(name = "contact_name")
    private String name;
    @ColumnInfo(name = "contact_number")
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

