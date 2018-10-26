package com.scteats.scootereats.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.view.MenuItem;

@Entity
public class ItemTable {

    @PrimaryKey(autoGenerate = true)
    private int itemID;

    private int menuID;

    private String itemTitle;

    private double price;

    public ItemTable(int itemID, int menuID, String itemTitle, double price) {
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
}
