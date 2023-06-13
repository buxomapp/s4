package com.s4.buxomapp;

import static com.tuya.smart.android.base.TuyaSmartSdk.appkey;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.s4.buxomapp.MainActivity;
import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.sdk.api.INeedLoginListener;

public class TuyaSmartApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        TuyaHomeSdk.setDebugMode(true);
        TuyaHomeSdk.init(this);

       TuyaHomeSdk.setOnNeedLoginListener(new INeedLoginListener() {
            @Override
           public void onNeedLogin(Context context) {
                startActivity(new Intent(TuyaSmartApp.this, MainActivity.class));
                startActivity(new Intent(TuyaSmartApp.this, addroom.class));
                startActivity(new Intent(TuyaSmartApp.this, devoislist.class));
            }
        });



    }
}
