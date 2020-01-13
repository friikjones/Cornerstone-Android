package com.derrick.park.assignment3_contacts.activities;

import java.util.Comparator;

public class contact {
    private String name, number;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setNumber(String newNumber) {
        number = newNumber;
    }

    public contact(String name, String number) {
        setName(name);
        setNumber(number);
    }
}
