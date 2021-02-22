package com.example.traveljournal.RecyclerViewItems;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.traveljournal.MainScreen;
import com.example.traveljournal.R;
import com.example.traveljournal.RoomDatabase.FavouriteModel;

import java.util.ArrayList;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TripModel> tripModelArrayList;
    private FavouriteModel favModel;

    public TripAdapter(Context context, ArrayList<TripModel> tripModelArrayList) {
        this.context = context;
        this.tripModelArrayList = tripModelArrayList;
        this.favModel = new FavouriteModel();
    }

    @NonNull
    @Override
    public TripAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_items, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull TripAdapter.ViewHolder holder, int position) {

        final TripModel model = tripModelArrayList.get(position);
        holder.tripImage.setImageResource(model.getTripImage());
        holder.tripName.setText(model.getTripName());
        holder.tripDestination.setText(model.getDestinationName());
        holder.tripPrice.setText(model.getPriceText());

    }

    @Override
    public int getItemCount() {
        return tripModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView tripImage;
        private final Button buttonFav;
        private final TextView tripName, tripDestination, tripPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            tripImage = itemView.findViewById(R.id.trip_image);
            tripName = itemView.findViewById(R.id.trip_name);
            tripDestination = itemView.findViewById(R.id.destination_name);
            tripPrice = itemView.findViewById(R.id.price_text);
            buttonFav = itemView.findViewById(R.id.fav_button);

            buttonFav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    TripModel tripModel = tripModelArrayList.get(position);
                    favModel = favModel.tripToFavourite(tripModel);
                    if (tripModel.getFavStatus().equals("0")) {
                        tripModel.setFavStatus("1");
                        buttonFav.setBackgroundResource(R.drawable.ic_full_heart);
                        MainScreen.database.favouriteDao().insert(favModel);

                    } else if (tripModel.getFavStatus().equals("1")) {
                        tripModel.setFavStatus("0");
                        buttonFav.setBackgroundResource(R.drawable.ic_empty_heart);
                    }

                }
            });

        }

    }


}


