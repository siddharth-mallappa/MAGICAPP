
package com.example.dashboard;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

//import android.view.View;


public class Newsfeed extends AppCompatActivity {
    private static  final String TAG= MainActivity.class.getName();
    //private static final String SERVER = "http://10.0.2.2:3000/";
    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);
        final Button off= (Button) findViewById(R.id.button_newsfeed_off);
        final Button on= (Button) findViewById(R.id.button_newsfeed_on);
        final Button next= (Button) findViewById(R.id.button_newsfeed_next);
        final Button previous = (Button) findViewById(R.id.button_newsfeed_previous);
        final Button details=(Button)(findViewById(R.id.button_newsfeed_details));
        final Button highlights=(Button)(findViewById(R.id.button_newsfeed_lessdetails));
        final Button fullarticle=(Button)(findViewById(R.id.button_newsfeed_showfullarticle));

        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendANDprintResponce("http://10.0.2.2:8080/api/modules/newsfeed/HIDE");


            }

        });
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendANDprintResponce("http://10.0.2.2:8080/api/modules/newsfeed/SHOW");


            }

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendANDprintResponce("http://10.0.2.2:8080/api/module/newsfeed/articlenext");


            }

        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendANDprintResponce("http://10.0.2.2:8080/api/module/newsfeed/articleprevious");


            }

        });
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendANDprintResponce("http://10.0.2.2:8080/api/module/newsfeed/articlemoredetails");


            }

        });
        highlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendANDprintResponce("http://10.0.2.2:8080/api/module/newsfeed/articlelessdetails");


            }

        });
        fullarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendANDprintResponce("http://10.0.2.2:8080/api/module/newsfeed/articletogglefull");


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