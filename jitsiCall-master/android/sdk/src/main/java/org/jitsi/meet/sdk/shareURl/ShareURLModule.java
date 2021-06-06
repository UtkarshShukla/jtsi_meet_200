package org.jitsi.meet.sdk.shareURl;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ShareURLModule extends ReactContextBaseJavaModule {
    public ShareURLModule(@NonNull ReactApplicationContext reactContext) {
        super(reactContext);
    }


    @ReactMethod
    public void sendRoomUrl(String roomUrl) {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getReactApplicationContext());
        Intent intent=new Intent();
        intent.setAction("org.jitsi.meet.BEGIN_SHARE_ROOM");
        intent.putExtra("roomUrl",roomUrl);
        localBroadcastManager.sendBroadcast(intent);
    }

    @NonNull
    @Override
    public String getName() {
        return "ShareURLModule";
    }
}
