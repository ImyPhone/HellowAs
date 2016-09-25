package com.itcast.hellowas;

import android.test.AndroidTestCase;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/19 14:55
 * @des ${TODO}
 */
public class MyTest extends AndroidTestCase {
    public void testAdd(){
        int a = 0;
        int b = 1;
        int c = a + b;
        assertEquals(1,c);
    }
}
