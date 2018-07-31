package com.satishdasyam.mvvm.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.satishdasyam.mvvm.BuildConfig;
import com.satishdasyam.mvvm.model.Search;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Singleton
public class SearchListRepo {

    ApiService mApiService;

    @Inject
    public SearchListRepo(ApiService apiService) {
        mApiService = apiService;
    }

    public LiveData<Search> getSearchData(String artistName) {
        final MutableLiveData<Search> searchData = new MutableLiveData<>();
        mApiService.getSearchResult(artistName, BuildConfig.API_KEY).enqueue(new Callback<Search>() {
            @Override
            public void onResponse(Call<Search> call, Response<Search> response) {
                searchData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Search> call, Throwable t) {

            }
        });
        return searchData;
    }
}

