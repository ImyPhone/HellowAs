package com.itcast.hellowas;

import java.util.List;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/19 13:08
 * @des ${TODO}
 */
public class HomeBean {


    public List<String> picture;
    /**
     * id : 1525489
     * name : 黑马程序员
     * packageName : com.itheima.www
     * iconUrl : app/com.itheima.www/icon.jpg
     * stars : 5
     * size : 91767
     * downloadUrl : app/com.itheima.www/com.itheima.www
     * des : 产品介绍：google市场app测试。
     */

    public List<ListBean> list;

    public static class ListBean {
        public int id;
        public String name;
        public String packageName;
        public String iconUrl;
        public int stars;
        public int size;
        public String downloadUrl;
        public String des;
    }
}
