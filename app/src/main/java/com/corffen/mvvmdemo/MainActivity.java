package com.corffen.mvvmdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.corffen.mvvmdemo.rv.RvActivity;

/**
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnBase, mBtnViewBindingData, mBtnViewBindingData2;
    private Button mClick, mClickWithViewModel, mMultiProperty, mEventListener;
    private Button mBindingAdapter, mRvBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mBtnBase = findViewById(R.id.btn_base);
        mBtnBase.setOnClickListener(this);

        mBtnViewBindingData = findViewById(R.id.btn_view_bind_data);
        mBtnViewBindingData.setOnClickListener(this);

        mBtnViewBindingData2 = findViewById(R.id.btn_view_bind_data2);
        mBtnViewBindingData2.setOnClickListener(this);

        mClick = findViewById(R.id.btn_click);
        mClick.setOnClickListener(this);

        mClickWithViewModel = findViewById(R.id.btn_click_with_view_model);
        mClickWithViewModel.setOnClickListener(this);

        mMultiProperty = findViewById(R.id.btn_multi_property);
        mMultiProperty.setOnClickListener(this);

        mEventListener = findViewById(R.id.btn_event);
        mEventListener.setOnClickListener(this);

        mBindingAdapter = findViewById(R.id.btn_binding_adapter);
        mBindingAdapter.setOnClickListener(this);

        mRvBinding = findViewById(R.id.btn_rv_bind);
        mRvBinding.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_base:
                BasicActivity.start(this);
                break;
            case R.id.btn_view_bind_data:
                ViewBindingDataActivity.start(this);
                break;
            case R.id.btn_view_bind_data2:
                ViewBindingData2Activity.start(this);
                break;
            case R.id.btn_click:
                ClickActivity.start(this);
                break;
            case R.id.btn_click_with_view_model:
                ClickWithViewModelActivity.start(this);
                break;
            case R.id.btn_multi_property:
                MultiPropertyActivity.start(this);
                break;
            case R.id.btn_event:
                EventActivity.start(this);
                break;

            case R.id.btn_binding_adapter:
                BindingAdapterActivity.start(this);
                break;
            case R.id.btn_rv_bind:
                RvActivity.start(this);
                break;
            default:
                break;
        }
    }
}
