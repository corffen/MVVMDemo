package com.corffen.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.corffen.mvvmdemo.databinding.ActivityMultiPropertyBinding;

/**
 * Date: 2018-04-22 21:09
 *
 * @author: Administrator
 */
public class MultiPropertyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMultiPropertyBinding activityMultiPropertyBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_multi_property);

        activityMultiPropertyBinding.setMultiPropertyViewModel(new MultiPropertyViewModel());
        activityMultiPropertyBinding.executePendingBindings();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, MultiPropertyActivity.class);
        context.startActivity(starter);
    }
}
