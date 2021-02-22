package com.example.traveljournal;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.traveljournal.RecyclerViewFavouriteItems.FavouriteAdapter;
import com.example.traveljournal.RoomDatabase.FavouriteDatabase;
import com.example.traveljournal.RoomDatabase.FavouriteModel;

import java.util.List;

public class FavouriteListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_list);
        setFavLayoutManager();
        setFavAdapter();
    }

    private void setFavLayoutManager() {
        recyclerView = findViewById(R.id.recycler_fav);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setFavAdapter() {
        FavouriteDatabase database = Room.databaseBuilder(getApplicationContext(), FavouriteDatabase.class, "favouriteList_table").allowMainThreadQueries().build();
        List<FavouriteModel> favouriteItemList = database.favouriteDao().getFavouriteData();
        FavouriteAdapter adapter = new FavouriteAdapter(getApplicationContext(), favouriteItemList);
        recyclerView.setAdapter(adapter);
    }
}
