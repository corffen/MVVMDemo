package com.corffen.mvvmdemo.propertychanged;

import android.databinding.ObservableField;

public class PropertyChangedViewModel  {

    public final ObservableField<String> content = new ObservableField<>("我是默认值");
    private int count = 0;

    public PropertyChangedViewModel() {
    }

    public ObservableField<String> getContent() {
        return content;
    }

    public void change() {
        count++;
        content.set("改变了" + count);
    }

    public String getText() {
        return content.get();
    }
}
