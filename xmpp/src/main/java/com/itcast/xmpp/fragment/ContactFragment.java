package com.itcast.xmpp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.itcast.xmpp.R;
import com.itcast.xmpp.service.IMService;
import com.itcast.xmpp.utils.ThreadUtils;

import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;

import java.util.Collection;

;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {
    private ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        initData();
        initEvent();
        super.onActivityCreated(savedInstanceState);
    }

    private void init() {

    }

    private void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.listView);
    }

    private void initData() {

    }

    private void initEvent() {
        //得到所有联系人
        Roster roster = IMService.conn.getRoster();
        Collection<RosterEntry> entries = roster.getEntries();
        for(RosterEntry entry : entries){

        }

        //开启线程，同步花名册
        ThreadUtils.runInThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
