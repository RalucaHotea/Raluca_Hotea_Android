package com.example.traveljournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.traveljournal.AboutUs.AboutUsFragment;
import com.example.traveljournal.Contact.ContactFragment;
import com.example.traveljournal.Home.HomeFragment;
import com.example.traveljournal.RecyclerViewItems.TripAdapter;
import com.example.traveljournal.RecyclerViewItems.TripModel;
import com.example.traveljournal.RoomDatabase.FavouriteDatabase;
import com.example.traveljournal.Share.ShareFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private NavController navController;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private RecyclerView recyclerView;
    private ArrayList<TripModel> myTripList;
    public static FavouriteDatabase database;

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        inbox();
        setTripLayoutManager();
        setTripAdapter();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Travel Journal");
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);


        database = Room.databaseBuilder(getApplicationContext(), FavouriteDatabase.class, "favouriteList_table").allowMainThreadQueries().build();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home,
                R.id.nav_about_us,
                R.id.nav_contact,
                R.id.nav_share).setDrawerLayout(drawerLayout)
                .build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(toolbar, navController, mAppBarConfiguration);
        navigationView.bringToFront();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, HomeFragment.class, null).setReorderingAllowed(true).addToBackStack(null).commit();
                        break;
                    case R.id.item_description:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, AboutUsFragment.class, null).setReorderingAllowed(true).addToBackStack(null).commit();
                        break;
                    case R.id.item_contact:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, ContactFragment.class, null).setReorderingAllowed(true).addToBackStack(null).commit();
                        break;
                    case R.id.item_Share:
                        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, ShareFragment.class, null).setReorderingAllowed(true).addToBackStack(null).commit();
                        break;
                    case R.id.item_favorite:
                        startActivity(new Intent(MainScreen.this, FavouriteListActivity.class));
                        break;
                }

                drawerLayout.closeDrawers();
                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void inbox() {
        myTripList = new ArrayList<>();
        myTripList.add(new TripModel("Beautiful Hamnoy", "Lofoten, Norway", "800$", R.drawable.norway, "0"));
        myTripList.add(new TripModel("Scenic Lake Views", "Hallstatt, Austria", "1000$", R.drawable.hallstat, "0"));
        myTripList.add(new TripModel("Relaxing Vibes", "Soneva Fushi, Maldives", "3000$", R.drawable.maldives, "0"));
        myTripList.add(new TripModel("Mysterious Fortress ", "Suwon, South Korea", "2500$", R.drawable.suwon, "0"));
        myTripList.add(new TripModel("Stunning Islands", "Kefalonia, Greece", "1500$", R.drawable.greece, "0"));
        myTripList.add(new TripModel("Sacred and Serene ", "Kyoto, Japan", "4500$", R.drawable.kyoto, "0"));
    }

    private void setTripLayoutManager() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setTripAdapter() {
        TripAdapter tripAdapter = new TripAdapter(this, myTripList);
        recyclerView.setAdapter(tripAdapter);
    }


}
