package com.example.paquita;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Broadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //evento de auriculares
        if (intent.getAction() != null) {
            if (intent.getAction().equals("andriod.intent.action.HEADSET_PLUG")) {

            }
        }
    }
}
