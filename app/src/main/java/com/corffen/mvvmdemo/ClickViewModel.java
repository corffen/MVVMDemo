package com.corffen.mvvmdemo;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;

/**
 * Date: 2018-04-22 19:36
 *
 * @author: Administrator
 */
public class ClickViewModel extends BaseObservable {

    private User4 mUser4;
    private int count;

    public final ObservableField<Drawable> drawable = new ObservableField<>();

    private Drawable ivDrawable;

    @Bindable
    public Drawable getIvDrawable() {
        return ivDrawable;
    }

    public void setIvDrawable(Drawable ivDrawable) {
        this.ivDrawable = ivDrawable;
        notifyChange();
    }

    private Context mContext;

    public ClickViewModel(User4 user4, Context context) {
        mUser4 = user4;
        count = 0;
        this.mContext = context.getApplicationContext();
        drawable.set(mContext.getResources().getDrawable(R.drawable.armory));
        setIvDrawable(mContext.getResources().getDrawable(R.drawable.back_icon));
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
        setIvDrawable(mContext.getResources().getDrawable(R.drawable.armory));
        drawable.set(mContext.getResources().getDrawable(R.drawable.back_icon));
    }
}
