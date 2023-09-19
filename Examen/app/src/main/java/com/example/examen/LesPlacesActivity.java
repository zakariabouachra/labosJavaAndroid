package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class LesPlacesActivity extends AppCompatActivity {

    private clsMenu Menu;
    private clsPlaceTableGateWay myDb = new clsPlaceTableGateWay(this,"examen",null,1);
    private clsPlaceArrayAdapter adapter;
    private ArrayList<clsPlace> arrayList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_les_places);

        this.myDb.Open();
        this.myDb.DeleteAll();
        this.myDb.SeedNewPlace();


        Menu = new clsMenu(this);
        listView = (ListView) findViewById(R.id.lst_lesPlaces);

        if(arrayList == null){
            arrayList = new ArrayList<clsPlace>();
        }
        arrayList = myDb.FindALLPlace();

        adapter = new clsPlaceArrayAdapter(this,R.layout.lst_place_stationnement,arrayList);
        listView.setAdapter(adapter);
        



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