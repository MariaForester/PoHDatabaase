package com.poh.base;

import android.annotation.SuppressLint;
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
    private String[] text2;

    Slide_adapter(Context context, ArrayList<Integer> images, String[] text, String[] text2) {
        this.context = context;
        this.images = images;
        this.text = text;
        this.text2 = text2;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        if (!images.isEmpty())
            return images.size();
        if (text.length != 0) return text.length;
        else return text2.length;
    }


    @NonNull
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View myImageLayout = inflater.inflate(R.layout.slide_set, null);

        if (text.length != 0) {
            TextView textSlide = (TextView) myImageLayout.findViewById(R.id.textSlide);
            textSlide.setText(text[position]);
        }
        if (text2.length != 0) {
            TextView textSlide2 = (TextView) myImageLayout.findViewById(R.id.textSlide2);
            textSlide2.setText(text2[position]);
        }
        if (!images.isEmpty()) {
            ImageView myImage = (ImageView) myImageLayout.findViewById(R.id.image);
            myImage.setImageResource(images.get(position));
        }
        view.addView(myImageLayout, 0);
        return myImageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
