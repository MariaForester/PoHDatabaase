package com.poh.base;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Menu_PoHBase_Home extends Left_menu {

    private ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] slideImages = {R.drawable.sofiawelcometwo};
    private static final Integer[] slideImages2 = {R.drawable.icons, R.drawable.icons_test2};
    private ArrayList<Integer> slideArray = new ArrayList<>();
    private ArrayList<Integer> slideArray2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_pohbase_home);
        init();
    }

    public void BtnClick(View v) {
        Intent intent = new Intent(Menu_PoHBase_Home.this, MapExplorePage_MainScreen.class);
        startActivity(intent);
    }

    private void init() {
        Collections.addAll(slideArray, slideImages);

        Collections.addAll(slideArray2, slideImages2);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new Slide_adapter(Menu_PoHBase_Home.this, slideArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        mPager = (ViewPager) findViewById(R.id.bestpicks);
        mPager.setAdapter(new Slide_adapter(Menu_PoHBase_Home.this, slideArray2));
        indicator = (CircleIndicator) findViewById(R.id.bestpicks2);
        indicator.setViewPager(mPager);


        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == slideImages.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };

        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 0, 5000);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Are you sure you want to exit?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
