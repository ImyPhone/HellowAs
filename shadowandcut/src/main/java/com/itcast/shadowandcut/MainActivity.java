package com.itcast.shadowandcut;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBt = (Button) findViewById(R.id.mBt);
        mBt.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        //mBt作用的控件 0动画开始中心点X   0动画开始中心点Y 0动画开始半径  mBt.getWidth()动画结束半径
        Animator animator = ViewAnimationUtils.createCircularReveal(mBt,0,0,0,mBt.getWidth());
        animator.setDuration(3000);
        animator.start();
    }
}
