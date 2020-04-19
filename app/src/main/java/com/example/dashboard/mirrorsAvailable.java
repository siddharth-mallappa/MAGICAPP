package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class mirrorsAvailable extends AppCompatActivity implements bathroomPopup.ExampleDialogListener {
    Button b1,b2,b3;
    public static int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirrorsavailable);
        b1 = (Button) findViewById(R.id.button_bathroom);
        b2 = (Button) findViewById(R.id.button_bedroom);
        b3 = (Button) findViewById(R.id.button_office);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();

               id = 1;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
                id = 2;
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
                id = 3;
            }
        });
    }
    public void openDialog(){
        bathroomPopup first = new bathroomPopup();
        first.show(getSupportFragmentManager(),"mirror popup");
    }

    @Override
    public void bathroomPass(String password){
        if (password.equalsIgnoreCase("1234"))
        {
            Toast.makeText(mirrorsAvailable.this, "Correct", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(),MainActivity.class );
            startActivity(i);
        }
        else {
            Toast.makeText(mirrorsAvailable.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void bedroomPass(String password){
        if (password.equalsIgnoreCase("5678"))
            Toast.makeText(mirrorsAvailable.this, "Correct", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(mirrorsAvailable.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void officePass(String password) {
        if (password.equalsIgnoreCase("9101"))
            Toast.makeText(mirrorsAvailable.this, "Correct", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(mirrorsAvailable.this, "Incorrect Password", Toast.LENGTH_SHORT).show();

    }

}
