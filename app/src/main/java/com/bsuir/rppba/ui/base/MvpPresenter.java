package com.bsuir.rppba.ui.base;

public interface MvpPresenter<View> {

    void attachView(View view);

    void detachView();

}
