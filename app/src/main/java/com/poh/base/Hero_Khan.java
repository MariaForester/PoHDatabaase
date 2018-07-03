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
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class Hero_Khan extends AppCompatActivity {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_layout);

        TextView heroName = (TextView) findViewById(R.id.heroName);
        heroName.setText("Khan'ley");
        ImageView heroLayout = (ImageView) findViewById(R.id.heroLayout);
        heroLayout.setImageResource(R.drawable.khanley_layout);
        TextView heroClass = (TextView) findViewById(R.id.heroClass);
        heroClass.setText("WARRIOR");
        heroClass.setTextColor(getResources().getColor(R.color.yellowClass));

        final TextView heroText = (TextView) findViewById(R.id.heroText);
        final TextView pricePlanetText = (TextView) findViewById(R.id.heroPricePlanet);
        final TextView priceSaphirText = (TextView) findViewById(R.id.heroPriceSaph);

        Firebase.setAndroidContext(getApplicationContext());

        Firebase heroDescription = new Firebase("https://planet-of-heroes-base.firebaseio.com/Heroes/Khanley/Desc");
        Firebase heroPricePlanet = new Firebase("https://planet-of-heroes-base.firebaseio.com/Heroes/Khanley/Price/Planetoons");
        Firebase heroPriceSaphire = new Firebase("https://planet-of-heroes-base.firebaseio.com/Heroes/Khanley/Price/Saph");

        spinner = (ProgressBar) findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);

        heroDescription.addValueEventListener(new ValueEventListener() {
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

        heroPricePlanet.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                spinner.setVisibility(View.GONE);
                String myChildText = dataSnapshot.getValue(String.class);
                pricePlanetText.setText(myChildText);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                spinner.setVisibility(View.GONE);
                pricePlanetText.setText("Error found");
            }
        });

        heroPriceSaphire.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                spinner.setVisibility(View.GONE);
                String myChildText = dataSnapshot.getValue(String.class);
                priceSaphirText.setText(myChildText);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                spinner.setVisibility(View.GONE);
                priceSaphirText.setText("Error found");
            }
        });
    }

    public void backBtnClick(View v){
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
