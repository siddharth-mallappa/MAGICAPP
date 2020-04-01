package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public CardView newsfeed,notifications;
    public CardView generalSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        newsfeed = (CardView)findViewById(R.id.click_newsfeed);
        generalSetting = (CardView)findViewById(R.id.click_general_setting);
        notifications=(CardView)findViewById(R.id.click_notification);

        newsfeed.setOnClickListener(this);
        notifications.setOnClickListener(this);




    }






    @Override
    public void onClick(View v) {
        Intent i;

        switch(v.getId()){

            case R.id.click_newsfeed: i = new Intent(this,Newsfeed.class);
            startActivity(i);
            break;

            case R.id.click_notification: i=new Intent(this,Notifications.class);
                startActivity(i);
                break;
        }

    }
}
