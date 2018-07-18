package com.satishdasyam.mvvm.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.satishdasyam.mvvm.MvvmApp;
import com.satishdasyam.mvvm.R;
import com.satishdasyam.mvvm.databinding.ActivitySearchBinding;
import com.satishdasyam.mvvm.model.Search;
import com.satishdasyam.mvvm.room.AppDatabase;
import com.satishdasyam.mvvm.view.adapters.ArtistListAdapter;
import com.satishdasyam.mvvm.viewmodel.SearchViewModel;
import com.satishdasyam.mvvm.viewmodel.SearchViewModelFactory;

import javax.inject.Inject;

public class SearchActivity extends BaseActivity {

    ActivitySearchBinding mBinding;
    SearchViewModel mSearchViewModel;
    @Inject
    ArtistListAdapter mArtistAdapter;
    @Inject
    SearchViewModelFactory mSearchViewModelFactory;
    @Inject
    AppDatabase mAppDatabase;
    private TextView.OnEditorActionListener actionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                mSearchViewModel.getSearchData(v.getText().toString()).observe(
                        SearchActivity.this, new Observer<Search>() {
                            @Override
                            public void onChanged(@Nullable Search search) {
                                mArtistAdapter.setArtistList(search.getResults().
                                        getArtistsMatches().getArtistList());
                            }
                        });
            }
            v.setText("");
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((MvvmApp) getApplication()).getAppComponent().inject(this);
        //getActivityComponent().inject(this);
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);
        mSearchViewModel = ViewModelProviders.of(this, mSearchViewModelFactory).
                get(SearchViewModel.class);
        mBinding.setLifecycleOwner(this);
        setLayoutManager();
        mBinding.rvArtistList.setAdapter(mArtistAdapter);
        setListener();
    }

    private void setListener() {
        mBinding.evSearch.setOnEditorActionListener(actionListener);
    }

    private void setLayoutManager() {
        RecyclerView.LayoutManager layoutManager = new
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mBinding.rvArtistList.setLayoutManager(layoutManager);
    }

}
