package com.s4.buxomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class catgorys extends AppCompatActivity {
    ImageView backhome,getway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catgorys);

        backhome=(ImageView) findViewById(R.id.backhome);
        getway = (ImageView)findViewById(R.id.getway);
        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backhome = new Intent(catgorys.this,MainActivity.class);
                startActivity(backhome);
                finish();
            }
        });
        getway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent getway = new Intent(catgorys.this,devoislist.class);
                startActivity(getway);
                finish();

            }
        });
    }
}