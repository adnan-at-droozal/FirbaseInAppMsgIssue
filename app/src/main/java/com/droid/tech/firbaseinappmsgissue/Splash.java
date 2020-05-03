package com.droid.tech.firbaseinappmsgissue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.analytics.FirebaseAnalytics;


public class Splash extends Activity {

    private static final String TAG = "Splash";
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        showSplash();
    }

    private void showSplash() {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Thread background = new Thread() {
            public void run() {

                try {
                    // Thread will sleep for five seconds
                    sleep(1500);

                    // After five seconds redirect to another intent
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);

                    //Remove activity
                    finish();

                } catch (Exception e) {

                }
            }
        };

        background.start();
        ImageView im = (ImageView) findViewById(R.id.img);
        Animation myAnim = AnimationUtils.loadAnimation(Splash.this, R.anim.animation);
        im.startAnimation(myAnim);
    }

}
