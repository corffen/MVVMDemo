package com.corffen.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.corffen.mvvmdemo.databinding.ActivityClickBinding;

/**
 * Date: 2018-04-22 18:28
 *
 * @author: Administrator
 */
public class ClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityClickBinding activityClickBinding = DataBindingUtil.setContentView(this, R.layout.activity_click);
        activityClickBinding.setUser3(new User3("我是点击事件", "点我啊"));
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ClickActivity.class);
        context.startActivity(starter);
    }
}
