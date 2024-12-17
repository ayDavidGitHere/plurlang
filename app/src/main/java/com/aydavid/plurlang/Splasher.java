package com.aydavid.plurlang;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class Splasher extends Activity {

    private static final int SPLASH_DELAY = 1200; // Delay in milliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        // Hide the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Hide the title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		    super.onCreate(savedInstanceState);
        setContentView(R.layout.splasher);
		     
		    //Toast.makeText(Splasher.this, "setContentView", 1000).show();
		    
		    ImageView splashImage = findViewById(R.id.splash_image);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation);
        splashImage.startAnimation(animation);
		    //Toast.makeText(Splasher.this, "splash_animation", 1500).show();
        
        // Simulate loading data or resources
        // You can replace this with your actual loading process
        // For example, you can use a background thread or an asynchronous task

        // Delay the navigation to MainActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start MainActivity
                Intent intent = new Intent(Splasher.this, MainActivity.class);
                try {
                  startActivity(intent);
                  // Close the Splasher activity
                  finish();
                }catch(Exception e) {
                  Toast.makeText(Splasher.this, "Cannnot Open App \n" + e.getMessage(), 6000).show();
                }
            }
        }, SPLASH_DELAY);
    }
}