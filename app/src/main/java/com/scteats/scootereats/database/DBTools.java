package com.scteats.scootereats.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.scteats.scootereats.model.User;


/**
 * Interacts with SQLite db.
 *
 * Shamelessly copied with some revisions from:
 * https://stackoverflow.com/questions/22209046/example-and-explanation-android-studio-login-activity-template-generated-acti#
 * @author Scott Robertson
 * @version Sprint1
 */
public class DBTools extends SQLiteOpenHelper{

    private final static int DB_VERSION = 10;

    public DBTools(Context context) {
        super(context, "scooterEats.db", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //Added accountType attribute to logins table
        String query = "create table logins (userId Integer primary key autoincrement, " +
                "username text, password text, accountType text)";
        sqLiteDatabase.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        try{
            System.out.println("UPGRADE DB oldVersion="+oldVersion+" - newVersion="+newVersion);
            onCreate(sqLiteDatabase);
            if (oldVersion<10){
                String query = "create table logins (userId Integer primary key autoincrement, "+
                        " username text, password text, accountType text)";
                sqLiteDatabase.execSQL(query);
            }
        }
        catch (Exception e){e.printStackTrace();}
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // super.onDowngrade(db, oldVersion, newVersion);
        System.out.println("DOWNGRADE DB oldVersion="+oldVersion+" - newVersion="+newVersion);
    }

    public User insertUser(User queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", queryValues.getUsername());
        values.put("password", queryValues.getPassword());
        queryValues.setUserId(database.insert("logins", null, values));
        database.close();
        database.close();
        return queryValues;

    }

    public int updateUserPassword(User queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", queryValues.getUsername());
        values.put("password", queryValues.getPassword());
        queryValues.setUserId(database.insert("logins", null, values));
        database.close();
        return database.update("logins", values, "userId = ?",
                new String[] {String.valueOf(queryValues.getUserId())});
    }

    public User getUser(String username) {
        String query = "Select userId, password, accountType from logins where username ='"
                + username + "'";
        User myUser = new User();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                myUser.setUserId(cursor.getLong(0));
                myUser.setPassword(cursor.getString(1));
                myUser.setAccountType(cursor.getString(2));
            } while (cursor.moveToNext());

        }
        return myUser;

    }
}
