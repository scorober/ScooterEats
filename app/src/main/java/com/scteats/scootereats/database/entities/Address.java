package com.scteats.scootereats.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Address {

    @PrimaryKey(autoGenerate = true)
    private int addID;

    //Customer ID, Restaurant address are stored in Restaurant table
    private int custID;

    private String Address;

    public Address(int id, int custID, String Address) {
        this.addID = id;
        this.custID = custID;
        this.Address = Address;
    }

}
