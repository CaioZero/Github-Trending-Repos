package com.caiozero.githubtrendingrepos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.caiozero.githubtrendingrepos.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                abrirMain();
            }
        },3000);
    }

    private void abrirMain(){
        Intent intent = new Intent(getApplicationContext(), OptionActivity.class);
        startActivity(intent);
        finish();
        }
    }

