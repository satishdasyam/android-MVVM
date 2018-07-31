package com.satishdasyam.mvvm.repository;

import com.satishdasyam.mvvm.model.Search;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("?method=artist.search&format=json")
    Call<Search> getSearchResult(@Query("artist") String artist, @Query("api_key") String apiKey);
}