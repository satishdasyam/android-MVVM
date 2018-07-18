package com.satishdasyam.mvvm.repository;

import com.satishdasyam.mvvm.model.Search;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {

    String BASE_URL = "http://ws.audioscrobbler.com/2.0/";
    String API_KEY = "fa2e62987b8c372e16daa60331164d12";

    @GET(".")
    Call<Search> getSearchResult(@QueryMap Map<String, String> options);
}
