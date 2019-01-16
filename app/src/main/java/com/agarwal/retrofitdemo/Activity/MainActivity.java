package com.agarwal.retrofitdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ProgressBar;

import com.agarwal.retrofitdemo.Adapter.HomeAdapter;
import com.agarwal.retrofitdemo.Model.HomeCities;
import com.agarwal.retrofitdemo.rest.ApiClient;
import com.agarwal.retrofitdemo.rest.ApiInterface;
import com.agarwal.retrofitdemo.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<HomeCities> homeCitiesList = new ArrayList<>();
    private ProgressBar progressBar;
    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        progressBar = findViewById(R.id.progressBarHome);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        getListRetrofit(apiInterface);
    }

    private void getListRetrofit(ApiInterface apiInterface) {
        homeCitiesList = new ArrayList<>();
        Call<List<HomeCities>> call = apiInterface.getCityDetails();
        call.enqueue(new Callback<List<HomeCities>>() {
            @Override
            public void onResponse(Call<List<HomeCities>> call, retrofit2.Response<List<HomeCities>> response) {
                homeCitiesList = response.body();
                homeAdapter = new HomeAdapter(getApplicationContext(), homeCitiesList);
                recyclerView.setAdapter(homeAdapter);
                Log.w("ResponseRetrofit", homeCitiesList.toString());
            }

            @Override
            public void onFailure(Call<List<HomeCities>> call, Throwable t) {
                Log.w("ErrorRetrofit", t.toString());
            }
        });
    }
}
