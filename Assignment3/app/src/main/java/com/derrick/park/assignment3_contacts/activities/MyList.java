package com.derrick.park.assignment3_contacts.activities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyList {
    private static final MyList ourInstance = new MyList();

    public static MyList getInstance() {
        return ourInstance;
    }

    public ArrayList<contact> contactList = new ArrayList<>();

    private MyList() {

        contactList.add(new contact("Douglas Doe", "1122334455"));
        contactList.add(new contact("Lucas Doe", "1122334455"));
        contactList.add(new contact("John Doe", "1122334455"));
        contactList.add(new contact("Arthur Doe", "1122334455"));
        contactList.add(new contact("Derick Doe", "1122334455"));
        contactList.add(new contact("Kevin Doe", "1122334455"));
        contactList.add(new contact("Kleiton Doe", "1122334455"));
        contactList.add(new contact("Muiller Doe", "1122334455"));
        contactList.add(new contact("Jefferson Doe", "1122334455"));
        contactList.add(new contact("Daniel Doe", "1122334455"));
        contactList.add(new contact("Davi Doe", "1122334455"));
        contactList.add(new contact("Elijah Doe", "1122334455"));
        contactList.add(new contact("Neto Doe", "1122334455"));
        contactList.add(new contact("Mira Doe", "1122334455"));
        contactList.add(new contact("Katalin Doe", "1122334455"));
        contactList.add(new contact("Rafael Doe", "1122334455"));
        contactList.add(new contact("Felipe Doe", "1122334455"));

        this.sortList();
    }

    public void sortList() {
        Collections.sort(contactList, new Comparator<contact>() {
            @Override
            public int compare(contact o1, contact o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }
}