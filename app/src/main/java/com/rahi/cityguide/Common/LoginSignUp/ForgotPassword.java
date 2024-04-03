package com.rahi.cityguide.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rahi.cityguide.R;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }

    public void callMakeSelection(View view) {
        startActivity(new Intent(getApplicationContext(),MakeSelection.class));
        finish();
    }
}