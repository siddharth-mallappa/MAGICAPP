package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public CardView newsfeed,notifications,generalSetting,account,compliments,calendar,clock,currentweather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        newsfeed = (CardView)findViewById(R.id.click_newsfeed);
        generalSetting = (CardView)findViewById(R.id.click_general_setting);
        notifications=(CardView)findViewById(R.id.click_notification);
        account=(CardView)findViewById(R.id.click_account);
        compliments=(CardView)findViewById(R.id.click_compliments);
        calendar=(CardView)findViewById(R.id.click_calander);
        clock=(CardView)findViewById(R.id.click_clock);
        currentweather=(CardView)findViewById(R.id.click_currentweather);



        newsfeed.setOnClickListener(this);
        notifications.setOnClickListener(this);
        generalSetting.setOnClickListener(this);
        account.setOnClickListener(this);
        compliments.setOnClickListener(this);
        calendar.setOnClickListener(this);
        clock.setOnClickListener(this);
        currentweather.setOnClickListener(this);





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

            case R.id.click_general_setting: i=new Intent(this,GeneralSetting.class);
            startActivity(i);
            break;

            case R.id.click_calander: i=new Intent(this,Calendar.class);
                startActivity(i);
                break;

            case R.id.click_clock: i=new Intent(this,Clock.class);
                startActivity(i);
                break;

            case R.id.click_compliments: i=new Intent(this,Compliments.class);
                startActivity(i);
                break;

            case R.id.click_currentweather: i=new Intent(this,CurrentWeather.class);
                startActivity(i);
                break;

            case R.id.click_account: i=new Intent(this,Account.class);
                startActivity(i);
                break;
        }

    }
}
