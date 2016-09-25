package com.itcast.toolbar;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/24 15:52
 * @des ${TODO}
 */
public class TestActitvity extends Activity {
    @InjectView(R.id.tv)
    TextView mTv;
    @InjectView(R.id.bt)
    Button mBt;
    @InjectView(R.id.iv)
    ImageView mIv;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.test_activity);
        ButterKnife.inject(this);
    }
}
