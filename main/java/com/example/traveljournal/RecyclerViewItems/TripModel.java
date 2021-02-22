package com.example.traveljournal.RecyclerViewItems;

public class TripModel {

    private String tripName;
    private String destinationName;
    private String priceText;
    private int tripImage;
    private String favStatus;


    public TripModel(String tripName, String destinationName, String priceText, int tripImage, String favStatus) {
        this.tripName = tripName;
        this.destinationName = destinationName;
        this.priceText = priceText;
        this.tripImage = tripImage;
        this.favStatus = favStatus;
    }

    public int getTripImage() {
        return tripImage;
    }

    public void setTripImage(int tripImage) {
        this.tripImage = tripImage;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getPriceText() {
        return priceText;
    }

    public void setPriceText(String priceText) {
        this.priceText = priceText;
    }

    public String getFavStatus() {
        return favStatus;
    }

    public void setFavStatus(String favStatus) {
        this.favStatus = favStatus;
    }
}
