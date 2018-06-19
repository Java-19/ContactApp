package com.sheygam.java_19_contactapp.presentation.login.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.sheygam.java_19_contactapp.App;
import com.sheygam.java_19_contactapp.business.login.EmailValidException;
import com.sheygam.java_19_contactapp.business.login.ILoginInteractor;
import com.sheygam.java_19_contactapp.business.login.PasswordValidException;
import com.sheygam.java_19_contactapp.di.login.LoginModule;
import com.sheygam.java_19_contactapp.presentation.login.view.ILoginView;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class LoginPresenter extends MvpPresenter<ILoginView> implements ILoginPresenter{

    @Inject
    ILoginInteractor interactor;

    private Disposable disposable;

    public LoginPresenter() {
        App.get().plus(new LoginModule()).inject(this);
    }


    @Override
    protected void onFirstViewAttach() {
        getViewState().showProgress();
        disposable = interactor.isLoggined()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                    getViewState().hideProgress();
                    getViewState().showNextView();
                }, throwable -> {
                    getViewState().hideProgress();
                    getViewState().showError("Auth error! Please login again!");
                });
    }

    @Override
    public void login(String email, String password) {
        getViewState().showProgress();
        disposable = interactor.login(email,password)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::loginSuccess,this::loginError);
    }

    private void loginError(Throwable throwable) {
        getViewState().hideProgress();
        if(throwable instanceof EmailValidException){
            getViewState().emailValidError(throwable.getMessage());
        }else if(throwable instanceof PasswordValidException){
            getViewState().passValidError(throwable.getMessage());
        }else {
            getViewState().showError(throwable.getMessage());
        }
    }

    private void loginSuccess() {
        getViewState().hideProgress();
        getViewState().showNextView();
    }

    @Override
    public void registration(String email, String password) {
        getViewState().showProgress();
        disposable = interactor.registration(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::regSuccess,this::regError);
    }

    private void regError(Throwable throwable) {
        getViewState().hideProgress();
        if(throwable instanceof EmailValidException){
            getViewState().emailValidError(throwable.getMessage());
        }else if(throwable instanceof PasswordValidException){
            getViewState().passValidError(throwable.getMessage());
        }else {
            getViewState().showError(throwable.getMessage());
        }
    }

    private void regSuccess() {
        getViewState().hideProgress();
        getViewState().showNextView();
    }

    @Override
    public void onDestroy() {
        if (disposable!=null){
            disposable.dispose();
        }
        App.get().clearLoginComp();
        super.onDestroy();
    }
}
