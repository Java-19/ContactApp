package com.sheygam.java_19_contactapp.data.provider.store;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.sheygam.java_19_contactapp.data.dto.ContactDto;

public class SprefProvider implements IStoreProvider{
    private static final String SP_AUTH = "AUTH";
    private static final String SP_DATA = "DATA";
    private static final String TOKEN = "token";
    private static final String CURRENT_CONTACT = "current_contact";

    private Context context;
    private Gson gson;

    public SprefProvider(Context context, Gson gson) {
        this.context = context;
        this.gson = gson;
    }

    @Override
    public void saveToken(@NonNull String token) {
        context.getSharedPreferences(SP_AUTH,Context.MODE_PRIVATE)
                .edit()
                .putString(TOKEN,token)
                .apply();
    }

    @Override
    public String getToken() {
        return context.getSharedPreferences(SP_AUTH,Context.MODE_PRIVATE)
                .getString(TOKEN,null);
    }

    @Override
    public boolean isLogined() {
        String token = getToken();
        return token != null;
    }

    @Override
    public void clearToken() {
        context.getSharedPreferences(SP_AUTH,Context.MODE_PRIVATE)
                .edit()
                .remove(TOKEN)
                .apply();
    }

    @Override
    public void setCurrentContact(@NonNull ContactDto contactDto) {
        String contact = gson.toJson(contactDto);
        context.getSharedPreferences(SP_DATA,Context.MODE_PRIVATE)
                .edit()
                .putString(CURRENT_CONTACT,contact)
                .apply();
    }

    @Override
    public ContactDto getCurrentContact() {
        String contact = context.getSharedPreferences(SP_DATA,Context.MODE_PRIVATE)
                .getString(CURRENT_CONTACT,null);
        ContactDto res = null;
        if(contact!=null){
            res = gson.fromJson(contact,ContactDto.class);
        }
        return res;
    }

    @Override
    public void clearCurrentContact() {
        context.getSharedPreferences(SP_DATA,Context.MODE_PRIVATE)
                .edit()
                .remove(CURRENT_CONTACT)
                .apply();
    }
}
