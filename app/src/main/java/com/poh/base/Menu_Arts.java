package com.poh.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Menu_Arts extends Left_menu {

    GridView simpleGrid;
    int logos[] = {
            R.drawable.sofiawelcometwo, R.drawable.sof, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
            R.drawable.sofiawelcometwo, R.drawable.anna_layout, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
            R.drawable.sofiawelcometwo, R.drawable.anna_layout, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
            R.drawable.sofiawelcometwo, R.drawable.anna_layout, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
            R.drawable.sofiawelcometwo, R.drawable.anna_layout, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
            R.drawable.sofiawelcometwo, R.drawable.anna_layout, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
            R.drawable.sofiawelcometwo, R.drawable.anna_layout, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
            R.drawable.sofiawelcometwo, R.drawable.anna_layout, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
            R.drawable.sofiawelcometwo, R.drawable.anna_layout, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
            R.drawable.sofiawelcometwo, R.drawable.anna_layout, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
            R.drawable.sofiawelcometwo, R.drawable.anna_layout, R.drawable.bluebeard_layout, R.drawable.bubbles_layout,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_guides_arts);

        simpleGrid = (GridView) findViewById(R.id.guidesGridView);
        simpleGrid.setNumColumns(4);

        Grid_adapter customAdapter = new Grid_adapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);

        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Menu_Arts.this, Grid_newPage.class);
                intent.putExtra("image", logos[position]);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Menu_Arts.this, Menu_PoHBase_Home.class);
            startActivity(intent);
            this.finish();
        }
        return false;
    }
}
