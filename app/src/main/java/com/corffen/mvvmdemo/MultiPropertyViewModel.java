package com.corffen.mvvmdemo;

import android.databinding.ObservableField;

/**
 * Date: 2018-04-22 21:13
 *
 * @author: Administrator
 */
public class MultiPropertyViewModel {

    private int count1 = 0, count2 = 0, count3 = 0, count4 = 0;
    private ObservableField<String> mContent1 = new ObservableField<>("第一个按钮");
    private ObservableField<String> mContent2 = new ObservableField<>("第二个按钮");
    private ObservableField<String> mContent3 = new ObservableField<>("第三个按钮");
    private ObservableField<String> mContent4 = new ObservableField<>("第四个按钮");

    public MultiPropertyViewModel() {
    }

    public ObservableField<String> getContent1() {
        return mContent1;
    }

    public ObservableField<String> getContent2() {
        return mContent2;
    }

    public ObservableField<String> getContent3() {
        return mContent3;
    }

    public ObservableField<String> getContent4() {
        return mContent4;
    }

    public void click1() {
        count1++;
        mContent1.set("第一个按钮点击了" + count1);
    }

    public void click2() {
        count2++;
        mContent2.set("第二个按钮点击了" + count2);
    }

    public void click3() {
        count3++;
        mContent3.set("第三个按钮点击了" + count3);
    }

    public void click4() {
        count4++;
        mContent4.set("第四个按钮点击了" + count4);
    }
}
