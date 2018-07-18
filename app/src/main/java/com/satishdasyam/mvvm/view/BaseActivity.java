package com.satishdasyam.mvvm.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /*public ActivityComponent getActivityComponent() {
        return ((MvvmApp) getApplication()).getAppComponent().
                newActivityComponent(new ActivityModule(this));
    }*/
}
