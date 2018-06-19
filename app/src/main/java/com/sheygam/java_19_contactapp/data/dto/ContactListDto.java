package com.sheygam.java_19_contactapp.data.dto;

import java.util.List;

public class ContactListDto {
    private List<ContactDto> contacts;

    public ContactListDto() {
    }

    public ContactListDto(List<ContactDto> contacts) {
        this.contacts = contacts;
    }

    public List<ContactDto> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactDto> contacts) {
        this.contacts = contacts;
    }
}
