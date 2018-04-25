package com.corffen.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.corffen.mvvmdemo.bindingadapter.BindingAdapterViewModel;
import com.corffen.mvvmdemo.databinding.ActivityBindingAdapterBinding;

public class BindingAdapterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityBindingAdapterBinding activityBindingAdapterBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_binding_adapter);

        activityBindingAdapterBinding.setViewModel(new BindingAdapterViewModel(this));
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, BindingAdapterActivity.class);
        context.startActivity(starter);
    }

    @BindingAdapter("android:text")
    public static void setText(TextView view, CharSequence text) {
        final CharSequence oldText = view.getText();
        if (text == oldText || (text == null && oldText.length() == 0)) {
            return;
        }
        if (text instanceof Spanned) {
            if (text.equals(oldText)) {
                return; // No change in the spans, so don't set anything.
            }
        } else if (!haveContentsChanged(text, oldText)) {
            return; // No content changes, so don't set anything.
        }
        //下面这句代码，就是我们加进去的
        CharSequence upperText = ((String) text).toUpperCase();
        view.setText(upperText);
    }

    private static boolean haveContentsChanged(CharSequence str1, CharSequence str2) {
        if ((str1 == null) != (str2 == null)) {
            return true;
        } else if (str1 == null) {
            return false;
        }
        final int length = str1.length();
        if (length != str2.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context).load(url).
                into(imageView);
    }

}
