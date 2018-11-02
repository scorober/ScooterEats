package com.scteats.scootereats.repos;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import com.scteats.scootereats.database.EatsDatabase;
import com.scteats.scootereats.database.entities.User;
import com.scteats.scootereats.database.interfaces.UserDao;

import java.util.List;

public class UserRepository {

    private UserDao userDao;
    private List<User> allUsers;

    public UserRepository(Context context) {
        EatsDatabase db = EatsDatabase.getDatabase(context);
        userDao = db.userDao();
        allUsers = userDao.getAllUsers();
    }


    public void insert(User user) {
        new insertAsyncTask(userDao).execute(user);
    }

    public List<User> getAllUsers() {
        return allUsers;
    }



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
