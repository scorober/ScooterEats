

package com.scteats.scootereats.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


import com.scteats.scootereats.database.entities.Address;
import com.scteats.scootereats.database.entities.MenuItem;
import com.scteats.scootereats.database.entities.Menu;
import com.scteats.scootereats.database.entities.Restaurant;
import com.scteats.scootereats.database.entities.User;
import com.scteats.scootereats.database.interfaces.AddressDao;
import com.scteats.scootereats.database.interfaces.ItemDao;
import com.scteats.scootereats.database.interfaces.MenuDao;
import com.scteats.scootereats.database.interfaces.RestDao;
import com.scteats.scootereats.database.interfaces.UserDao;


//TODO add orders table

/**
 * Room Database class.
 */
@Database(entities = {MenuItem.class, Restaurant.class, Menu.class, User.class, Address.class},
        version = 1,
        exportSchema = false)
public abstract class EatsDatabase extends RoomDatabase {

    //Daos
    abstract public ItemDao itemDao();
    abstract public MenuDao menuDao();
    abstract public RestDao restDao();
    abstract public UserDao userDao();
    abstract public AddressDao addressDao();

    /**
     * Database name.
     */
    private static final String DB_NAME = "scooterEatsDatabase.db";

    /**
     * Static instance of the database
     */
    private static volatile EatsDatabase INSTANCE;

    /**
     * Gets the current database, creates one if database doesn't exist.
     * @param context Context querying the database
     * @return The database
     */
    public static EatsDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EatsDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EatsDatabase.class, DB_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
