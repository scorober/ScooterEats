

package com.scteats.scootereats.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;


import com.scteats.scootereats.database.entities.ItemTable;
import com.scteats.scootereats.database.entities.MenuTable;
import com.scteats.scootereats.database.entities.RestTable;
import com.scteats.scootereats.database.entities.UserTable;

@Database(entities = {ItemTable.class, RestTable.class, MenuTable.class, UserTable.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static final String DB_NAME = "scooterEatsDatabase.db";

    private static volatile Database instance;


    static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static Database create(final Context context) {
        return Room.databaseBuilder(context, Database.class, DB_NAME).build();
    }

    public abstract

//    @NonNull
//    @Override
//    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
//        return null;
//    }
//
//    @NonNull
//    @Override
//    protected InvalidationTracker createInvalidationTracker() {
//        return null;
//    }
//
//    @Override
//    public void clearAllTables() {
//
//    }
}
