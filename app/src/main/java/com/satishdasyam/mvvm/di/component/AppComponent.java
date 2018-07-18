package com.satishdasyam.mvvm.di.component;

import com.satishdasyam.mvvm.MvvmApp;
import com.satishdasyam.mvvm.di.ApplicationScope;
import com.satishdasyam.mvvm.di.module.AppModule;
import com.satishdasyam.mvvm.view.SearchActivity;

import dagger.Component;

@ApplicationScope
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MvvmApp mvvmApp);

    void inject(SearchActivity appCompatActivity);
    //ActivityComponent newActivityComponent(ActivityModule activityModule);
}
