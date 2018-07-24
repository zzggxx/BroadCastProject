package com.example.localbroadcastmanager.ui;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.localbroadcastmanager.R;
import com.example.localbroadcastmanager.broadcast.MyBroadCastReceiver;

public class MainActivity extends AppCompatActivity {

    public static final String BROADCAST_ACTION_ONE = "com.maguji";
    private LocalBroadcastManager mLocalBroadcastManager;
    private MyBroadCastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        应用内广播管理者
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);

//        先注册广播接收者
        mBroadcastReceiver = new MyBroadCastReceiver();
        IntentFilter intentFilter = new IntentFilter(BROADCAST_ACTION_ONE);
        mLocalBroadcastManager.registerReceiver(mBroadcastReceiver, intentFilter);

//        自己发送广播
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(BROADCAST_ACTION_ONE);
                intent.putExtra("msg", "我们要发新版本了3.0.5");
                mLocalBroadcastManager.sendBroadcast(intent);

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocalBroadcastManager.unregisterReceiver(mBroadcastReceiver);
    }
}
