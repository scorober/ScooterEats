package com.scteats.scootereats.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;


import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Menu.class,
        parentColumns = "menuID",
        childColumns = "menuID",
        onDelete = CASCADE))
public class MenuItem {

    @PrimaryKey(autoGenerate = true)
    private int itemID;

    private int menuID;

    private String itemTitle;

    private double price;

    public MenuItem(int itemID, int menuID, String itemTitle, double price) {
        this.itemID = itemID;
        this.menuID = menuID;
        this.itemTitle = itemTitle;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public int getMenuID() {
        return menuID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

}
