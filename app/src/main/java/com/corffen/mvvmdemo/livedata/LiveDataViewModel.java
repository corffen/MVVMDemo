package com.corffen.mvvmdemo.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2018-04-26 01:15
 *
 * @author: Administrator
 */
public class LiveDataViewModel extends ViewModel {

    private MutableLiveData<String> mCurrentName;

    public final ObservableField<String> content = new ObservableField<>("我是初始值");

    private int count = 0;
    private int dataCount = 0;
    private MutableLiveData<List<String>> mSoureceDatas;

    public final ObservableArrayList<String> mStringObservableArrayList = new
            ObservableArrayList<>();

    public LiveDataViewModel() {
        mSoureceDatas = new MutableLiveData<>();
    }

    public void setData() {
        List<String> titls = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            titls.add("我是item" + i);
        }
        mSoureceDatas.setValue(titls);
    }

    public void updataContent(int position) {
        content.set(mStringObservableArrayList.get(position));
    }

    public MutableLiveData<String> getCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }

    public MutableLiveData<List<String>> getSoureceDatas() {
        if (mSoureceDatas == null) {
            mSoureceDatas = new MutableLiveData<>();
        }
        return mSoureceDatas;
    }

    public void changeDatas() {
        dataCount++;
        mStringObservableArrayList.clear();
        for (int i = 10 * dataCount; i < 10 + dataCount * 10; i++) {
            mStringObservableArrayList.add("我是改变后的item" + i);
        }
    }

    public void addTitleToList(List<String> titles) {
        mStringObservableArrayList.clear();
        mStringObservableArrayList.addAll(titles);
    }

    public void setLiveDataForName(String s) {
        content.set(s);
    }

    public void changeCurrentContent() {
        count++;
        mCurrentName.setValue("我是改变后的数据" + count);
    }


}
