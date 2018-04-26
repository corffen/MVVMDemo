package com.corffen.mvvmdemo.propertychanged;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.corffen.mvvmdemo.R;
import com.corffen.mvvmdemo.databinding.ActivityPropertyChangedBinding;

public class PropertyChangedActivity extends AppCompatActivity {

    private PropertyChangedViewModel mViewModel;
    private Observable.OnPropertyChangedCallback mCallback;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPropertyChangedBinding activityPropertyChangedBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_property_changed);
        mViewModel = new PropertyChangedViewModel();
        activityPropertyChangedBinding.setViewModel(mViewModel);

        setPropertyCallBack();
    }

    private void setPropertyCallBack() {
        mCallback = new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                Toast.makeText(PropertyChangedActivity.this, mViewModel.getText(), Toast
                        .LENGTH_SHORT).show();
            }
        };
        mViewModel.content.addOnPropertyChangedCallback(mCallback);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, PropertyChangedActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onDestroy() {
        if (mCallback != null) {
            mViewModel.content.removeOnPropertyChangedCallback(mCallback);
        }
        super.onDestroy();
    }
}
