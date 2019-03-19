package com.example.learncode;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }


        // Arrays
        public int[] slideImages = {
                R.drawable.assets1,
                R.drawable.assets2,
                R.drawable.assets3
        };

    public String[] slide_header = {
            "EAT", "SLEEP", "CODE"
    };

    public String[] slide_Desc = {
            "Quest lets you make interactive story games. Text adventure games like Zork and The Hitchhiker's Guide to the Galaxy. Gamebooks like the Choose Your Own Adventure and Fighting Fantasy books.",
            " You don't need to know how to program. All you need is a story to tell. Your game can be played anywhere. In a web browser, downloaded to a PC, or turned into an app. ",
            "Get started now for free, or find out more below."
    };


    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout) o;


    }

    @Override
    public Object instantiateItem (ViewGroup container, int position)  {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false  );

        ImageView slideImageView = (ImageView) view.findViewById(R.id.imageView);
        TextView slideHeading = (TextView) view.findViewById(R.id.slideHeader);
        TextView slideDesc = (TextView) view.findViewById(R.id.slideDesc);

        slideImageView.setImageResource(slideImages[position]);
        slideHeading.setText(slide_header[position]);
        slideDesc.setText(slide_Desc[position]);
        container.addView(view);
     return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((ConstraintLayout)object);
    }
}