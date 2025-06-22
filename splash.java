package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display
        EdgeToEdge.enable(this);

        // Make activity fullscreen
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        // Set layout for splash screen
        setContentView(R.layout.activity_splash);

        // Hide Action Bar (safely)
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        // Move to MainActivity after 5 seconds (5000 milliseconds)
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(splash.this, MainActivity.class);
            startActivity(intent);
            finish(); // close splash activity
        }, 500);

        // Handle insets if root layout has id "main"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

/*

        // For Hide Action Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //For Splash Screen
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Code here
                Intent myIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(myIntent);
                finish();
            }
        },5000);
        //==================================
        } // OnCreate Method Close Here ======================== Online https://bduidesign.blogspot.com/2024/11/splash-screen-android.html?fbclid=IwY2xjawLDwt5leHRuA2FlbQIxMABicmlkETFlZk5JU3FmMDhBWlhxTW9tAR642MpJbFyL0giP1gRPqKfiYaDe0BSqPFyBCGGnE6XThBAZwEvs3Iar1aQfVA_aem_PrHMNz-UFrbYaZY-Oeg2Lw

        */
