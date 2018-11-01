package com.scteats.scootereats.database.interfaces;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.scteats.scootereats.database.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);

    @Query("SELECT * from users")
    List<User> getAllUsers();


//    @Query("SELECT * FROM Menu WHERE email=:email")
//    ArrayList<Menu> findRepositoriesForUser(final String email);
}
