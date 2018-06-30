package com.poh.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Menu_Heroes extends Left_menu {

    private ListView listView;
    private List_heroAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_heroes);

        listView = (ListView) findViewById(R.id.heroes_list);

        ArrayList<List_heroStructure> heroesList = new ArrayList<>(20);

        heroesList.add(new List_heroStructure(R.drawable.sof, "Sofia"));
        heroesList.add(new List_heroStructure(R.drawable.timm, "Timmy"));
        heroesList.add(new List_heroStructure(R.drawable.ask, "Askari"));
        heroesList.add(new List_heroStructure(R.drawable.lib, "Libertron"));
        heroesList.add(new List_heroStructure(R.drawable.anna, "Anna"));
        heroesList.add(new List_heroStructure(R.drawable.khan, "Khan'ley"));
        heroesList.add(new List_heroStructure(R.drawable.eizo, "Eizo"));
        heroesList.add(new List_heroStructure(R.drawable.yumi, "Yumi"));
        heroesList.add(new List_heroStructure(R.drawable.iff, "Iffir"));
        heroesList.add(new List_heroStructure(R.drawable.leon, "Leon"));
        heroesList.add(new List_heroStructure(R.drawable.neelu, "Neelu"));
        heroesList.add(new List_heroStructure(R.drawable.doz, "Dozer"));
        heroesList.add(new List_heroStructure(R.drawable.cand, "Candy"));
        heroesList.add(new List_heroStructure(R.drawable.zarx, "Zarx"));
        heroesList.add(new List_heroStructure(R.drawable.sky, "Sky'lee"));
        heroesList.add(new List_heroStructure(R.drawable.bubb, "Bubbles"));
        heroesList.add(new List_heroStructure(R.drawable.magn, "Magnum"));
        heroesList.add(new List_heroStructure(R.drawable.rond, "Ronda"));
        heroesList.add(new List_heroStructure(R.drawable.dunc, "Duncan"));
        heroesList.add(new List_heroStructure(R.drawable.blue, "Bluebeard"));


        mAdapter = new List_heroAdapter(this, heroesList);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent myintent = new Intent(view.getContext(), Hero_Sofia.class);
                    startActivityForResult(myintent, 0);
                }
                if (position == 1) {
                    Intent myintent = new Intent(view.getContext(), Hero_Timmy.class);
                    startActivityForResult(myintent, 1);
                }
                if (position == 2) {
                    Intent myintent = new Intent(view.getContext(), Hero_Askari.class);
                    startActivityForResult(myintent, 2);
                }
                if (position == 3) {
                    Intent myintent = new Intent(view.getContext(), Hero_Libertron.class);
                    startActivityForResult(myintent, 3);
                }
                if (position == 4) {
                    Intent myintent = new Intent(view.getContext(), Hero_Anna.class);
                    startActivityForResult(myintent, 4);
                }
                if (position == 5) {
                    Intent myintent = new Intent(view.getContext(), Hero_Khan.class);
                    startActivityForResult(myintent, 5);
                }
                if (position == 6) {
                    Intent myintent = new Intent(view.getContext(), Hero_Eizo.class);
                    startActivityForResult(myintent, 6);
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Menu_Heroes.this, Menu_PoHBase_Home.class);
            startActivity(intent);
            this.finish();
        }
        return false;
    }
}
