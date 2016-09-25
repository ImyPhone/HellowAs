package com.itcast.xmpp.utils;

import android.os.Handler;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/21 9:44
 * @des ${TODO}
 */
public class ThreadUtils {
    //主线程创建handler
    public static Handler mHandler = new Handler();

    //子线程执行task
    public static void runInThread(Runnable task){
        new Thread(task).start();
    }

    //UI线程执行task
    public static void runInUIThread(Runnable task){
        mHandler.post(task);  //本质  主线程的handler发送消息（任务）到消息队列，轮询器取出
                                // ，再执行(Runnable直接调用run方法)
                                //activity.runOnUIThread()类似
    }


}
