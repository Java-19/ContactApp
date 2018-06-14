package com.sheygam.java_19_contactapp.data.dto;

public class RemoveContactDto {
    private long contactId;

    public RemoveContactDto() {
    }

    public RemoveContactDto(long contactId) {
        this.contactId = contactId;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }
}
