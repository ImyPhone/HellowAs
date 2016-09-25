package com.itcast.xmpp.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/21 15:52
 * @des ${TODO}
 */
public class ToastUtils {
    public static void showToastSafe(final Context context, final String info){
        ThreadUtils.runInUIThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, info, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
