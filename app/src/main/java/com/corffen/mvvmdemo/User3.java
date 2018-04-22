package com.corffen.mvvmdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Date: 2018-04-22 17:59
 *
 * @author: Administrator
 */
public class User3 extends BaseObservable {
    private String name;
    private String btnContent;

    private int count;

    public User3(String name, String btnContent) {
        this.name = name;
        this.btnContent = btnContent;
        count = 0;
    }

    @Bindable
    public String getBtnContent() {
        return btnContent;
    }

    public void setBtnContent(String btnContent) {
        this.btnContent = btnContent;
        notifyChange();
    }

    public void clickMe() {
        count++;
        setBtnContent("点我啊" + count);
    }

    public User3(String name) {
        this.name = name;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyChange();
    }
}
