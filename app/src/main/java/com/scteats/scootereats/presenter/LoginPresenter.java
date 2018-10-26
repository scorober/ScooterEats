package com.scteats.scootereats.presenter;

import android.content.Context;
import android.view.View;

import com.scteats.scootereats.database.DBTools;
import com.scteats.scootereats.model.User;

public class LoginPresenter {

    private User user;
    private View view;
    private DBTools dbTools;

    public LoginPresenter(View view) {
        this.view = view;
    }

    public boolean isValidEmail(String email) {
        return email.contains("@");
    }


    public boolean isValidPassword(String password) {
        return password.length() >= 4;
    }

    public boolean verifyLogin(String email, String password) {
        return true;
    }

    public interface View {
        String getEmail(String email);
        String getPassword(String password);

        Context getContext();

        Boolean verifyCredentials();

    }


}
