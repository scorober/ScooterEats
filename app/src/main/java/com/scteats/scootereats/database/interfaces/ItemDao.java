package com.scteats.scootereats.database.interfaces;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.scteats.scootereats.database.entities.MenuItem;

import java.util.List;

@Dao
public interface ItemDao {

    @Insert
    void insert(MenuItem item);

    @Update
    void update(MenuItem... items);

    @Delete
    void delete(MenuItem... items);

    /*Queries... */

    @Query("SELECT * FROM MenuItem")
    List<MenuItem> getAllItems();

}
