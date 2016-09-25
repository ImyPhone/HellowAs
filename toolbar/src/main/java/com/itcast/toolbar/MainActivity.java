package com.itcast.toolbar;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;


public class MainActivity extends ActionBarActivity {

    private Toolbar mToolBar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar();
        initDrawerLayout();
        initToggle();
        setDrawerLayoutListener();
    }

    private void setDrawerLayoutListener() {
        mToggle.syncState();
        mDrawerLayout.setDrawerListener(mToggle);
    }

    private void initToggle() {
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,mToolBar, R.string.open,R.string.close);
    }

    private void initDrawerLayout() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);

    }

    private void initToolBar() {
        mToolBar = (Toolbar) findViewById(R.id.main_toolbar);
        mToolBar.setTitle("我是ToolBar");
        this.setSupportActionBar(mToolBar);
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
}
