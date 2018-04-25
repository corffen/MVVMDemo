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
import com.corffen.mvvmdemo.databinding.ActivityBindingAdapterBinding;

public class BindingAdapterActivity extends AppCompatActivity {

    public static final String url = "https://p.qpic" +
            ".cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640";
    public static final String url1 = "http://cdn.meme.am/instances/60677654.jpg";

    final ObservableField<Drawable> drawable = new ObservableField<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityBindingAdapterBinding activityBindingAdapterBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_binding_adapter);
        activityBindingAdapterBinding.setTitle("corffen");
        activityBindingAdapterBinding.setImageUrl(url1);
        activityBindingAdapterBinding.setView(this);
        drawable.set(getResources().getDrawable(R.drawable.armory));
        activityBindingAdapterBinding.btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activityBindingAdapterBinding.setTitle("changed");
                activityBindingAdapterBinding.setImageUrl(url);
                drawable.set(getResources().getDrawable(R.drawable.back_icon));
            }
        });

//        Glide.with(this).load(url).into(activityBindingAdapterBinding.ivNet);
    }

    public ObservableField<Drawable> getDrawable() {
        return drawable;
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
