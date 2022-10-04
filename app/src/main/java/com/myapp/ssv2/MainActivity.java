package com.myapp.ssv2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 4000;
    Animation topAnim, bottomAnim;
    ImageView image;
    TextView logo,slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image = findViewById(R.id.imageView);
        logo = findViewById(R.id.textView);
        slogan = findViewById(R.id.textView2);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(() -> {
            Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
           // startActivity(homeIntent);
          //  finish();
            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<View,String>(image, "logo_image");
            pairs[1] = new Pair<View,String>(logo, "logo_text");

            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);

        },SPLASH_TIME_OUT);
    }
}