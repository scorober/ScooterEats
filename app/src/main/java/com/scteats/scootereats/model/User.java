package com.scteats.scootereats.model;


/**
 * Represents user of the application
 * @author Scott Robertson
 * @version Sprint1
 *
 */
public class User {
    private long userId;
    private String username;
    private String password;
    private AccountType accountType;

    public User(long userId, String username, String password, AccountType accountType) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.accountType = accountType;

    }

    public User(){
        this.userId = 0;
        this.username = null;
        this.password = null;
        this.accountType = null;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAccountType() {
        return accountType.toString();
    }

    public void setUserId(final long theId) {
        this.userId = theId;
    }

    public void setUsername(final String theName) {
        this.username = theName;
    }

    public void setPassword(final String thePassword) {
        this.password = thePassword;
    }

    /**
     * Sets AccountType field of user.
     * @param theType String value to compare to AccountType toString.
     */
    public void setAccountType(final String theType) {

        for(AccountType a: AccountType.values()) {
            if (theType.toLowerCase().equals(a.toString())) {
                this.accountType = a;
            }
        }
    }
}
