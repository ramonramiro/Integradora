package com.principal.subnetting.easy.sliders;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.principal.subnetting.easy.R;


public class SliderAdapterTwo extends PagerAdapter{

    Context context2;
    LayoutInflater layoutInflater2;


    public SliderAdapterTwo(Context context){
        this.context2 = context;    }

    //Arrays
    public int[] slideImagesTwo = {
            R.drawable.ic_pag1_unidad2,
            R.drawable.ic_pag2_unidad2,
            R.drawable.ic_pag3_unidad2
    };



    public String[] slideHeadings = {
            "",
            "",
            ""
    };

    @Override
    public int getCount() {
        return slideHeadings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view ==  o;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater2 = (LayoutInflater) context2.getSystemService(context2.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater2.inflate(R.layout.slide_layout_two, container, false);

        ImageView slideImageView = view.findViewById(R.id.image_slide_theory_two);

        slideImageView.setImageResource(slideImagesTwo[position]);

        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((LinearLayout)object);
    }
}

