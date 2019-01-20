package com.qbase.mvpdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.qbase.mvpdemo.presenter.BasePresenter;

public abstract class BaseAct<V,T extends BasePresenter<V>> extends ListActivity{

    public T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V)this);
    }

    protected abstract T createPresenter();

    @Override
    public void finish() {
        super.finish();
        if(isTaskRoot()){
            //异常退出
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDetachView();
    }

}
