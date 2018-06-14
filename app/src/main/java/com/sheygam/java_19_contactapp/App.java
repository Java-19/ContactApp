package com.sheygam.java_19_contactapp;

import android.app.Application;

import com.sheygam.java_19_contactapp.di.application.AppComponent;
import com.sheygam.java_19_contactapp.di.application.AppModule;
import com.sheygam.java_19_contactapp.di.application.DaggerAppComponent;

public class App extends Application{
    private static App app;
    private AppComponent component;

    public App() {
        app = this;
    }

    public static App get(){
        return app;
    }

    @Override
    public void onCreate() {
        component = prepareComponent();
        super.onCreate();
    }

    private AppComponent prepareComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
