package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.github.glomadrian.materialanimatedswitch.MaterialAnimatedSwitch;

public class Notifications extends AppCompatActivity {
    private static  final String TAG= MainActivity.class.getName();
    //private static final String SERVER = "http://10.0.2.2:3000/";
    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;
    private MaterialAnimatedSwitch materialAnimatedSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        final Button on= (Button) findViewById(R.id.button_on);
        final Button off= (Button) findViewById(R.id.button_off);
        materialAnimatedSwitch = (MaterialAnimatedSwitch) findViewById(R.id.pin);

        materialAnimatedSwitch.setOnCheckedChangeListener(
                new MaterialAnimatedSwitch.OnCheckedChangeListener() {
                    @Override public void onCheckedChanged(boolean isChecked) {
                       if (materialAnimatedSwitch.isChecked()==true){
                           sendANDprintResponce("http://10.0.2.2:8080/api/modules/MMM-PushBulletNotifications/SHOW");
                       }
                       else if (materialAnimatedSwitch.isChecked()==false){
                           sendANDprintResponce("http://10.0.2.2:8080/api/modules/MMM-PushBulletNotifications/HIDE");
                       }
                    }
                });

        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendANDprintResponce("http://10.0.2.2:8080/api/modules/updatenotification/SHOW");
            }
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendANDprintResponce("http://10.0.2.2:8080/api/modules/updatenotification/HIDE");
            }
        });
    }
    private void sendANDprintResponce(String url) {
        mRequestQueue = Volley.newRequestQueue(this);


        stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG,"Responce"+ response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,"ERROR"+error.toString());
            }
        });

        mRequestQueue.add(stringRequest);
    }

}