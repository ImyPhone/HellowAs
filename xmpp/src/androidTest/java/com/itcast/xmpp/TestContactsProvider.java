package com.itcast.xmpp;

import android.content.ContentValues;
import android.database.Cursor;
import android.test.AndroidTestCase;

import com.itcast.xmpp.dbhelper.ContactOpenHelper;
import com.itcast.xmpp.provider.ContactsProvider;

/**
 * @author Jimmy White
 * @version @Rev$
 * @time 2016/9/22 10:46
 * @des ${TODO}
 */
public class TestContactsProvider extends AndroidTestCase {

    public void testInsert(){
        ContentValues values = new ContentValues();
        values.put(ContactOpenHelper.ContactTable.ACCOUNT, "billy@itheima.com");
        values.put(ContactOpenHelper.ContactTable.NICKNAME, "老伍");
        values.put(ContactOpenHelper.ContactTable.AVATAR, "0");
        values.put(ContactOpenHelper.ContactTable.PINYIN, "laowu");
        getContext().getContentResolver().insert(ContactsProvider.URI_CONTACT, values);
    }

    public void testDelete(){
        getContext().getContentResolver().delete(ContactsProvider.URI_CONTACT,
                ContactOpenHelper.ContactTable.ACCOUNT + "=?", new String[] { "billy@itheima.com" });
    }

    public void testUpdate(){
        ContentValues values = new ContentValues();
        values.put(ContactOpenHelper.ContactTable.ACCOUNT, "billy@itheima.com");
        values.put(ContactOpenHelper.ContactTable.NICKNAME, "我是老伍");
        values.put(ContactOpenHelper.ContactTable.AVATAR, "0");
        values.put(ContactOpenHelper.ContactTable.PINYIN, "woshilaowu");
        getContext().getContentResolver().update(ContactsProvider.URI_CONTACT, values,
                ContactOpenHelper.ContactTable.ACCOUNT + "=?", new String[] { "billy@itheima.com" });
    }
    public void testQuery(){
        Cursor c = getContext().getContentResolver().query(ContactsProvider.URI_CONTACT, null, null, null, null);
        int columnCount = c.getColumnCount();// 一共多少列
        while (c.moveToNext()) {
            // 循环打印列
            for (int i = 0; i < columnCount; i++) {
                System.out.print(c.getString(i) + "    ");
            }
            System.out.println("");
        }
    }
}
