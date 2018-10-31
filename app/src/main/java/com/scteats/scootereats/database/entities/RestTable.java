package com.scteats.scootereats.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;



@Entity
public class RestTable {

    @PrimaryKey(autoGenerate = true)
    private int restID;

    private String name;

    private String genre;

    private String address;

    private int priceLvl;

    public RestTable(int restID, String name, String genre, String address, int priceLvl) {
        this.restID = restID;
        this.name = name;
        this.genre = genre;
        this.address = address;
        this.priceLvl = priceLvl;
    }

    public int getPriceLvl() {
        return priceLvl;
    }

    public void setPriceLvl(int priceLvl) {
        this.priceLvl = priceLvl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String addres) {
        this.address = addres;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRestID() {
        return restID;
    }

    public void setRestID(int restID) {
        this.restID = restID;
    }
}
