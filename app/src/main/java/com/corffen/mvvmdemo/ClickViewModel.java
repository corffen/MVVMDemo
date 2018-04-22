package com.corffen.mvvmdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Date: 2018-04-22 19:36
 *
 * @author: Administrator
 */
public class ClickViewModel extends BaseObservable {

    private User4 mUser4;
    private int count;

    public ClickViewModel(User4 user4) {
        mUser4 = user4;
        count = 0;
    }

    @Bindable
    public String getBtnContent() {
        return mUser4.getBtnContent();
    }

    public void setBtnContent(String content) {
        mUser4.setBtnContent(content);
        notifyChange();
    }

    public void clickMe() {
        count++;
        setBtnContent("点我啊" + count);
    }
}
