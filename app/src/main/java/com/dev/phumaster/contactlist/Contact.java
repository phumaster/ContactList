package com.dev.phumaster.contactlist;

import java.io.Serializable;

/**
 * Created by phumaster on 03/06/2016.
 */
public class Contact implements Serializable {
    private String name;
    private int number;

    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public int getNumber() {
        return this.number;
    }
}
