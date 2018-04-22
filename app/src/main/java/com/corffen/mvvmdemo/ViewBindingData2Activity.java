package com.corffen.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.corffen.mvvmdemo.databinding.ActivityViewBindData2Binding;

/**
 * Date: 2018-04-22 18:00
 *
 * @author: Administrator
 */
public class ViewBindingData2Activity extends AppCompatActivity {

    private User2 mUser2;
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityViewBindData2Binding activityViewBindData2Binding = DataBindingUtil.setContentView(this, R.layout
                .activity_view_bind_data2);
        mUser2 = new User2("绑定数据啊");
        activityViewBindData2Binding.setUser2(mUser2);
        activityViewBindData2Binding.btnChangeData2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                mUser2.setName("我改变了数据" + count);
            }
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ViewBindingData2Activity.class);
        context.startActivity(starter);
    }
}
