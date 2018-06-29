package com.poh.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class List_heroAdapter extends ArrayAdapter<List_heroStructure> {
    private Context mContext;
    private List<List_heroStructure> heroesList;

    public List_heroAdapter(@NonNull Context context, ArrayList<List_heroStructure> list) {
        super(context, 0, list);
        mContext = context;
        heroesList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_set, parent, false);

        List_heroStructure currentHero = heroesList.get(position);

        ImageView image = (ImageView) listItem.findViewById(R.id.imageView_hero);
        image.setImageResource(currentHero.getmImageDrawable());

        TextView text = (TextView) listItem.findViewById(R.id.heroLayerText);
        text.setText(currentHero.getName());

        return listItem;
    }
}

class List_heroStructure {
    private int mImageDrawable;
    private String name;

    public List_heroStructure(int mImageDrawable, String name) {
        this.mImageDrawable = mImageDrawable;
        this.name = name;
    }

    public int getmImageDrawable() {
        return mImageDrawable;
    }

    public void setmImageDrawable(int mImageDrawable) {
        this.mImageDrawable = mImageDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
