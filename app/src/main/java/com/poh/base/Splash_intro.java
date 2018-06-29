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

        if (!isConnected(Splash_intro.this)) {
            buildDialog(Splash_intro.this).show();
        }

        else {
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
    }

    public boolean isConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            android.net.NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            return (mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting());
        } else
            return false;
    }

    public AlertDialog.Builder buildDialog(Context c) {
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setCancelable(false);
        builder.setTitle("No Internet Connection");
        builder.setMessage("Connect Your Device To Continue");
        builder.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(Splash_intro.this, Splash_intro.class);
                finish();
                startActivity(i);
            }
        });
        return builder;
    }

    @Override                                                //masha - non-clickable back button
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK)
            Toast.makeText(getApplicationContext(), "",
                    Toast.LENGTH_LONG).getView();
        return false;
    }
}

