package com.poh.base;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.ValueEventListener;

public class Hero_Sofia extends AppCompatActivity {
    Firebase myFirebase;
    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_layout);

        ImageView heroLayout = (ImageView) findViewById(R.id.heroLayout);
        heroLayout.setImageResource(R.drawable.duncan_layout);
        ImageView skinHero = (ImageView) findViewById(R.id.skinHero);
        skinHero.setImageResource(R.drawable.duncan_skin);
        TextView heroName = (TextView) findViewById(R.id.heroName);
        heroName.setText("Sofia");

        final TextView heroText = (TextView) findViewById(R.id.heroText);

        Firebase.setAndroidContext(getApplicationContext());

        myFirebase = new Firebase("https://planet-of-heroes-base.firebaseio.com/Text");

        spinner = (ProgressBar) findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);

        myFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                spinner.setVisibility(View.GONE);
                String myChildText = dataSnapshot.getValue(String.class);
                heroText.setText(myChildText);
            }

            @Override
            public void onCancelled(com.firebase.client.FirebaseError firebaseError) {
                spinner.setVisibility(View.GONE);
                heroText.setText("Error found");
            }
        });

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
