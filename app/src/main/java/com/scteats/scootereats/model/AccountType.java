package com.scteats.scootereats.model;

/**
 * The different types of a user account.
 * @author Scott Robertson
 * @version Sprint 1
 */
public enum AccountType {

    /**Hungry person. */
    CUSTOMER("customer"),

    /**Restaurant owner. */
    OWNER("owner"),

    /** Delivery driver. */
    DRIVER("driver");

    private String myType;

    private AccountType(String theType) {
        this.myType = theType;
    }

    @Override
    public String toString() {
        return myType;
    }
}
