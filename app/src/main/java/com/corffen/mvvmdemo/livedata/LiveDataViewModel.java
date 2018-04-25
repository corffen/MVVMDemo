package com.corffen.mvvmdemo.livedata;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

/**
 * Date: 2018-04-26 01:15
 *
 * @author: Administrator
 */
public class LiveDataViewModel extends ViewModel {

    private MutableLiveData<String> mCurrentName;

    public final ObservableField<String> content = new ObservableField<>("我是初始值");

    private int count = 0;

    public final ObservableArrayList<String> mStringObservableArrayList = new
            ObservableArrayList<>();

    public LiveDataViewModel() {
    }

    public void setData() {
        for (int i = 0; i < 9; i++) {
            mStringObservableArrayList.add("我是item" + i);
        }
    }

    public MutableLiveData<String> getCurrentName() {
        if (mCurrentName == null) {
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }

    public void setLiveDataForName(String s) {
        content.set(s);
    }

    public void changeCurrentContent() {
        count++;
        mCurrentName.setValue("我是改变后的数据" + count);
    }

    public interface RvItemOnClickListener{
        void onClickItem(int position);
    }

}
