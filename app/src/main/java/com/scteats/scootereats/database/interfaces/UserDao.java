package com.scteats.scootereats.database.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.scteats.scootereats.database.entities.User;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);

//    @Query("SELECT * FROM User")
//    ArrayList<Menu> getAllRepos();

//    @Query("SELECT * FROM Menu WHERE email=:email")
//    ArrayList<Menu> findRepositoriesForUser(final String email);
}
