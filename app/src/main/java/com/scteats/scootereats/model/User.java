package com.scteats.scootereats.model;


/**
 * Represents user of the application
 * @author Scott Robertson
 * @version Sprint1
 *
 */
public class User {
    private long userId;
    private String email;
    private String password;
    private AccountType accountType;

    public User(final long userId,final String username,final String password,
                final  AccountType accountType, final String email) {
        this.userId = userId;
        this.email = username;
        this.password = password;
        this.accountType = accountType;

    }

    /**
     * Empty constructor with
     */
    public User(){
        this.userId = 0;
    }

    public long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
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

    public void setEmail(final String theEmail) {
        this.email = theEmail;
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
