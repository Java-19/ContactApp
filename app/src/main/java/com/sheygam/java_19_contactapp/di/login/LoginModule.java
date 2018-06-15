package com.sheygam.java_19_contactapp.di.login;

import com.sheygam.java_19_contactapp.business.login.ILoginInteractor;
import com.sheygam.java_19_contactapp.business.login.LoginInteractor;
import com.sheygam.java_19_contactapp.data.login.ILoginRepository;
import com.sheygam.java_19_contactapp.data.login.LoginRepository;
import com.sheygam.java_19_contactapp.data.provider.store.IStoreProvider;
import com.sheygam.java_19_contactapp.data.provider.web.Api;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    @LoginScope
    ILoginRepository provideRepository(Api api, IStoreProvider storeProvider){
        return new LoginRepository(api,storeProvider);
    }

    @Provides
    @LoginScope
    ILoginInteractor provideInteractor(ILoginRepository repository){
        return new LoginInteractor(repository);
    }
}
