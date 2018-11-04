package com.scteats.scootereats.repos;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.scteats.scootereats.database.EatsDatabase;
import com.scteats.scootereats.database.entities.User;
import com.scteats.scootereats.database.interfaces.UserDao;

import java.util.List;


/**
 * Repository that allows use of the database.
 * Needs a AsyncTask inner class so that database isn't accessed on the main thread.
 * TODO insert is already called from an AsyncTask...
 *
 * @version Sprint 1
 */
public class UserRepository {

    private UserDao userDao;
    private List<User> allUsers;

    /**
     * Repo constructor. Initializes database, DAO, and list of users.
     * @param context
     */
    public UserRepository(Context context) {
        EatsDatabase db = EatsDatabase.getDatabase(context);
        userDao = db.userDao();
        allUsers = userDao.getAllUsers();
    }

    /**
     * Insert user into DB.
     * @param user
     */
    public void insert(User user) {
        new insertAsyncTask(userDao).execute(user);
    }

    /**
     * Get all users from DB.
     * @return
     */
    public List<User> getAllUsers() {
        return allUsers;
    }


    /**
     * AsyncTask so Database operations aren't done on the main thread.
     * App will crash if DB operations aren't done in an AsyncTask
     */
    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
