package com.abhinav.practiceapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Abhinav Singh on 01,August,2020
 */
public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Action:" + intent.getAction(),Toast.LENGTH_SHORT).show();
    }
}
