package com.sheygam.java_19_contactapp.presentation.login.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.MvpFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.sheygam.java_19_contactapp.R;
import com.sheygam.java_19_contactapp.presentation.contactlist.view.ContactListFragment;
import com.sheygam.java_19_contactapp.presentation.login.presenter.LoginPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoginFragment extends MvpAppCompatFragment implements ILoginView{
    @BindView(R.id.regBtn)Button regBtn;
    @BindView(R.id.loginBtn)Button loginBtn;
    @BindView(R.id.inputEmail)EditText inputEmail;
    @BindView(R.id.inputPassword)EditText inputPassword;
    @BindView(R.id.loginProgress)ProgressBar loginProgress;
    @BindViews({R.id.regBtn,R.id.loginBtn,R.id.inputEmail,R.id.inputPassword})List<View> views;

    private Unbinder unbinder;

    @InjectPresenter
    LoginPresenter presenter;

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

    @OnClick({R.id.loginBtn})
    public void onLoginClicked(){
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        presenter.login(email,password);
    }

    @OnClick(R.id.regBtn)
    public void onRegistrationClicked(){
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        presenter.registration(email,password);
    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void showProgress() {
        ButterKnife.apply(views, (view, index) -> view.setEnabled(false));
        loginProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        ButterKnife.apply(views, (view, index) -> view.setEnabled(true));
        loginProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showNextView() {
        if (getFragmentManager() != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root,new ContactListFragment())
                    .commit();
        }else{
            showError("Application error!");
        }
    }

    @Override
    public void emailValidError(String error) {
        inputEmail.setError(error);
    }

    @Override
    public void passValidError(String error) {
        inputPassword.setError(error);
    }

    @Override
    public void showError(String error) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Error!")
                .setMessage(error)
                .setPositiveButton("Ok",null)
                .setCancelable(false)
                .create()
                .show();
    }
}
