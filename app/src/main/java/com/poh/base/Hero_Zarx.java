package com.poh.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

import me.relex.circleindicator.CircleIndicator;

public class Hero_Zarx extends AppCompatActivity {

    private ProgressBar spinner;
    String[] text = new String[]{"1 skill", "2 skill", "3 skill", "4 skill"};
    String[] text2 = new String[]{"dbbbbb", "zzzzzzzzzzzzzzzzz", null, null};
    private static final Integer[] slideImages = {R.color.background, R.color.background, R.color.background, R.color.background};
    private ArrayList<Integer> slideArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_layout);

        init();

        ImageView heroLayout = (ImageView) findViewById(R.id.heroLayout);
        heroLayout.setImageResource(R.drawable.zarx_layout);
        ImageView skinHero = (ImageView) findViewById(R.id.skinHero);
        skinHero.setImageResource(R.drawable.skin_layout);
        TextView heroName = (TextView) findViewById(R.id.heroName);
        heroName.setText("Zarx");
        TextView heroClass = (TextView) findViewById(R.id.heroClass);
        heroClass.setText("ASSASSIN");
        heroClass.setTextColor(getResources().getColor(R.color.assassin));

        final TextView heroText = (TextView) findViewById(R.id.heroText);
        final TextView pricePlanetText = (TextView) findViewById(R.id.heroPricePlanet);
        final TextView priceSaphirText = (TextView) findViewById(R.id.heroPriceSaph);

        Firebase.setAndroidContext(getApplicationContext());

        Firebase heroDescription = new Firebase("https://planet-of-heroes-base.firebaseio.com/Heroes/Zarx/Desc");
        Firebase heroPricePlanet = new Firebase("https://planet-of-heroes-base.firebaseio.com/Heroes/Zarx/Price/Planetoons");
        Firebase heroPriceSaphire = new Firebase("https://planet-of-heroes-base.firebaseio.com/Heroes/Zarx/Price/Saph");

        spinner = (ProgressBar) findViewById(R.id.progressBar);
        spinner.setVisibility(View.VISIBLE);

        heroDescription.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                spinner.setVisibility(View.GONE);
                String myChildText = dataSnapshot.getValue(String.class);
                heroText.setText(Html.fromHtml(myChildText), TextView.BufferType.SPANNABLE);
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
    private void init() {
        Collections.addAll(slideArray, slideImages);

        final ViewPager mPager = (ViewPager) findViewById(R.id.skillNumber);
        mPager.setAdapter(new Slide_adapter(Hero_Zarx.this, slideArray, text, text2));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicatorSkill);
        indicator.setViewPager(mPager);
    }
}
