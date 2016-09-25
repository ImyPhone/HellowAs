package com.itcast.hellowas;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Button mBt;
    private android.support.v7.app.ActionBar mActionBar;
    private TextView mTv1;
    private View mViewById;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mBt = (Button) findViewById(R.id.bt);
        mTv1 = (TextView) findViewById(R.id.tv1);
    }

    private void initData(){
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);

    }

    private void initEvent(){
//        mBt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "我是Android Studio", Toast.LENGTH_SHORT).show();
//                mTv1.setText("呵呵呵呵....");
//            }
//        });
        mBt.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
               case android.R.id.home:
                   Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
                   break;
               case R.id.menu_hehe:
                   Toast.makeText(this, "hehe", Toast.LENGTH_SHORT).show();
                   break;
               case R.id.menu_gege:
                   Toast.makeText(this, "gege", Toast.LENGTH_SHORT).show();
                   break;
               case R.id.menu_xixi:
                   Toast.makeText(this, "xixi", Toast.LENGTH_SHORT).show();
                   break;
       }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "hehedada", Toast.LENGTH_SHORT).show();
        mTv1.setText("呵呵你妹啊....");
    }
}
