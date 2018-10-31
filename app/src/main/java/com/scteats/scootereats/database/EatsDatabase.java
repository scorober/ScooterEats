

package com.scteats.scootereats.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


import com.scteats.scootereats.database.entities.ItemTable;
import com.scteats.scootereats.database.entities.MenuTable;
import com.scteats.scootereats.database.entities.RestTable;
import com.scteats.scootereats.database.entities.UserTable;
import com.scteats.scootereats.database.interfaces.ItemDao;
import com.scteats.scootereats.database.interfaces.MenuDao;
import com.scteats.scootereats.database.interfaces.RestDao;
import com.scteats.scootereats.database.interfaces.UserDao;


//TODO add orders table
@Database(entities = {ItemTable.class, RestTable.class, MenuTable.class, UserTable.class},
        version = 1,
        exportSchema = false)
public abstract class EatsDatabase extends RoomDatabase {

    private static final String DB_NAME = "scooterEatsDatabase.db";

    private static volatile EatsDatabase instance;


    static synchronized EatsDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static EatsDatabase create(final Context context) {
        return Room.databaseBuilder(context, EatsDatabase.class, DB_NAME).build();
    }

    abstract public ItemDao itemDao();

    abstract public MenuDao menuDao();

    abstract public RestDao restDao();

    abstract public UserDao userDao();

//    public abstract

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
