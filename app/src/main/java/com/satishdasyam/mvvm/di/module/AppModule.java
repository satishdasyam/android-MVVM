package com.satishdasyam.mvvm.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.bumptech.glide.request.RequestOptions;
import com.satishdasyam.mvvm.di.ApplicationScope;
import com.satishdasyam.mvvm.repository.ApiService;
import com.satishdasyam.mvvm.repository.SearchListRepo;
import com.satishdasyam.mvvm.room.AppDatabase;
import com.satishdasyam.mvvm.utils.GlideApp;
import com.satishdasyam.mvvm.utils.GlideRequests;
import com.satishdasyam.mvvm.view.adapters.ArtistListAdapter;
import com.satishdasyam.mvvm.viewmodel.SearchViewModelFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    private final Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @ApplicationScope
    @Provides
    ApiService providesRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiService.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(ApiService.class);
    }

    @ApplicationScope
    @Provides
    Context providesContext() {
        return mApplication;
    }

    @ApplicationScope
    @Provides
    GlideRequests provideGlide(Context context) {
        return GlideApp.with(context).applyDefaultRequestOptions(new RequestOptions()
                .fallback(android.R.drawable.stat_notify_error)
                .error(android.R.drawable.stat_notify_error));
    }

    @ApplicationScope
    @Provides
    AppDatabase provideRoomDatabase(Context context) {
        return Room.databaseBuilder(context,
                AppDatabase.class, "artist_db").build();
    }

    @Provides
    ArtistListAdapter provideArtistAdapter() {
        return new ArtistListAdapter();
    }

    @Provides
    SearchListRepo providesSearchListRepo(ApiService apiService) {
        return new SearchListRepo(apiService);
    }

    @Provides
    SearchViewModelFactory providesSearchViewModelFactory(SearchListRepo searchListRepo) {
        return new SearchViewModelFactory(searchListRepo);
    }

}
