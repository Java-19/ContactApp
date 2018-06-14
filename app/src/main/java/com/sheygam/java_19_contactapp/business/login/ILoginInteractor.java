package com.sheygam.java_19_contactapp.business.login;

import io.reactivex.Completable;

public interface ILoginInteractor {
    Completable login(String email, String password);
    Completable registration(String email, String password);
    Completable isLoggined();
}
