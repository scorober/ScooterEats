package com.scteats.scootereats.database.entities;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class UserTable {
    @PrimaryKey(autoGenerate = true)
    private int uid;

    private String email;

    private String name;

    private String password;

    //Based off enum type
    private String accountType;

    public UserTable(int uid, String email, String name, String password) {
        this.uid = uid;
        this.email = email;
        this.name = name;
        this.password = password;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
