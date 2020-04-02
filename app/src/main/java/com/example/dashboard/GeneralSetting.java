package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.marcinmoskala.arcseekbar.ArcSeekBar;
import com.marcinmoskala.arcseekbar.ProgressListener;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class GeneralSetting extends AppCompatActivity implements View.OnClickListener {
    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;
    private static final String TAG = GeneralSetting.class.getName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_setting);

        Button restart = (Button) findViewById(R.id.button_restart);
        Button shutdown = (Button) findViewById(R.id.button_shutdown);
        Button refresh = (Button) findViewById(R.id.button_refresh);

        restart.setOnClickListener(this);
        shutdown.setOnClickListener(this);
        refresh.setOnClickListener(this);

        ArcSeekBar gradientseekbar = (ArcSeekBar) findViewById(R.id.seekbar);

        int[] intArray = getResources().getIntArray(R.array.gradient);
        gradientseekbar.setProgressGradient(intArray);

        gradientseekbar.setOnProgressChangedListener(new ProgressListener() {
            @Override
            public void invoke(int i) {
                Log.d("VALUE", "" + i);
                String newstr = "http://10.0.2.2:8080/api/brightness/" + i;
                sendANDprintResponce(newstr);
            }
        });


    }

    private void sendANDprintResponce(String url) {
        mRequestQueue = Volley.newRequestQueue(this);


        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG, "Responce" + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG, "ERROR" + error.toString());
            }
        });

        mRequestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.button_refresh:
                sendANDprintResponce("http://10.0.2.2:8080/api/refresh");
                break;
            case R.id.button_restart:
                sendANDprintResponce("http://10.0.2.2:8080/api/reboot");
                break;

            case R.id.button_shutdown:
                sendANDprintResponce("http://10.0.2.2:8080/api/shutdown");
                break;
        }
    }
}
