package com.example.converttemperature;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bundle res = getIntent().getExtras();

        if(res!=null){
            String temp = res.getString("temp");


            AlertDialog.Builder alb = new AlertDialog.Builder(this);
            alb.setMessage("Il fait " + temp);
            alb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent it = new Intent(MainActivity2.this,MainActivity.class);

                    startActivity(it);

                }
            });
            alb.create();
            alb.show();

        }
        }
    }
