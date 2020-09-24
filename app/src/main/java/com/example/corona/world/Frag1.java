package com.example.corona.world;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.corona.JsonPlaceHolderApi;
import com.example.corona.R;
import com.example.corona.world.WorldModel;
import com.example.corona.world.WorldAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Frag1 extends Fragment {
    private RecyclerView recyclerViewWorld;
    private JsonPlaceHolderApi jsonPlaceHolderApi;
    private WorldAdapter mWorldAdapter;
    private List<WorldModel> worldLists;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.frag1_layout, container, false);

        //declare the recycler view
        recyclerViewWorld=v.findViewById(R.id.frag1_list);
        recyclerViewWorld.setHasFixedSize(true);
        recyclerViewWorld.setLayoutManager(new LinearLayoutManager(v.getContext()));


        //instance of retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-19-tracking.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);



        Call<List<WorldModel>> call = jsonPlaceHolderApi.getWorldList();


        call.enqueue(new Callback<List<WorldModel>>() {
            @Override
            public void onResponse(Call<List<WorldModel>> call, Response<List<WorldModel>> response) {
                if (!response.isSuccessful()) {
                    Log.d("RetrofitResult1",String.valueOf(response.code()));
                    return;
                }
                worldLists=response.body();
                mWorldAdapter=new WorldAdapter(worldLists,Frag1.this);
                recyclerViewWorld.setAdapter(mWorldAdapter);

                // progressBar.setVisibility(View.INVISIBLE);



            }
            @Override
            public void onFailure(Call<List<WorldModel>> call, Throwable t) {
                Log.d("RetrofitFailure1",String.valueOf(t.getMessage()));
                Log.d("RetrofitFailure1",String.valueOf(t.getCause()));
            }
        });




        return v;
    }


}
