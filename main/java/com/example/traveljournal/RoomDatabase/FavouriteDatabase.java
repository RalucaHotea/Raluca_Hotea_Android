package com.example.traveljournal.RoomDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {FavouriteModel.class}, version = 1)
public abstract class FavouriteDatabase extends RoomDatabase {

    public abstract FavouriteDao favouriteDao();

    private static volatile FavouriteDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriterExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static FavouriteDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FavouriteDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            FavouriteDatabase.class, "trip_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


}
