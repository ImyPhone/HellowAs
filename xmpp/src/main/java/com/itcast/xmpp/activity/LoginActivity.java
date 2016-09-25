package com.itcast.xmpp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itcast.xmpp.R;
import com.itcast.xmpp.service.IMService;
import com.itcast.xmpp.utils.ThreadUtils;
import com.itcast.xmpp.utils.ToastUtils;

import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/21 9:24
 * @des ${TODO}
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private Button mBt_login;
    private EditText mEt_password;
    private EditText mEt_username;

    public static final String HOST = "192.168.1.100";    // 主机ip
    public static final int PORT = 5222;            // 对应的端口号
    public static final String SERVICENAME = "itheima.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initEvent();
    }

    private void initEvent() {
        mBt_login.setOnClickListener(this);
    }

    private void initView() {
        mEt_username = (EditText) findViewById(R.id.et_username);
        mEt_password = (EditText) findViewById(R.id.et_password);
        mBt_login = (Button) findViewById(R.id.btn_login);
    }

    @Override
    public void onClick(View v) {
        final String userName = mEt_username.getText().toString().trim();
        final String passWord = mEt_password.getText().toString().trim();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(passWord)) {
            Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        ThreadUtils.runInThread(new Runnable() {
            @Override
            public void run() {

                try {
                    // 1.创建连接配置对象
                    ConnectionConfiguration config = new ConnectionConfiguration(HOST, PORT);

                    // 额外的配置(方面我们开发,上线的时候,可以改回来)
                    config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);// 明文传输
                    config.setDebuggerEnabled(true);// 开启调试模式,方便我们查看具体发送的内容

                    // 2.开始创建连接对象
                    XMPPConnection conn = new XMPPConnection(config);

                    // 开始连接
                    conn.connect();

                    // 连接成功了
                    // 3.开始登录
                    conn.login(userName, passWord);
                    // 已经成功成功
                    ToastUtils.showToastSafe(LoginActivity.this, "登录成功");

                    finish();
                    // 跳到主界面
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);

                    // 需要保存连接对象
                    IMService.conn = conn;

                    //启动IMService
                    //Intent service = new Intent(LoginActivity.this, IMService.class);
                    //startService(service);
                } catch (XMPPException e) {
                    e.printStackTrace();
                    ToastUtils.showToastSafe(LoginActivity.this, "登录失败");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
