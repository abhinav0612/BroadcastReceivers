package com.abhinav.practiceapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Abhinav Singh on 01,August,2020
 */
public class CustomBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction() == "com.abhinav.practiceapp.my_action"){
            Toast.makeText(context,"My Action performed " + intent.getStringExtra("Key") + " Received",Toast.LENGTH_SHORT).show();
        }

    }
}
