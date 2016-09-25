package com.itcast.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecyclerView;
    private List<DataBean> datas = new ArrayList<DataBean>();

    private int[] mListIcons = new int[]{R.mipmap.g1, R.mipmap.g2, R.mipmap.g3, R.mipmap.g4,
            R.mipmap.g5, R.mipmap.g6, R.mipmap.g7, R.mipmap.g8, R.mipmap.g9, R.mipmap.g10, R
            .mipmap.g11, R.mipmap.g12, R.mipmap.g13, R.mipmap.g14, R.mipmap.g15, R.mipmap
            .g16, R.mipmap.g17, R.mipmap.g18, R.mipmap.g19, R.mipmap.g20, R.mipmap.g21, R
            .mipmap.g22, R.mipmap.g23, R.mipmap.g24, R.mipmap.g25, R.mipmap.g26, R.mipmap
            .g27, R.mipmap.g28, R.mipmap.g29};
    private SwipeRefreshLayout mSwipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initEvent() {
        mSwipeRefreshLayout.setOnRefreshListener(this);
    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
    }

    private void initData() {
        for (int i = 0; i < mListIcons.length; i++) {
            DataBean dataBean = new DataBean();
            dataBean.text = "我是item" + i;
            dataBean.iconId = mListIcons[i];
            datas.add(dataBean);
        }
        ListAdapter adapter = new ListAdapter(this, datas);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list_v:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                break;
            case R.id.action_list_h:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
                break;
            case R.id.action_grid_v:
                mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                break;
            case R.id.action_grid_h:
                mRecyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2,GridLayoutManager.HORIZONTAL,false));
                break;
            case R.id.action_stragger_v:
                StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                        StaggeredGridLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
                break;
            case R.id.action_stragger_h:
                StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,
                        StaggeredGridLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(manager);
                break;

            default:
                break;
        }

        ListAdapter adapter = new ListAdapter(MainActivity.this, datas);
        mRecyclerView.setAdapter(adapter);

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onRefresh() {
        Toast.makeText(this, "我在玩命加载中啊....", Toast.LENGTH_SHORT).show();
        new Thread(){
            @Override
            public void run() {
                SystemClock.sleep(3000);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mSwipeRefreshLayout.setRefreshing(false);
                        mRecyclerView.getAdapter().notifyDataSetChanged();
                    }
                });
            }
        }.start();
    }
}
