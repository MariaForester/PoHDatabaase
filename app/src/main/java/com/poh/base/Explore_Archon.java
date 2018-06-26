package com.poh.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class Explore_Archon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explore_bosses_layout);

        ImageView imageView = (ImageView) findViewById(R.id.photox);
        imageView.setImageResource(R.drawable.archon_mainpage);

        //   final ImageView imageView = (ImageView) findViewById(R.id.photox);

        //  StorageReference mStorageRef = FirebaseStorage.getInstance().getReference().child("photo_2017-11-28_12-33-22.jpg");

        //  Glide.with(this)
        //         .using(new FirebaseImageLoader())
        //        .load(mStorageRef)
        //       .into(imageView);
    }

    public void backBtnClick(View v) {
        this.finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        }, 0);
    }
}
