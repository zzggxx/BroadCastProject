package com.example.will.broadcastproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.will.broadcastproject.R;

public class MainActivity extends AppCompatActivity {

    public static final String BROADCAST_ACTION_ONE = "com.maguji";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(BROADCAST_ACTION_ONE);
                intent.putExtra("msg", "我们要发新版本了3.0.5");
                sendBroadcast(intent);

            }
        });

    }
}
