package com.poh.base;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Splash_intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        }, 0);


        RelativeLayout psh = (RelativeLayout) findViewById(R.id.activity_spalsh);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        psh.startAnimation(myanim);
        final Intent i = new Intent(this, Menu_PoHBase_Home.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();

    }

    @Override                                                //masha - non-clickable back button
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            Toast.makeText(getApplicationContext(), "",
                    Toast.LENGTH_LONG).getView();
        return false;
    }
}

