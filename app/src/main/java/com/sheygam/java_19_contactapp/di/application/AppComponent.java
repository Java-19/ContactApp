package com.sheygam.java_19_contactapp.di.application;

import com.sheygam.java_19_contactapp.di.login.LoginComponent;
import com.sheygam.java_19_contactapp.di.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent {
    LoginComponent plus(LoginModule module);
}
