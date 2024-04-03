package com.rahi.cityguide.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rahi.cityguide.R;

public class SignUp3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3);
    }

    public void callLoginScreen(View view) {
    }

    public void callNextSignUpScreen(View view) {
        Intent intent = new Intent(getApplicationContext(),VerifyOTP.class);
        startActivity(intent);
    }
}