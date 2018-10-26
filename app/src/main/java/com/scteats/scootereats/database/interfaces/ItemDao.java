package com.scteats.scootereats.database.interfaces;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.scteats.scootereats.database.entities.ItemTable;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert
    void insert(ItemTable item);

    @Update
    void update(ItemTable... items);

    @Delete
    void delete(ItemTable... items);

    /*Queries...
    @Query("SELECT * FROM ITEMTABLE")
    List<ItemTable> getAllItems();

    */
}
