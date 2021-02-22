package com.example.traveljournal.RoomDatabase;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface FavouriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(FavouriteModel favouriteModel);

    @Query("SELECT * FROM favouriteList_table ")
    List<FavouriteModel> getFavouriteData();

    @Query("DELETE FROM favouriteList_table WHERE id = :favId")
    void delete(int favId);

}
