package com.itcast.xmpp.utils;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itcast.xmpp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/21 17:00
 * @des ${TODO}
 */
public class ToolBarUtil {


    private List<TextView> mTextViews = new ArrayList<TextView>();

    public void createToolBar(LinearLayout container, String[] toolBarTitleArr, int[] iconArr) {

        for (int i = 0; i < toolBarTitleArr.length; i++) {

            TextView tv = (TextView) View.inflate(container.getContext(), R.layout.inflate_toolbar_btn, null);
            tv.setText(toolBarTitleArr[i]);

            // 动态修改textView里面的drawableTop属性   里面的参数为资源ID
            tv.setCompoundDrawablesWithIntrinsicBounds(0, iconArr[i], 0, 0);

            int width = 0;
            int height = LinearLayout.LayoutParams.MATCH_PARENT;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
            params.weight = 1;  //设置weight属性
            container.addView(tv, params);

            //保存textView到集合中
            mTextViews.add(tv);
            final int finalI = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   //不同模块之间传值 接口与回调
                    changeColor(finalI);
                    mListener.onToolBarClick(finalI);
                }
            });
        }
    }

    public void changeColor(int position) {
        //还原所有的颜色
        for (TextView tv : mTextViews) {
            tv.setSelected(false);
        }
        mTextViews.get(position).setSelected(true);//通过设置selected属性,控制为选中效果
    }

    private OnToolBarClickListener mListener;

    public interface OnToolBarClickListener{
        void onToolBarClick(int postion);
    }

    public void setOnOnToolBarClickListener(OnToolBarClickListener listener){
        this.mListener = listener;
    }



}
