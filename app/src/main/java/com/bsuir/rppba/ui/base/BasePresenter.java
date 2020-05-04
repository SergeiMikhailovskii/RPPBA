package com.bsuir.rppba.ui.base;

import io.reactivex.disposables.CompositeDisposable;

public class BasePresenter<View> implements MvpPresenter<View> {

    public View view = null;
    public CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Override
    public void attachView(View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
        this.mCompositeDisposable.clear();
    }

}
