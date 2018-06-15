package com.sheygam.java_19_contactapp.di.login;

import com.sheygam.java_19_contactapp.presentation.login.presenter.LoginPresenter;

import dagger.Subcomponent;

@LoginScope
@Subcomponent(modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginPresenter presenter);
}
