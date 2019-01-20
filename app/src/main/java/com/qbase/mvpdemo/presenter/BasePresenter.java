package com.qbase.mvpdemo.presenter;

import java.lang.ref.WeakReference;

public class BasePresenter<T> {

    protected WeakReference<T> mainView;

    public void attachView(T mainView){
        this.mainView = new WeakReference<>(mainView);
    }
    public void onDetachView(){
        this.mainView.clear();
    }
}
