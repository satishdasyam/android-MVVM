package com.satishdasyam.mvvm;

import android.app.Application;

import com.satishdasyam.mvvm.di.component.AppComponent;
import com.satishdasyam.mvvm.di.component.DaggerAppComponent;
import com.satishdasyam.mvvm.di.module.AppModule;

public class MvvmApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public AppComponent getAppComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder().
                    appModule(new AppModule(this)).build();
        }
        return mAppComponent;
    }
}
