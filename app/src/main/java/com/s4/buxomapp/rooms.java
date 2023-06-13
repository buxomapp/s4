package com.s4.buxomapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class rooms extends AppCompatActivity {
    ImageView backhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        backhome=(ImageView) findViewById(R.id.backhome);

        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backhome = new Intent(rooms.this,MainActivity.class);
                startActivity(backhome);
                finish();
            }
        });
    }
}