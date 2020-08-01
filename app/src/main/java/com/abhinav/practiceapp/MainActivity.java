package com.abhinav.practiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    private MyReceiver receiver;
    private IntentFilter intent,intentFilter;
    private CustomBroadcastReceiver myReceiver;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        // simple receiver for system events
        receiver = new MyReceiver();
        intent = new IntentFilter();
        intent.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        // custom receiver for custom events
        myReceiver = new CustomBroadcastReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.abhinav.practiceapp.my_action");


        // to send data to another activity after a background task is completed.

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    Intent intent1 = new Intent();
                    intent1.setAction("com.abhinav.practiceapp.send_data_action");
                    intent1.putExtra("Key","Abhinav");
                    sendBroadcast(intent1);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }
        });
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);


        // custom broadcast for custom action
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction("com.abhinav.practiceapp.my_action");
                i.putExtra("Key","Value");
                sendBroadcast(i);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
//        registerReceiver(receiver,intent);
        registerReceiver(myReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //unregisterReceiver(receiver);
        unregisterReceiver(myReceiver);
    }
}
