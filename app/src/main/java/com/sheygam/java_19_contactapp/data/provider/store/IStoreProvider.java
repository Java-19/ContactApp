package com.sheygam.java_19_contactapp.data.provider.store;

import com.sheygam.java_19_contactapp.data.dto.ContactDto;

public interface IStoreProvider {
    void saveToken(String token);
    String getToken();
    boolean isLogined();
    void clearToken();
    void setCurrentContact(ContactDto contactDto);
    ContactDto getCurrentContact();
    void clearCurrentContact();
}
