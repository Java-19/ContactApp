package com.sheygam.java_19_contactapp.presentation.contactview.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sheygam.java_19_contactapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ContactFragment extends Fragment {
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.inputName) EditText inputName;
    @BindView(R.id.inputEmail) EditText inputEmail;
    @BindView(R.id.inputPhone) EditText inputPhone;
    @BindView(R.id.inputAddress) EditText inputAddress;
    @BindView(R.id.inputDesc) EditText inputDesc;
    @BindView(R.id.nameTxt) TextView nameTxt;
    @BindView(R.id.emailTxt) TextView emailTxt;
    @BindView(R.id.phoneTxt) TextView phoneTxt;
    @BindView(R.id.addressTxt) TextView addressTxt;
    @BindView(R.id.descTxt) TextView descTxt;
    @BindView(R.id.progressFrame) FrameLayout progressFrame;
    @BindViews({R.id.inputName,R.id.inputEmail,R.id.inputPhone,R.id.inputAddress,R.id.inputDesc})
    List<EditText> inputList;
    @BindViews({R.id.nameTxt,R.id.emailTxt,R.id.phoneTxt,R.id.addressTxt,R.id.descTxt})
    List<TextView> textList;

    private MenuItem editItem, dropItem, doneItem;
    private Unbinder unbinder;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_view,container,false);
        unbinder = ButterKnife.bind(this,view);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity!=null){
            activity.setSupportActionBar(toolbar);
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.contact_menu,menu);
        editItem = menu.findItem(R.id.itemEdit);
        dropItem = menu.findItem(R.id.itemDrop);
        doneItem = menu.findItem(R.id.itemDone);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemEdit){

        }else if(item.getItemId() == R.id.itemDrop){

        }else if(item.getItemId() == R.id.itemDone){

        }
        return true;
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
