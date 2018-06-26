package com.poh.base;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class sparkView2 extends AppCompatActivity {

    public ImageView random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sparks_layout);

        ImageView sparkView = (ImageView) findViewById(R.id.sparkView);
        sparkView.setImageResource(R.drawable.explore_background);

        TextView sparkText = (TextView) findViewById(R.id.sparksText);
        sparkText.setText("This spark page is going to be updated soon");
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
