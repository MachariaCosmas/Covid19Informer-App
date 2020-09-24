package com.example.corona;

import com.example.corona.country.CountryModel;
import com.example.corona.world.WorldModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface JsonPlaceHolderApi {

    @Headers({
            "x-rapidapi-host: covid-19-tracking.p.rapidapi.com",
            "x-rapidapi-key: c73e5f5feamsh85f516c989967bbp15c06ajsne7f637d3dac4",
    })
    @GET("v1")
    Call<List<CountryModel>> getCountryList();


//get Kenya data
    @Headers({
            "x-rapidapi-host: covid-19-tracking.p.rapidapi.com",
            "x-rapidapi-key: c73e5f5feamsh85f516c989967bbp15c06ajsne7f637d3dac4",
    })
    @GET("v1/World")
    Call<List<WorldModel>> getWorldList();




}
