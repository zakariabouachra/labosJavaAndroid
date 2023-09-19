package com.example.examen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class FindVehiculeActivity extends AppCompatActivity {

    private clsMenu Menu;
    private clsPlaceTableGateWay myDb = new clsPlaceTableGateWay(this,"examen",null,1);
    private clsPlaceArrayAdapter adapter;
    private ArrayList<clsPlace> arrayList;
    private ListView listView;
    private Button btnFind;
    private EditText txtFind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_vehicule);

        this.myDb.Open();
        this.myDb.DeleteAll();
        this.myDb.SeedNewPlace();

        Menu = new clsMenu(this);
        listView = (ListView) findViewById(R.id.lst_lesPlaces);
        txtFind = (EditText) findViewById(R.id.txt_find);
        btnFind = (Button) findViewById(R.id.btn_find);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String find = txtFind.getText().toString();
                if(arrayList == null){
                    arrayList = new ArrayList<clsPlace>();
                }
                try {
                    arrayList = myDb.ChercherPlaceAvecPlaque(find);
                    if (arrayList.isEmpty()) {
                        new AlertDialog.Builder(FindVehiculeActivity.this)
                                .setTitle("Aucune voiture trouvée")
                                .setMessage("Aucune voiture trouvée avec la plaque d'immatriculation fournie.")
                                .setPositiveButton("OK", null)
                                .show();
                    } else {
                        adapter = new clsPlaceArrayAdapter(FindVehiculeActivity.this,R.layout.lst_place_stationnement,arrayList);
                        listView.setAdapter(adapter);
                    }
                } catch (Exception e) {
                    new AlertDialog.Builder(FindVehiculeActivity.this)
                            .setTitle("Erreur de recherche")
                            .setMessage("Une erreur s'est produite lors de la recherche de voiture. Veuillez réessayer.")
                            .setPositiveButton("OK", null)
                            .show();
                    e.printStackTrace();
                }
            }
        });





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