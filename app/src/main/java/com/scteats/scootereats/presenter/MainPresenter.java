package com.scteats.scootereats.presenter;

import com.scteats.scootereats.database.entities.User;

public class MainPresenter {

    private User newUser;

    public void setUserType(char c) {
        newUser.setAccountType(c);
    }

    public void setUserEmail(String email) {
        newUser.setEmail(email);
    }

    public void setUserName(String name) {
        newUser.setName(name);
    }

    public void setUserPassword(String password) {
        newUser.setPassword(password);
    }

    public interface View {

    }
}
