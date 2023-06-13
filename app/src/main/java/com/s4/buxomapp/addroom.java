package com.s4.buxomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tuya.smart.home.sdk.TuyaHomeSdk;
import com.tuya.smart.home.sdk.bean.HomeBean;
import com.tuya.smart.home.sdk.callback.ITuyaGetHomeListCallback;
import com.tuya.smart.home.sdk.callback.ITuyaHomeResultCallback;
import com.tuya.smart.sdk.api.ITuyaDataCallback;
import com.tuya.smart.sdk.bean.DeviceBean;

import java.util.ArrayList;
import java.util.List;

public class addroom extends AppCompatActivity {
    ImageView backhome;
    EditText homename;
    Button addhome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addroom);

        backhome = (ImageView) findViewById(R.id.backhome);
        homename = (EditText) findViewById(R.id.homename);
        addhome = (Button) findViewById(R.id.addhomebuuton);

        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backhome = new Intent(addroom.this, MainActivity.class);
                startActivity(backhome);
                finish();
            }
        });

        addhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //// String [] room = {"s","v"};
                ///  ArrayList<String[]> rooms ;
              //  String texthome = homename.getText().toString();
              //  Add_home(texthome);
               // gethome();


            }
        });
    }

    public void Add_home(String HomeName) {
        TuyaHomeSdk.getHomeManagerInstance().createHome(HomeName, 0, 0, "geoName", new ArrayList<>(), new ITuyaHomeResultCallback() {
            @Override
            public void onSuccess(HomeBean bean) {
                try {
                    Toast.makeText(addroom.this, "okok", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(addroom.this, "okno", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String errorCode, String errorMsg) {
                // do something
                Toast.makeText(addroom.this, "no", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void gethome(){
        TuyaHomeSdk.getHomeManagerInstance().queryHomeList(new ITuyaGetHomeListCallback() {

            @Override
            public void onSuccess(List<HomeBean> homeBeans) {
                // do something
                Toast.makeText(addroom.this, ""+homeBeans, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onError(String errorCode, String error) {
                // do something
            }
        });

    }


}
