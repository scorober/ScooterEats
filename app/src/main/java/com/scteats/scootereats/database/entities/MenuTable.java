package com.scteats.scootereats.database.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = RestTable.class,
                                    parentColumns = "rid",
                                    childColumns = "mid",
                                    onDelete = CASCADE))
public class MenuTable {

    @PrimaryKey(autoGenerate = true)
    private int menuID;

    private int restID;


    public MenuTable(int id, int restID) {
        this.menuID = id;
        this.restID = restID;
    }


    public int getMenuID() {
        return MenuID;
    }

    public int getRestID() {
        return restID;
    }

    public void setRestID(int restID) {
        this.restID = restID;
    }
}
