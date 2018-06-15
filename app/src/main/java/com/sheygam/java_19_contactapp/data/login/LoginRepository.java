package com.sheygam.java_19_contactapp.data.login;

import android.annotation.SuppressLint;
import android.util.Log;

import com.sheygam.java_19_contactapp.data.dto.AuthDto;
import com.sheygam.java_19_contactapp.data.dto.TokenDto;
import com.sheygam.java_19_contactapp.data.provider.store.IStoreProvider;
import com.sheygam.java_19_contactapp.data.provider.web.Api;

import io.reactivex.Completable;
import io.reactivex.functions.Consumer;
import retrofit2.Response;


public class LoginRepository implements ILoginRepository{
    private static final String TAG = "LOGIN_REP";
    private Api api;
    private IStoreProvider storeProvider;

    public LoginRepository(Api api, IStoreProvider storeProvider) {
        this.api = api;
        this.storeProvider = storeProvider;
    }

    @SuppressLint("CheckResult")
    @Override
    public Completable login(String email, String password) {
        AuthDto authDto = new AuthDto(email,password);

        return Completable.fromSingle(api.login(authDto)
                .onErrorResumeNext(throwable -> {
                    throw new Exception("Connection error");
                })
                .doOnSuccess(this::loginLogic));
    }

    @Override
    public Completable registration(String email, String password) {
        AuthDto authDto = new AuthDto(email,password);

        return Completable.fromSingle(api.login(authDto)
                .onErrorResumeNext(throwable -> {
                    throw new Exception("Connection error");
                })
                .doOnSuccess(this::regLogic));
    }

    @Override
    public Completable isLoggined() {
        return null;
    }


    private void loginLogic(Response<TokenDto> tokenDtoResponse) throws Exception {
        if(tokenDtoResponse.isSuccessful()){
            if (tokenDtoResponse.body() != null) {
                String token = tokenDtoResponse.body().getToken();
                storeProvider.saveToken(token);
            }else{
                Log.e(TAG, "accept: token is null!");
                throw new Exception("Something was wrong! Try Again");
            }
        }else if(tokenDtoResponse.code() == 401){
            throw new Exception("Wrong email or password!");
        }else{
            Log.e(TAG, "accept error: " + tokenDtoResponse.errorBody().string());
            throw new Exception("Server error! Call to support!");
        }
    }

    private void regLogic(Response<TokenDto> tokenDtoResponse) throws Exception {
        if(tokenDtoResponse.isSuccessful()){
            if (tokenDtoResponse.body() != null) {
                String token = tokenDtoResponse.body().getToken();
                storeProvider.saveToken(token);
            }else{
                Log.e(TAG, "accept: token is null!");
                throw new Exception("Something was wrong! Try Again");
            }
        }else if(tokenDtoResponse.code() == 409){
            throw new Exception("User already exist!");
        }else{
            Log.e(TAG, "accept error: " + tokenDtoResponse.errorBody().string());
            throw new Exception("Server error! Call to support!");
        }
    }
}
