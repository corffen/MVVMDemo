package com.corffen.mvvmdemo.livedata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class LeftFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static LeftFragment newInstance() {
        Bundle args = new Bundle();
        LeftFragment fragment = new LeftFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
