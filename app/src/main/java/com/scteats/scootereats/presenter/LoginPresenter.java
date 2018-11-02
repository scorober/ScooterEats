package com.scteats.scootereats.presenter;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.scteats.scootereats.database.entities.User;
import com.scteats.scootereats.repos.UserRepository;

import java.util.List;

public class LoginPresenter {


    private View view;

    private User myUser;

    /**
     * Repository for interacting with User Dao
     */
    private UserRepository repo;

    /**
     * List of all users in User entity
     */
    private List<User> allUsers;

    /**
     * Pass the view of LoginActivity to this constructor
     * @param view
     */
    public LoginPresenter(View view) {
        this.view = view;
        repo = new UserRepository(view.getContext());
        allUsers = repo.getAllUsers();

    }
    //Need to determine where to verify email and what to return.
    public boolean verifyEmail(String email) {
        for (User user : allUsers) {
            if (email.equals(user.getEmail())) {
                myUser = user;
                return true;
            }
        }return false;
    }

    /**
     * Verifies login by connecting to UserRepository
     * @param password
     * @return True if login verified.
     */
    public boolean verifyLogin(String password) {
        if (password.equals(myUser.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public interface View {

        Boolean verifyLoginInput();

        Boolean verifyEmailInput(String email);

        Context getContext();

        void emailNotFound();



    }


}
