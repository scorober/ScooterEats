package com.scteats.scootereats.database.interfaces;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.scteats.scootereats.database.entities.ItemTable;
import com.scteats.scootereats.database.entities.UserTable;

public interface UserDao {

    @Insert
    void insert(UserTable user);

    @Update
    void update(UserTable... users);

    @Delete
    void delete(UserTable... users);
}
