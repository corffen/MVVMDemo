package com.corffen.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.corffen.mvvmdemo.databinding.ActivityMultiClickBinding;

/**
 * Date: 2018-04-23 01:07
 *
 * @author: Administrator
 */
public class MultiClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMultiClickBinding activityMultiClickBinding = DataBindingUtil.setContentView(this,R.layout
                .activity_multi_click);

        activityMultiClickBinding.setMultiClickViewModel(new MultiClickViewModel());
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, MultiClickActivity.class);
        context.startActivity(starter);
    }
}
