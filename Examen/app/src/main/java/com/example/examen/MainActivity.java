package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private clsMenu Menu;
    private clsPlaceTableGateWay myDb = new clsPlaceTableGateWay(this,"examen",null,1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Menu = new clsMenu(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Menu.onCreateOptionsMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        return Menu.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}