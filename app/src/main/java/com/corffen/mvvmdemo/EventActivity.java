package com.corffen.mvvmdemo;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.corffen.mvvmdemo.databinding.ActivityEventBinding;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityEventBinding activityEventBinding = DataBindingUtil.setContentView(this, R
                .layout.activity_event);
        activityEventBinding.setTitle("click3");
        activityEventBinding.setEnvntListener(new EventListener() {
            @Override
            public void click1(View view) {
                if (view instanceof Button) {
                    Toast.makeText(EventActivity.this, ((Button) view).getText(), Toast
                            .LENGTH_SHORT).show();
                    activityEventBinding.setTitle((String) ((Button) view).getText());
                }
            }

            @Override
            public void click2(View view) {
                if (view instanceof Button) {
                    Toast.makeText(EventActivity.this, ((Button) view).getText(), Toast
                            .LENGTH_SHORT).show();
                    activityEventBinding.setTitle((String) ((Button) view).getText());
                }
            }

            @Override
            public void click3(String s) {
                activityEventBinding.setTitle(s);
            }
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, EventActivity.class);
        context.startActivity(starter);
    }
}
