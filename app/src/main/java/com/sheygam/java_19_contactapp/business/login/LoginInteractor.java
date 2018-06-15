package com.sheygam.java_19_contactapp.business.login;

import com.sheygam.java_19_contactapp.data.login.ILoginRepository;

import io.reactivex.Completable;
import io.reactivex.internal.operators.completable.CompletableError;

public class LoginInteractor implements ILoginInteractor{

    private ILoginRepository repository;

    public LoginInteractor(ILoginRepository repository) {
        this.repository = repository;
    }

    @Override
    public Completable login(String email, String password) {
        if(!isEmailValid(email)){
            return new CompletableError(new EmailValidException("Email without @!"));
        }

        if(!isPasswordValid(password)){
            return new CompletableError(new PasswordValidException("Length min 4 symbols!"));
        }

        return repository.login(email,password);
    }

    @Override
    public Completable registration(String email, String password) {
        if(!isEmailValid(email)){
            return new CompletableError(new EmailValidException("Email without @!"));
        }

        if(!isPasswordValid(password)){
            return new CompletableError(new PasswordValidException("Length min 4 symbols!"));
        }

        return repository.registration(email,password);
    }

    @Override
    public Completable isLoggined() {
        return null;
    }

    private boolean isEmailValid(String email){
        return email.contains("@");
    }

    private boolean isPasswordValid(String password){
        return password.length()>=4;
    }
}
