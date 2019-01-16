package com.agarwal.retrofitdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.agarwal.retrofitdemo.Activity.HeritageActivity;
import com.agarwal.retrofitdemo.Model.HeritageCities;
import com.agarwal.retrofitdemo.Model.HomeCities;
import com.agarwal.retrofitdemo.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class HeritageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HeritageCities> heritageCitiesList;

    public HeritageAdapter(Context context, List<HeritageCities> heritageCitiesList) {
        this.context = context;
        this.heritageCitiesList = heritageCitiesList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View adapterView = LayoutInflater.from(context).inflate(R.layout.card_view, viewGroup, false);
        return new HomeViewHolder(adapterView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        HomeViewHolder homeViewHolder = (HomeViewHolder) viewHolder;
        HeritageCities heritageCities = heritageCitiesList.get(position);

        homeViewHolder.title.setText(heritageCities.getName());
        homeViewHolder.shortDesc.setText(heritageCities.getShortdesc());
        Glide.with(context).asDrawable()
                .load(heritageCities.getImage())
                .apply(RequestOptions.placeholderOf(R.drawable.placeholder_city))
                .into(homeViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return heritageCitiesList.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        ImageView imageView;
        TextView title, shortDesc;
        public ImageButton imageButton;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cityImage);
            title = itemView.findViewById(R.id.cityTitle);
            shortDesc = itemView.findViewById(R.id.cityDescription);
            cardView = itemView.findViewById(R.id.cityCard);
            imageButton = cardView.findViewById(R.id.cityClicked);
        }
    }
}
