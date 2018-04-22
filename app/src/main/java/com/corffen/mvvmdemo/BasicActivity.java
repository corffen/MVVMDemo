package com.corffen.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.corffen.mvvmdemo.databinding.ActivityBasicBinding;

/**
 * Date: 2018-04-22 09:56
 *
 * @author: Administrator
 */
public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityBasicBinding activityBasicBinding = DataBindingUtil.setContentView(this, R.layout.activity_basic);
        activityBasicBinding.tvTitle.setText("我不需要findviewbyid");
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, BasicActivity.class);
        context.startActivity(starter);
    }

}
