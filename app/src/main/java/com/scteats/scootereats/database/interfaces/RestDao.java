package com.scteats.scootereats.database.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.scteats.scootereats.database.entities.ItemTable;
import com.scteats.scootereats.database.entities.MenuTable;
import com.scteats.scootereats.database.entities.RestTable;

import java.util.ArrayList;

@Dao
public interface RestDao {
    @Insert
    void insert(ItemTable item);

    @Update
    void update(ItemTable... items);

    @Delete
    void delete(ItemTable... items);

//    @Query("SELECT * FROM RestTable")
//    ArrayList<RestTable> getAllRepos();

//    @Query("SELECT * FROM MenuTable WHERE restID=:restID")
//    ArrayList<RestTable> findRepositoriesForUser(final int restID);
}
