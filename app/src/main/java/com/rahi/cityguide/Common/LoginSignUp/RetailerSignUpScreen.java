package com.rahi.cityguide.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.rahi.cityguide.R;

public class RetailerSignUpScreen extends AppCompatActivity {

    Button login,signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_sign_up_screen);
        login = findViewById(R.id.login_btn);
        signup = findViewById(R.id.signup_btn);
    }

    public void callLoginScreen(View view) {
        Intent intent = new Intent(getApplicationContext(),RetailerLogin.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(login,"transition_login_btn");
        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(RetailerSignUpScreen.this,pairs);
        startActivity(intent,activityOptions.toBundle());
    }

    public void callNextSignUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(),RetailerSignUp.class);
        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View,String>(signup,"transition_login_btn");
        ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(RetailerSignUpScreen.this,pairs);
        startActivity(intent,activityOptions.toBundle());
    }
}