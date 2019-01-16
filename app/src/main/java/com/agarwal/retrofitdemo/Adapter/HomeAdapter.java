package com.agarwal.retrofitdemo.Adapter;

import android.content.Context;
import android.content.Intent;
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
import com.agarwal.retrofitdemo.Model.HomeCities;
import com.agarwal.retrofitdemo.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<HomeCities> homeCityList;

    public HomeAdapter(Context context, List<HomeCities> homeCityList) {
        this.context = context;
        this.homeCityList = homeCityList;
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
        HomeCities homeCities = homeCityList.get(position);

        homeViewHolder.title.setText(homeCities.getTitle());
        homeViewHolder.shortDesc.setText(homeCities.getShortdesc());
        Glide.with(context).asDrawable()
                .load(homeCities.getImage())
                .apply(RequestOptions.placeholderOf(R.drawable.placeholder_city))
                .into(homeViewHolder.imageView);
        homeViewHolder.imageButton.setTag(position);
    }

    @Override
    public int getItemCount() {
        return homeCityList.size();
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
            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = (int) view.getTag();
                    String city = homeCityList.get(position).getName();
                    Intent intent = new Intent(context, HeritageActivity.class);
                    intent.putExtra("city", city);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }
}
