package com.example.examen;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class clsMenu {
    private Context context;
    private String[] tabMenu;

    public clsMenu(Context context) {
        this.context = context;
    }

    public void onCreateOptionsMenu(Menu menu) {
        if (tabMenu == null || tabMenu.length == 0) {
            tabMenu = new String[]{"Tous les places","Les places Disponibles","Rechercher ma voiture"};
        }
        for (int i = 0; i < tabMenu.length; i++) {
            menu.add(Menu.NONE, Menu.FIRST + i, i, tabMenu[i]);
        }
    }


    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case Menu.FIRST:
                // Action pour le premier élément de menu
                intent = new Intent(context, LesPlacesActivity.class);
                context.startActivity(intent);
                return true;
            case Menu.FIRST + 1:
                // Action pour le deuxième élément de menu
                intent = new Intent(context, PlaceDispoActivity.class);
                context.startActivity(intent);
                return true;
            case Menu.FIRST + 2:
                // Action pour le troisième élément de menu
                intent = new Intent(context, FindVehiculeActivity.class);
                context.startActivity(intent);
                return true;
            default:
                return false;
        }
    }






}
