package com.itcast.xmpp.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itcast.xmpp.R;
import com.itcast.xmpp.fragment.ContactFragment;
import com.itcast.xmpp.fragment.SessionFragment;
import com.itcast.xmpp.utils.ToolBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/21 15:57
 * @des ${TODO}
 */
public class MainActivity extends ActionBarActivity {
    @InjectView(R.id.main_tv_title)
    TextView mTvTitle;

    @InjectView(R.id.main_viewpager)
    ViewPager mViewPager;

    @InjectView(R.id.main_bottom)
    LinearLayout mMainBottom;

    private List<Fragment> mFragments	= new ArrayList<Fragment>();
    private ToolBarUtil mToolBarUtil;
    private String[]		mToolBarTitleArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initData();
        initEvent();
    }


    private void initData() {
        mFragments.add(new SessionFragment());
        mFragments.add(new ContactFragment());
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

        // 底部按钮
        mToolBarUtil = new ToolBarUtil();
        mToolBarTitleArr = new String[] { "会话", "联系人" };
        int[] iconArr = { R.drawable.selector_meassage, R.drawable.selector_selfinfo };
        mToolBarUtil.createToolBar(mMainBottom, mToolBarTitleArr, iconArr);
        mToolBarUtil.changeColor(0);
    }

    private void initEvent() {
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mToolBarUtil.changeColor(position);
                mTvTitle.setText(mToolBarTitleArr[position]);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mToolBarUtil.setOnOnToolBarClickListener(new ToolBarUtil.OnToolBarClickListener() {
            @Override
            public void onToolBarClick(int postion) {
                mViewPager.setCurrentItem(postion);
            }
        });
    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }
}
