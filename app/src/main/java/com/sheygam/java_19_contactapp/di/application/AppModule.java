package com.sheygam.java_19_contactapp.di.application;

import android.content.Context;

import com.google.gson.Gson;
import com.sheygam.java_19_contactapp.data.provider.store.IStoreProvider;
import com.sheygam.java_19_contactapp.data.provider.store.SprefProvider;
import com.sheygam.java_19_contactapp.data.provider.web.Api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    Gson provideGson(){
        return new Gson();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttp(){
        return new OkHttpClient();

    }

    @Provides
    @Singleton
    Api provideApi(OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("https://telranstudentsproject.appspot.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(Api.class);
    }

    @Provides
    @Singleton
    IStoreProvider provideStoreProvider(Context context, Gson gson){
        return new SprefProvider(context,gson);
    }
}
