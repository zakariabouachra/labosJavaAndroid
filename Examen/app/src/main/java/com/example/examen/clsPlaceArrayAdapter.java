package com.example.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class clsPlaceArrayAdapter extends ArrayAdapter {

    private Context ctx;
    private ArrayList<clsPlace> lstP;
    private int res;

    public clsPlaceArrayAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        this.ctx = context;
        this.res = resource;
        this.lstP = (ArrayList<clsPlace>) objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        clsPlace temp = this.lstP.get(position);
        LayoutInflater inflater = LayoutInflater.from(ctx);



        if (convertView == null) {
            convertView = inflater.inflate(this.res,parent,false);
        }

        TextView adresse = (TextView) convertView.findViewById(R.id.lbl_adresse);
        TextView statut = (TextView) convertView.findViewById(R.id.lbl_statut);


        adresse.setText(temp.getAdresse());
        statut.setText(String.valueOf(temp.getStatut()));

        return convertView;
    }
}
