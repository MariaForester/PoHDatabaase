package com.poh.base;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Slide_adapter extends PagerAdapter {

    private ArrayList<Integer> images;
    private String[] text;
    private LayoutInflater inflater;
    private Context context;

    Slide_adapter(Context context, ArrayList<Integer> images, String[] text) {
        this.context = context;
        this.images = images;
        this.text = text;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.slide_set, null);
        ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.image);
        TextView textSlide = (TextView) myImageLayout.findViewById(R.id.textSlide);
        textSlide.setText(text[position]);
        myImage.setImageResource(images.get(position));
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
