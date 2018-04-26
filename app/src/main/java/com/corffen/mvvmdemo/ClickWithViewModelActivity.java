package com.corffen.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.corffen.mvvmdemo.databinding.ActivityClickWithViewModelBinding;

/**
 * Date: 2018-04-22 19:34
 *
 * @author: Administrator
 */
public class ClickWithViewModelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityClickWithViewModelBinding activityClickWithViewModelBinding = DataBindingUtil
                .setContentView(this, R
                .layout.activity_click_with_view_model);
        activityClickWithViewModelBinding.setClickViewModel(new ClickViewModel(new User4("点我啊!"),
                this));
        activityClickWithViewModelBinding.executePendingBindings();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ClickWithViewModelActivity.class);
        context.startActivity(starter);
    }
}
