package com.example.corona.country;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona.JsonPlaceHolderApi;
import com.example.corona.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Frag2 extends Fragment {
    private RecyclerView recyclerViewCountry;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private CountryListAdapter mCountryListAdapter;
    private List<CountryModel> countryLists;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.frag2_layout, container, false);

        //declare the recycler view
        recyclerViewCountry=v.findViewById(R.id.frag2_list);
        recyclerViewCountry.setHasFixedSize(true);
        recyclerViewCountry.setLayoutManager(new LinearLayoutManager(v.getContext()));


        //instance of retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-19-tracking.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);



        Call<List<CountryModel>> call = jsonPlaceHolderApi.getCountryList();


        call.enqueue(new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {
                if (!response.isSuccessful()) {
                    Log.d("RetrofitResult",String.valueOf(response.code()));
                    return;
                }
                countryLists=response.body();
                mCountryListAdapter=new CountryListAdapter(countryLists,Frag2.this);
                recyclerViewCountry.setAdapter(mCountryListAdapter);

               // progressBar.setVisibility(View.INVISIBLE);


/*
                List<CountryModel> posts = response.body();
                for (CountryModel post : posts) {
                    String content = "";
                    content += "Country: " + post.getCountryText() + "\n";
                    //content += "Slug: " + post.getSlug() + "\n";
                    //content += "ISO2: " + post.getISO2() + "\n";
                    tv2.append(content);
                }*/
            }
            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                Log.d("RetrofitFailure",String.valueOf(t.getMessage()));
            }
        });

        return v;
    }





}
