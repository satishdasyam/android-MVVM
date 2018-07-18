package com.satishdasyam.mvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.satishdasyam.mvvm.model.Search;
import com.satishdasyam.mvvm.repository.SearchListRepo;

import java.util.List;

public class SearchViewModel extends ViewModel {

    SearchListRepo mSearchListRepo;
    private LiveData<Search> mObservableSearchData;

    public SearchViewModel(SearchListRepo searchListRepo) {
        mSearchListRepo = searchListRepo;
    }

    public LiveData<Search> getSearchData(String artistName) {
        return mObservableSearchData = mSearchListRepo.getSearchData(artistName);
    }

    public LiveData<Search> getObservableSearchData() {
        return mObservableSearchData;
    }

    public List<Search.Artist> getArtistList() {
        return mObservableSearchData.getValue().getResults().getArtistsMatches().getArtistList();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
