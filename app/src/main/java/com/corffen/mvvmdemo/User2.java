package com.corffen.mvvmdemo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Date: 2018-04-22 17:59
 *
 * @author: Administrator
 */
public class User2 extends BaseObservable {
    private String name;

    public User2(String name) {
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
