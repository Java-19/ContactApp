package com.sheygam.java_19_contactapp.presentation.login.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.sheygam.java_19_contactapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LoginFragment extends Fragment{
    @BindView(R.id.regBtn)Button regBtn;
    @BindView(R.id.loginBtn)Button loginBtn;
    @BindView(R.id.inputEmail)EditText inputEmail;
    @BindView(R.id.inputPassword)EditText inputPassword;
    @BindView(R.id.loginProgress)ProgressBar loginProgress;
    @BindViews({R.id.regBtn,R.id.loginBtn,R.id.inputEmail,R.id.inputPassword})List<View> views;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_view,container,false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }
}
