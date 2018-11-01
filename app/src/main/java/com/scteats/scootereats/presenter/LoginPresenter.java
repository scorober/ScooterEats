package com.scteats.scootereats.presenter;

import android.content.Context;

public class LoginPresenter {


    private View view;

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

        Boolean verifyCredentials(String email, String password);

    }


}
