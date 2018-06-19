package com.sheygam.java_19_contactapp.presentation.contactlist.view;

import com.sheygam.java_19_contactapp.presentation.viewmodels.ContactRowModel;

import java.util.List;

public interface IContactListView {
    void showProgress();
    void hideProgress();
    void showNextView();
    void showError(String error);
    void showEmptyList();
    void updateList(List<ContactRowModel> list);
}
