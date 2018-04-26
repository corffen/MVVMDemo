package com.corffen.mvvmdemo.rv;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.corffen.mvvmdemo.BaseViewHolder;
import com.corffen.mvvmdemo.R;

import java.util.List;

public class RvAdatper extends RecyclerView.Adapter<BaseViewHolder> implements View
        .OnClickListener {

    private List<String> mDatas;

    private OnItemClickListener mListener;

    @Override
    public void onClick(View v) {

        if (mListener != null) {
            mListener.onItemClick((Integer) v.getTag());
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnclickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public RvAdatper(List<String> datas) {
        mDatas = datas;
    }

    public void addItems(List<String> datas) {
        this.mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mDatas.clear();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_string_rv,
                parent, false);
        itemView.setOnClickListener(this);
        return new RvViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(position);
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        if (mDatas != null && mDatas.size() > 0) {
            return mDatas.size();
        }
        return 0;
    }

    public class RvViewHolder extends BaseViewHolder {

        private TextView mTextView;

        public RvViewHolder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_rv_content);
        }

        @Override
        public void bind(int position) {
            String s = mDatas.get(position);
            mTextView.setText(s);
        }
    }
}
