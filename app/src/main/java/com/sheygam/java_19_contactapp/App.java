package com.sheygam.java_19_contactapp;

import android.app.Application;

import com.sheygam.java_19_contactapp.di.application.AppComponent;
import com.sheygam.java_19_contactapp.di.application.AppModule;
import com.sheygam.java_19_contactapp.di.application.DaggerAppComponent;
import com.sheygam.java_19_contactapp.di.login.LoginComponent;
import com.sheygam.java_19_contactapp.di.login.LoginModule;

public class App extends Application{
    private static App app;
    private AppComponent component;
    private LoginComponent loginComponent;

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

    public LoginComponent plus(LoginModule module) {
        if(loginComponent == null){
            loginComponent = component.plus(module);
        }
        return loginComponent;
    }

    public void clearLoginComp(){
        loginComponent = null;
    }
}
