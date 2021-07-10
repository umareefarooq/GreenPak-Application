package com.example.greenpak;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    ActionBar ab;
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ab = getSupportActionBar();
        ab.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#01411c")));

        getSupportActionBar().hide();

        h = new Handler();
        h.postDelayed(new Runnable(){
            @Override
            public void run(){

                MainActivity.this.startActivity(new Intent(MainActivity.this,signin.class));
                finish();

            }}, 3000);
    }

}