package com.qbase.mvpdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.qbase.mvpdemo.presenter.MainPresenter;
import com.qbase.mvpdemo.view.IMainView;

import java.util.List;

public class MainAct extends BaseAct<IMainView,MainPresenter<IMainView>> implements IMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        mPresenter.onInitData();
    }

    @Override
    protected MainPresenter<IMainView> createPresenter() {
        return new MainPresenter<>();
    }

    @Override
    public void showData(List<String> data) {
        ListAdapter adapter = new MainItemAdapter(this, data);
        setListAdapter(adapter);
    }

    private class MainItemAdapter extends ArrayAdapter<String> {

        private MainItemAdapter(Context context, List<String> demos) {
            super(context, R.layout.main_item, R.id.title, demos);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            TextView itemView;
            if (convertView instanceof TextView) {
                itemView = (TextView) convertView;
            } else {
                itemView = new TextView(getContext());
            }
            String demo = getItem(position);
            if (demo != null) {
                itemView.setText(demo);
                itemView.setPadding(10, 10, 10, 10);
                itemView.setTextColor(Color.parseColor("#FF0000"));
            }
            return itemView;
        }
    }
}
