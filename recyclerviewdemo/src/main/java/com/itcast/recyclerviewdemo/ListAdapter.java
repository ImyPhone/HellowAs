package com.itcast.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/20 19:01
 * @des ${TODO}
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyHolder> {
    private Context mContext;
    private List<DataBean> datas;

    public ListAdapter(Context context, List<DataBean> datas) {
        mContext = context;
        this.datas = datas;
    }



    @Override
    public ListAdapter.MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {//决定根布局
        View view = View.inflate(mContext, R.layout.item_list, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapter.MyHolder myHolder, int i) {//填充数据
        myHolder.setDataAndRefreshUI(datas.get(i));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        private TextView mTv;

        public MyHolder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.iv_icon);
            mTv = (TextView) itemView.findViewById(R.id.tv_name);
        }

        public void setDataAndRefreshUI(DataBean dataBean) {
            mTv.setText(dataBean.text);
            mImageView.setImageResource(dataBean.iconId);
        }
    }

}
