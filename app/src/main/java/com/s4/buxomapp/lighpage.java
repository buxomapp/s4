package com.s4.buxomapp;

import static com.tuya.sdk.security.SecuredStore.mContext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.sdk.api.IResultCallback;

public class lighpage extends AppCompatActivity {
    ImageView backhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lighpage);

        backhome=(ImageView) findViewById(R.id.backhome);
        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent backhome = new Intent(lighpage.this,MainActivity.class);
                startActivity(backhome);
                finish();
            }
        });
    }



}