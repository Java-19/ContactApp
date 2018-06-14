package com.sheygam.java_19_contactapp.data.login;

import io.reactivex.Completable;

public interface ILoginRepository {
    Completable login(String email, String password);
    Completable registration(String email, String password);
    Completable isLoggined();
}
