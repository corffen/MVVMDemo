package com.corffen.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.corffen.mvvmdemo.databinding.ActivityViewBindDataBinding;

/**
 * Date: 2018-04-22 11:28
 *
 * @author: Administrator
 */
public class ViewBindingDataActivity extends AppCompatActivity {

    private User mUser;
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityViewBindDataBinding activityViewBindDataBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_view_bind_data);
        mUser = new User("绑定数据啊");
        activityViewBindDataBinding.setUser(mUser);
        activityViewBindDataBinding.btnChangeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                mUser.setName("我改变了数据" + count);
                activityViewBindDataBinding.setUser(mUser);
            }
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ViewBindingDataActivity.class);
        context.startActivity(starter);
    }
}
