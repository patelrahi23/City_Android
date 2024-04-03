package com.rahi.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rahi.cityguide.HelperClasses.SliderAdapter;
import com.rahi.cityguide.R;
import com.rahi.cityguide.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {
    ViewPager viewPager;
    LinearLayout dotsLayout;
    Button letsgetstarted,Skip;
    TextView[] dots;
    SliderAdapter sliderAdapter;
    Animation btn_animation;
    int currentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);
        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsgetstarted=findViewById(R.id.on_boarding_lets_get_started);
        Skip=findViewById(R.id.skip);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view){
        startActivity(new Intent(this, UserDashboard.class));
        finish();

    }
    public void next(View view){
        viewPager.setCurrentItem(currentPosition+1);
    }

    private void addDots(int position){
        dots = new TextView[4];
        dotsLayout.removeAllViews();
        for(int i=0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dotsLayout.addView(dots[i]);
        }
        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }
    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPosition=position;
            if(position==0){
                letsgetstarted.setVisibility(View.INVISIBLE);
                Skip.setVisibility(View.VISIBLE);
            }
            else if (position==1){
                letsgetstarted.setVisibility(View.INVISIBLE);
                Skip.setVisibility(View.VISIBLE);
            }
            else if (position==2){
                letsgetstarted.setVisibility(View.INVISIBLE);
                Skip.setVisibility(View.VISIBLE);
            }
            else {
                btn_animation= AnimationUtils.loadAnimation(OnBoarding.this,R.anim.bottom_anim);
                Skip.setVisibility(View.INVISIBLE);
                letsgetstarted.setAnimation(btn_animation);
                letsgetstarted.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}