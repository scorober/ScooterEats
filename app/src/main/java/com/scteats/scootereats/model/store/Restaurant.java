package com.scteats.scootereats.model.store;

public class Restaurant {

    private String myName;

    public Restaurant(final String theName) {
        this.myName = theName;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    @Override
    public String toString() {
        return this.myName;
    }
}
