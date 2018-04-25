package com.corffen.mvvmdemo;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Date: 2018-04-23 01:08
 *
 * @author: Administrator
 */
public class MultiClickViewModel {

    public MultiClickViewModel() {
    }


    public void simpleClick(View view) {
        if (view instanceof Button) {
            Button button = (Button) view;
            Toast.makeText(view.getContext(), button.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    //    public final BtnClickListener mListener;
//
//
//
//    public MultiClickViewModel(BtnClickListener listener) {
//        this.mListener = listener;
//    }
//
//    public void setBtnClick(Button btn, String content) {
//        btn.setText(content);
//    }
//
//    public interface BtnClickListener {
//        void onBtnClick(String content);
//    }
}
