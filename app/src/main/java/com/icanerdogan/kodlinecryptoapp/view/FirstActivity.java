package com.icanerdogan.kodlinecryptoapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.icanerdogan.kodlinecryptoapp.databinding.ActivityFirstBinding;

public class FirstActivity extends AppCompatActivity {
    private ActivityFirstBinding activityFirstBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide Title Bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Binding
        activityFirstBinding = ActivityFirstBinding.inflate(getLayoutInflater());
        View view = activityFirstBinding.getRoot();
        setContentView(view);


        // Click "DON'T HAVE AN ACCOUNT? SIGN UP" Button
        activityFirstBinding.buttonBackSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignInToSignUp();
            }
        });

        activityFirstBinding.buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FirstActivity.this, MainActivity.class));
                finish();
            }
        });

    }

    //SignIn To SignUp
    public void SignInToSignUp(){
        Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
        startActivity(intent);
        finish();
    }

}