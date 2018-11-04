package com.scteats.scootereats.database.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;


/**
 * User relation has no foreign key. Represents a User
 * Only entity accessed by the app so far.
 */
@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    private int uid;

    private String email;

    private String name;

    private String password;

    private char accountType;

    public User(int uid, String email,  String password, String name, char accountType) {
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.password = password;
        this.accountType = accountType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getAccountType() {
        return accountType;
    }

    public void setAccountType(char accountType) {
        this.accountType = accountType;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
