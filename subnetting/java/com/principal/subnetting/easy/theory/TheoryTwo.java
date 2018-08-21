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
import com.principal.subnetting.easy.sliders.SliderAdapterTwo;

public class TheoryTwo extends AppCompatActivity {

    private ViewPager pagerSliderView;
    private LinearLayout dotLayout;

    private TextView[] mDots2;

    private SliderAdapterTwo sliderAdapter;

    private Button btNext;
    private Button btBack;

    private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theory_two);

        pagerSliderView = (ViewPager) findViewById(R.id.view_pager2);
        dotLayout = (LinearLayout) findViewById(R.id.layout_dots2);

        btNext = (Button)findViewById(R.id.bt_next2);
        btBack = (Button)findViewById(R.id.bt_skip2);

        sliderAdapter = new SliderAdapterTwo(this);
        pagerSliderView.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        pagerSliderView.addOnPageChangeListener(viewListener2);

        //onClickListener

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pagerSliderView.setCurrentItem(currentPage + 1);
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pagerSliderView.setCurrentItem(currentPage - 1);
            }
        });
    }

    public void addDotsIndicator(int position){
        mDots2 = new TextView[3];
        dotLayout.removeAllViews();

        for (int i = 0; i < mDots2.length; i++){
            mDots2[i] = new TextView(this);
            mDots2[i].setText(Html.fromHtml("&#8226;"));
            mDots2[i].setTextSize(35);
            mDots2[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            dotLayout.addView(mDots2[i]);
        }

        if(mDots2.length > 0){
            mDots2[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener2 = new ViewPager.OnPageChangeListener() {
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


            }else if (i == mDots2.length - 1){
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
