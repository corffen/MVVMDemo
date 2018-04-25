package com.corffen.mvvmdemo.rv;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;

public class RvViewModel extends BaseObservable {

    public final ObservableArrayList<String> mStringObservableArrayList = new
            ObservableArrayList<>();

    private int count = 0;

    public RvViewModel() {

    }

    public void setData() {
        for (int i = 0; i < 9; i++) {
            mStringObservableArrayList.add("我是item" + i);
        }
    }

    public void addData() {
        count++;
        mStringObservableArrayList.add("我是添加的数据" + count);
    }

    public void clearData() {
        mStringObservableArrayList.clear();
    }

    public void clearOneData() {
        if (mStringObservableArrayList.size() > 0) {
            mStringObservableArrayList.remove(mStringObservableArrayList.size() - 1);
        }
    }
}
