package com.codepath.cascadingslideanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView image1;
    ImageView image2;
    ImageView image3;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);
        image1.setOnClickListener(this);
        image2.setOnClickListener(this);
        image3.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        image2.bringToFront();
        image1.bringToFront();
        Animation image1Animation = AnimationUtils.loadAnimation(this, R.anim.slide_up_image1);
        image1Animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                image2.startAnimation(AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up_image2));
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        image1.startAnimation(image1Animation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.image1:
                Toast.makeText(this, "Image 1 clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image2:
                Toast.makeText(this, "Image 2 clicked!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.image3:
                Toast.makeText(this, "Image 3 clicked!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
