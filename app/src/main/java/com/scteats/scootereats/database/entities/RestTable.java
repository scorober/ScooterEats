package com.scteats.scootereats.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = RestTable.class,
                                    parentColumns = "rid",
                                    childColumns = "mid",
                                    onDelete = CASCADE))
public class RestTable {

    @PrimaryKey(autoGenerate = true)
    private int rid;

    private String name;

    private String genre;

    private String addres;

    private int priceLvl;

    public RestTable(int id, String name, String genre, String addres, int priceLvl) {
        this.rid = id;
        this.name = name;
        this.genre = genre;
        this.addres = addres;
        this.priceLvl = priceLvl;
    }

    public int getPriceLvl() {
        return priceLvl;
    }

    public void setPriceLvl(int priceLvl) {
        this.priceLvl = priceLvl;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
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
}
