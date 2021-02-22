package com.example.traveljournal.RecyclerViewFavouriteItems;

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
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {

    private Context context;
    private List<FavouriteModel> favouriteModel;

    public FavouriteAdapter(Context context, List<FavouriteModel> favouriteModel) {
        this.context = context;
        this.favouriteModel = favouriteModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favourites_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FavouriteModel list = favouriteModel.get(position);
        Picasso.with(context).load(list.getTripImage()).into(holder.tripImage);
        holder.tripName.setText(list.getTripName());
        holder.tripDestination.setText(list.getTripDestination());
        holder.tripPrice.setText(list.getTripPrice());
    }

    @Override
    public int getItemCount() {
        return favouriteModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView tripImage;
        private final Button deleteButton;
        private final TextView tripName, tripDestination, tripPrice;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tripImage = itemView.findViewById(R.id.fav_trip_image);
            tripName = itemView.findViewById(R.id.fav_trip_name);
            tripDestination = itemView.findViewById(R.id.fav_destination_name);
            tripPrice = itemView.findViewById(R.id.fav_price_text);
            deleteButton = itemView.findViewById(R.id.delete_button);

            deleteButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    final FavouriteModel favModel = favouriteModel.get(position);
                    MainScreen.database.favouriteDao().delete(favModel.getId());
                }
            });

        }
    }
}
