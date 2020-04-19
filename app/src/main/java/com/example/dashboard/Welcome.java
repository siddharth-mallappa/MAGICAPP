package com.example.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {
    Animation topAnim, bottomAnim;
    ImageView topimage,bottomimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        topimage=(ImageView)findViewById(R.id.topimage);
        bottomimage=(ImageView)findViewById(R.id.bottomimage);

        topimage.setAnimation(topAnim);
        bottomimage.setAnimation(bottomAnim);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Welcome.this,mirrorsAvailable.class);
                startActivity(i);
                finish();
            }
        },3000);



    }
}