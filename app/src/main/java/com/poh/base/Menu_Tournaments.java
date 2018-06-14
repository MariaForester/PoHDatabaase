package com.poh.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

public class Menu_Tournaments extends Left_menu {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_tournaments);
    }

    @Override                              //masha - back button - to the main act
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Menu_Tournaments.this, Menu_PoHBase_Home.class);
            startActivity(intent);
            this.finish();
        }
        return false;
    }
}
