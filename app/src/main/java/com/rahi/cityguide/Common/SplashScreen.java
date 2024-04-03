package com.rahi.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.rahi.cityguide.R;
import com.rahi.cityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN=2700;
    ImageView SplashscreenImage;
    TextView SplashScreenText;
    Animation img_animation,txt_animation;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        SplashscreenImage=findViewById(R.id.Splashscreen_image);
        SplashScreenText=findViewById(R.id.Splashscreen_text);
        img_animation = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        txt_animation=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        SplashscreenImage.setAnimation(img_animation);
        SplashScreenText.setAnimation(txt_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen =getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime",true);
                if (isFirstTime){
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();
                    Intent i = new Intent(SplashScreen.this, OnBoarding.class);
                    startActivity(i);
                    finish();
                }
                else{
                    Intent i = new Intent(SplashScreen.this, UserDashboard.class);
                    startActivity(i);
                    finish();
                }
            }
        },SPLASH_SCREEN);
    }
}