package com.qbase.mvpdemo.presenter;

import android.os.Handler;

import com.qbase.mvpdemo.IRequestListener;
import com.qbase.mvpdemo.model.DataModel;
import com.qbase.mvpdemo.model.IDataModel;
import com.qbase.mvpdemo.view.IMainView;

import java.util.List;

public class MainPresenter<T extends IMainView> extends BasePresenter<T>{

    private IDataModel dataModel= new DataModel();

    private Handler mHandler = new Handler();

    public MainPresenter() {
    }

    public void onInitData(){
        dataModel.getData(new IRequestListener<List<String>>() {
            @Override
            public void onRequestSuccess(final List<String> data) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(mainView!=null){
                            mainView.get().showData(data);
                        }
                    }
                });
            }
        });
    }
}
