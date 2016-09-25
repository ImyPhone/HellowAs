package com.itcast.android50;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;


public class MainActivity extends Activity implements View.OnClickListener, View.OnKeyListener, View.OnLongClickListener {

    private final File mCacheDir = getCacheDir();
    private Button mBt1;
    private Button mBt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int result = intent.getIntExtra("themeId",0);
        if (result != 0){
            setTheme(result);
        }
        setContentView(R.layout.activity_main);
        mBt = (Button) findViewById(R.id.bt);
        mBt1 = (Button) findViewById(R.id.bt1);
        mBt.setOnClickListener(this);
        mBt1.setOnClickListener(this);
        mBt.setOnKeyListener(this);
        mBt.setOnLongClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.menu_main, menu);
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
           if (v.getId() == R.id.bt){
               overridePendingTransition(0, 0);
               finish();
               Intent intent = new Intent(MainActivity.this, MainActivity.class);
               intent.putExtra("themeId", R.style.RedThme);
               startActivity(intent);
               overridePendingTransition(0, 0);
           }else {
               overridePendingTransition(0, 0);
               finish();
               Intent intent = new Intent(MainActivity.this, MainActivity.class);
               intent.putExtra("themeId", R.style.OtherThme);
               startActivity(intent);
               overridePendingTransition(0, 0);
           }

    }


    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
