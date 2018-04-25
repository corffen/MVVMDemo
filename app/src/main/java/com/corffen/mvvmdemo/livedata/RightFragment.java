package com.corffen.mvvmdemo.livedata;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class RightFragment extends Fragment{

    public static RightFragment newInstance() {
        Bundle args = new Bundle();
        RightFragment fragment = new RightFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
