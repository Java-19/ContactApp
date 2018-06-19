package com.sheygam.java_19_contactapp.business.businessmodels;

public class ContactBusinessModel {
    private long contactId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String description;

    public ContactBusinessModel() {
    }

    public ContactBusinessModel(long contactId, String fullName, String email, String phoneNumber, String address, String description) {
        this.contactId = contactId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.description = description;
    }

    public long getContactId() {
        return contactId;
    }

    public void setContactId(long contactId) {
        this.contactId = contactId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
