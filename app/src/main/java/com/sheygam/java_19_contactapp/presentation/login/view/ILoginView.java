package com.sheygam.java_19_contactapp.presentation.login.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface ILoginView extends MvpView {
    void showProgress();
    void hideProgress();
    void showNextView();
    void emailValidsError(String error);
    void passValidError(String error);
    void showError(String error);
}
