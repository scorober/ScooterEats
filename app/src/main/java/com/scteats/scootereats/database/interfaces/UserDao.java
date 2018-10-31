package com.scteats.scootereats.database.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.scteats.scootereats.database.entities.ItemTable;
import com.scteats.scootereats.database.entities.MenuTable;
import com.scteats.scootereats.database.entities.UserTable;

import java.util.ArrayList;

@Dao
public interface UserDao {

    @Insert
    void insert(UserTable user);

    @Update
    void update(UserTable... users);

    @Delete
    void delete(UserTable... users);

//    @Query("SELECT * FROM UserTable")
//    ArrayList<MenuTable> getAllRepos();

//    @Query("SELECT * FROM MenuTable WHERE email=:email")
//    ArrayList<MenuTable> findRepositoriesForUser(final String email);
}
