package com.qbase.mvpdemo.model;

import com.qbase.mvpdemo.IRequestListener;

import java.util.ArrayList;
import java.util.List;

public class DataModel implements IDataModel{

    @Override
    public void getData(final IRequestListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<String> data = new ArrayList<>();
                data.add("测试 -- 1");
                data.add("测试 -- 2");
                data.add("测试 -- 3");
                data.add("测试 -- 4");
                data.add("测试 -- 5");
                if(listener!=null){
                    listener.onRequestSuccess(data);
                }
            }
        }).start();
    }
}
