package com.scteats.scootereats.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = RestTable.class,
                                    parentColumns = "restID",
                                    childColumns = "restID",
                                    onDelete = CASCADE))
public class MenuTable {

    @PrimaryKey(autoGenerate = true)
    private int menuID;

    private int restID;


    public MenuTable(int menuID, int restID) {
        this.menuID = menuID;
        this.restID = restID;
    }


    public int getMenuID() {
        return menuID;
    }

    public int getRestID() {
        return restID;
    }

    public void setMenuID(int menuID) {
        this.menuID = menuID;
    }

    public void setRestID(int restID) {
        this.restID = restID;
    }
}
