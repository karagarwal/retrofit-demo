package com.agarwal.retrofitdemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.agarwal.retrofitdemo.Adapter.HeritageAdapter;
import com.agarwal.retrofitdemo.Adapter.HomeAdapter;
import com.agarwal.retrofitdemo.Model.HeritageCities;
import com.agarwal.retrofitdemo.Model.HomeCities;
import com.agarwal.retrofitdemo.R;
import com.agarwal.retrofitdemo.rest.ApiClient;
import com.agarwal.retrofitdemo.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeritageActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<HeritageCities> heritageCitiesList = new ArrayList<>();
    private ProgressBar progressBar;
    private HeritageAdapter heritageAdapter;
    String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heritage);

        Toolbar toolbar = findViewById(R.id.toolbarHeritage);
        setSupportActionBar(toolbar);
        recyclerView = findViewById(R.id.RecyclerViewHeritage);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        city = getIntent().getStringExtra("city");
        progressBar = findViewById(R.id.progressBarHeritage);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        getListRetrofit(apiInterface);
    }

    private void getListRetrofit(ApiInterface apiInterface) {
        progressBar.setVisibility(View.VISIBLE);
        heritageCitiesList = new ArrayList<>();
        Call<List<HeritageCities>> call = apiInterface.getDetails("Heritage", city);
        call.enqueue(new Callback<List<HeritageCities>>() {
            @Override
            public void onResponse(Call<List<HeritageCities>> call, Response<List<HeritageCities>> response) {
                progressBar.setVisibility(View.GONE);
                heritageCitiesList = response.body();
                HeritageCities temp = heritageCitiesList.get(0);
                if (TextUtils.equals(temp.getStatus_code(), "404")) {
                    Toast.makeText(HeritageActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
                }
                heritageCitiesList.remove(0);
                heritageAdapter = new HeritageAdapter(getApplicationContext(), heritageCitiesList);
                recyclerView.setAdapter(heritageAdapter);
                Log.w("ResponseHeritage", temp.getStatus_code());
            }

            @Override
            public void onFailure(Call<List<HeritageCities>> call, Throwable t) {
                Log.w("ErrorRetrofit", t.toString());
            }
        });
    }
}
