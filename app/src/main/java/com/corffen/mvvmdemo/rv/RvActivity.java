package com.corffen.mvvmdemo.rv;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.corffen.mvvmdemo.R;
import com.corffen.mvvmdemo.databinding.ActivityRvBinding;

import java.util.ArrayList;
import java.util.List;

public class RvActivity extends AppCompatActivity {


    ActivityRvBinding activityRvBinding;
    RvAdatper mRvAdatper;
    RvViewModel mRvViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityRvBinding = DataBindingUtil.setContentView(this, R.layout
                .activity_rv);
        mRvViewModel = new RvViewModel();
        activityRvBinding.setViewModel(mRvViewModel);
        mRvViewModel.setData();
        setAdapter();
    }

    private void setAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        mRvAdatper = new RvAdatper(new ArrayList<String>());
        activityRvBinding.rv.setLayoutManager(manager);
        activityRvBinding.rv.setAdapter(mRvAdatper);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, RvActivity.class);
        context.startActivity(starter);
    }


    @BindingAdapter("adapter")
    public static void setAdapterForRv(RecyclerView rv, List<String> datas) {
        RvAdatper adapter = (RvAdatper) rv.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(datas);
        }
    }
}
