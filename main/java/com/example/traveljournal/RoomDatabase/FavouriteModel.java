package com.example.traveljournal.RoomDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.traveljournal.RecyclerViewItems.TripModel;

@Entity(tableName = "favouriteList_table", indices = {@Index(value = {"tripName", "tripDestination"}, unique = true)})
public class FavouriteModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "tripImage")
    private int tripImage;

    @ColumnInfo(name = "tripName")
    private String tripName;

    @ColumnInfo(name = "tripDestination")
    private String tripDestination;

    @ColumnInfo(name = "tripPrice")
    private String tripPrice;

    public FavouriteModel() {
    }

    public FavouriteModel(int id, int tripImage, String tripName, String tripDestination, String tripPrice) {
        this.id = id;
        this.tripImage = tripImage;
        this.tripName = tripName;
        this.tripDestination = tripDestination;
        this.tripPrice = tripPrice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTripImage() {
        return tripImage;
    }

    public void setTripImage(int tripImage) {
        this.tripImage = tripImage;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getTripDestination() {
        return tripDestination;
    }

    public void setTripDestination(String tripDestination) {
        this.tripDestination = tripDestination;
    }

    public String getTripPrice() {
        return tripPrice;
    }

    public void setTripPrice(String tripPrice) {
        this.tripPrice = tripPrice;
    }

    public FavouriteModel tripToFavourite(TripModel tripModel) {

        return new FavouriteModel(getId(), tripModel.getTripImage(), tripModel.getTripName(), tripModel.getDestinationName(), tripModel.getPriceText());
    }
}
