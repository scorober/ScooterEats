package com.scteats.scootereats.database.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.scteats.scootereats.database.entities.MenuItem;

@Dao
public interface RestDao {
    @Insert
    void insert(MenuItem item);

    @Update
    void update(MenuItem... items);

    @Delete
    void delete(MenuItem... items);

//    @Query("SELECT * FROM Restaurant")
//    ArrayList<Restaurant> getAllRepos();

//    @Query("SELECT * FROM Menu WHERE restID=:restID")
//    ArrayList<Restaurant> findRepositoriesForUser(final int restID);
}
