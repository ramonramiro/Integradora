package com.principal.subnetting.easy.sliders;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.principal.subnetting.easy.R;

public class SliderAdapterOne extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;


    public SliderAdapterOne(Context context){
        this.context = context;    }

    //Arrays
    public int[] slideImages = {
            R.drawable.ic_pag_1,
            R.drawable.ic_pag_2,
            R.drawable.ic_pag_3
    };



    public String[] slideHeadings = {
            "",
            "",
            ""
    };


/*
    public String [] slide_descs = {
            "Este es un boton muy bonito" +
                    "aliqua",
            "Este boton no me gusta nada" +
                    "aliqua",
            "Pagina principal de la empresa"+
                    "aliqua"
    };

    */







    @Override
    public int getCount() {
        return slideHeadings.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout_one, container, false);

        ImageView slideImageView = view.findViewById(R.id.image_slide_theory_one);


        slideImageView.setImageResource(slideImages[position]);


        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position,Object object) {
        container.removeView((LinearLayout)object);
    }
}

