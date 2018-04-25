package com.corffen.mvvmdemo.bindingadapter;

import android.content.Context;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;

import com.corffen.mvvmdemo.R;

public class BindingAdapterViewModel {

    public static final String url = "https://p.qpic" +
            ".cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640";
    public static final String url1 = "https://www.baidu.com/img/bd_logo1.png";

    public final ObservableField<String> imageUrl = new ObservableField<>();

    public final ObservableField<Drawable> drawable = new ObservableField<>();

    public final ObservableField<String> textContent = new ObservableField<>();

    private Context mContext;

    public BindingAdapterViewModel(Context context) {
        this.mContext = context.getApplicationContext();
        imageUrl.set(url);
        drawable.set(mContext.getResources().getDrawable(R.drawable.back_icon));
        textContent.set("corffen");
    }

    public void change() {
        imageUrl.set(url1);
        textContent.set("changed");
        drawable.set(mContext.getResources().getDrawable(R.drawable.armory));
    }
}
