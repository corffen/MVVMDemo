package com.corffen.mvvmdemo.livedata;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.corffen.mvvmdemo.R;
import com.corffen.mvvmdemo.databinding.ActivityLiveDataBinding;
import com.corffen.mvvmdemo.rv.RvAdatper;

import java.util.ArrayList;
import java.util.List;

public class LiveDataActivity extends AppCompatActivity {

    private LiveDataViewModel mLiveDataViewModel;

    RvAdatper mRvAdatper;

    ActivityLiveDataBinding activityLiveDataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityLiveDataBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_live_data);

        mLiveDataViewModel = ViewModelProviders.of(this).get(LiveDataViewModel.class);
        activityLiveDataBinding.setViewModel(mLiveDataViewModel);

        mLiveDataViewModel.setData();
        setAdapter();
        subscribeToLiveData();

    }

    private void setAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        mRvAdatper = new RvAdatper(new ArrayList<String>());
        activityLiveDataBinding.rvLive.setLayoutManager(manager);
        activityLiveDataBinding.rvLive.setAdapter(mRvAdatper);
        mRvAdatper.setOnclickListener(new RvAdatper.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mLiveDataViewModel.updataContent(position);
            }
        });
    }

    private void subscribeToLiveData() {
        mLiveDataViewModel.getCurrentName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                mLiveDataViewModel.setLiveDataForName(s);
            }
        });

        mLiveDataViewModel.getSoureceDatas().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {
                mLiveDataViewModel.addTitleToList(strings);
            }
        });
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, LiveDataActivity.class);
        context.startActivity(starter);
    }
}
