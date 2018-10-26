

package com.scteats.scootereats.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;


import com.scteats.scootereats.database.entities.ItemTable;
import com.scteats.scootereats.database.entities.MenuTable;
import com.scteats.scootereats.database.entities.RestTable;
import com.scteats.scootereats.database.entities.UserTable;

@Database(entities = {ItemTable.class, RestTable.class, MenuTable.class, UserTable.class}, version = 1)
public abstract class Database extends RoomDatabase {
    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
