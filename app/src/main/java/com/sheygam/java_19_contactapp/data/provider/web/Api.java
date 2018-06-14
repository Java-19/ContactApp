package com.sheygam.java_19_contactapp.data.provider.web;

import com.sheygam.java_19_contactapp.data.dto.AuthDto;
import com.sheygam.java_19_contactapp.data.dto.TokenDto;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {

    @POST("_ah/api/contactsApi/v1/registration")
    Single<Response<TokenDto>> registration(@Body AuthDto authDto);

    @POST("_ah/api/contactsApi/v1/login")
    Single<Response<TokenDto>> login(@Body AuthDto authDto);
}
