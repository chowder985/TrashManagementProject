package com.bignerdranch.android.trash;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by ilhoon on 10/26/16.
 */

public class DataLayerListenerService extends WearableListenerService {

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);
        if("1".equals(messageEvent.getPath())) {
            final String message = new String(messageEvent.getData());
            Log.d("Data sent3", message);
            Intent messageIntent = new Intent();
            messageIntent.setAction("message-forwarded-from-data-layer");
            messageIntent.putExtra("message", message);
            LocalBroadcastManager.getInstance(this).sendBroadcast(messageIntent);
        }else{
            super.onMessageReceived(messageEvent);
        }
    }
}
