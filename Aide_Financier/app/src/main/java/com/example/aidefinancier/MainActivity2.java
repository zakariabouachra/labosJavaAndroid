package com.example.aidefinancier;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity2 extends AppCompatActivity {

    EditText txtDepot;
    EditText txtInteret;
    EditText txtAns;
    Button btnCacluler;
    TextView lblResultat;

    Button btnRecommencer;
    Button btnRevenue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.txtDepot = (EditText) findViewById(R.id.txt_Depot);
        this.txtInteret = (EditText) findViewById(R.id.txt_Interets);
        this.txtAns = (EditText) findViewById(R.id.txt_Ans);
        this.lblResultat = (TextView) findViewById(R.id.lbl_Resultat);
        this.btnCacluler = (Button) findViewById(R.id.btn_Calculer);
        this.btnRecommencer = (Button) findViewById(R.id.btnRecommencer);
        this.btnRevenue = (Button) findViewById(R.id.btnRevenue);

        this.btnCacluler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newLine = System.getProperty("line.separator");

                try {
                    Double depot = Double.parseDouble(txtDepot.getText().toString());
                    Double interet = Double.parseDouble(txtInteret.getText().toString())/100;
                    Integer ans = Integer.parseInt(txtAns.getText().toString());
                    String Resultat = "";

                    for(int k=0; k <= ans ; k++) {
                        Double E = depot * Math.pow((1 + interet), (double) k);
                        Resultat += (k + " :  " + E + "$" + newLine) ;
                        lblResultat.setText(Resultat);
                    }

                    btnCacluler.setVisibility(View.GONE);
                    btnRecommencer.setVisibility(View.VISIBLE);
                    btnRevenue.setVisibility(View.VISIBLE);


                }
                catch (NumberFormatException nfe){
                    Toast.makeText (
                            MainActivity2.this, "Champs vide ou invalide! Veuillez" +
                                    " entrez des nombres...", Toast.LENGTH_LONG
                    ).show();
                }
            }

        });

        this.btnRevenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(i);
            }
        });

        this.btnRecommencer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r = new Intent(MainActivity2.this,MainActivity2.class);
                startActivity(r);
            }
        });


    };
}