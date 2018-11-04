package com.scteats.scootereats.database.interfaces;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.scteats.scootereats.database.entities.Address;

import java.util.List;

@Dao
public interface AddressDao {

    @Insert
    void insert(Address address);

    @Update
    void update(Address... addresses);

    @Delete
    void delete(Address... addresses);

    /*Queries... */

    @Query("SELECT * FROM Address")
    List<Address> getAllAddresses();

}
