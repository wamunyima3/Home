package com.primeclass.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class SplashScreen extends AppCompatActivity {

    private final int[] images = {R.drawable.house,R.drawable.bh};
    private static final int SPLASH_TIME  = 5000;
    Animation topAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Animation
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        findViewById(R.id.appTitle).setAnimation(topAnim);
        findViewById(R.id.slogan).setAnimation(bottomAnim);

        //splash sliding images
        SliderView splashImgSlider = findViewById(R.id.splashImageSlider);
        SliderImageAdapter adapter = new SliderImageAdapter(images);
        splashImgSlider.setSliderAdapter(adapter);
        splashImgSlider.setIndicatorAnimation(IndicatorAnimationType.WORM);
        splashImgSlider.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        splashImgSlider.startAutoCycle();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,Login.class));
                finish();
            }
        },SPLASH_TIME);
    }
}