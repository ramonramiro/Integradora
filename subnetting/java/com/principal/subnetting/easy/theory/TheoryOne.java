package com.principal.subnetting.easy.theory;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.principal.subnetting.easy.R;
import com.principal.subnetting.easy.sliders.SliderAdapterOne;

public class TheoryOne extends AppCompatActivity {

    private ViewPager pagerSliderViewOne;
    private LinearLayout dotLayout;

    private TextView[] mDots;

    private SliderAdapterOne sliderAdapter;

    private Button btNext;
    private Button btBack;

    private int currentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_one);


        pagerSliderViewOne = findViewById(R.id.view_pager);
        dotLayout =  findViewById(R.id.layout_dots);

        btNext = findViewById(R.id.bt_next);
        btBack = findViewById(R.id.bt_return);

        sliderAdapter = new SliderAdapterOne(this);
        pagerSliderViewOne.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        pagerSliderViewOne.addOnPageChangeListener(viewListener);

        //onClickListener

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pagerSliderViewOne.setCurrentItem(currentPage + 1);
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pagerSliderViewOne.setCurrentItem(currentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        dotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            dotLayout.addView(mDots[i]);
        }

        if(mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);

            currentPage = i;

            if(i == 0){
                btNext.setEnabled(true);
                btBack.setEnabled(false);
                btBack.setVisibility(View.INVISIBLE);

                btNext.setText(R.string.next_theory);
                btBack.setText("");


            }else if (i == mDots.length - 1){
                btNext.setEnabled(true);
                btBack.setEnabled(true);
                btBack.setVisibility(View.VISIBLE);

                btNext.setText("");
                btBack.setText(R.string.back_theory);
            }else{
                btNext.setEnabled(true);
                btBack.setEnabled(true);
                btBack.setVisibility(View.VISIBLE);

                btNext.setText(R.string.next_theory);
                btBack.setText(R.string.back_theory);
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
