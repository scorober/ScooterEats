package com.scteats.scootereats.presenter;

import android.content.Context;

import com.scteats.scootereats.database.entities.User;
import com.scteats.scootereats.repos.UserRepository;

/**
 * Simple presenter that performs logic for MainActivity (Register user activity).
 *
 * @version Sprint 1
 */
public class MainPresenter {

    private View view;

    private User newUser;

    public MainPresenter(View view) {
        this.view = view;

    }

    /**
     * Creates or grabs an existing instance of the UserRepo and adds a new user.
     * @param email
     * @param password
     * @param name
     * @param accountType
     * @param context
     */
    public void registerUser(final String email, final String password,
                                String name, char accountType, Context context) {
        UserRepository repo = new UserRepository(context);
        newUser = new User(0, email, password, name, accountType);
        repo.insert(newUser);
    }


    public interface View {

    }
}
