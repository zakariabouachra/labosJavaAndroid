package com.example.myappexercice1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText recupSM;
    private EditText recupPA;
    private EditText recupAR;
    private EditText txtTotalMensuel;
    private EditText recupPH;
    private EditText recupPAuto;
    private EditText recupPPretP;
    private EditText recupSoldeCD;
    private EditText recupPEtud;
    private EditText recupPSoutien;
    private EditText recupMDivers;
    private EditText txtRatio;
    private EditText txtTotalPayment;
    private Button btnClick;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtTotalMensuel = (EditText) findViewById(R.id.txt_total_mensuel);
        this.recupSM = (EditText) findViewById(R.id.txt_salaire_mensuel);
        this.recupPA = (EditText) findViewById(R.id.txt_pension_alimentaire);
        this.recupAR = (EditText) findViewById(R.id.txt_autres_revenus);
        this.recupPH = (EditText) findViewById(R.id.txt_Payment_Hypo);
        this.recupPAuto = (EditText) findViewById(R.id.txt_Payment_Auto);
        this.recupPPretP = (EditText) findViewById(R.id.txt_Payment_Perso);
        this.recupSoldeCD = (EditText) findViewById(R.id.txt_Payment_Credit_Card);
        this.recupPEtud = (EditText) findViewById(R.id.txt_Payment_Etudiant);
        this.recupPSoutien = (EditText) findViewById(R.id.txt_pension_alimentaire);
        this.recupMDivers = (EditText) findViewById(R.id.txt_Payment_Divers);
        this.txtTotalPayment = (EditText) findViewById(R.id.txt_total_payment);
        this.txtRatio = (EditText) findViewById(R.id.txt_Ratio);
        this.btnClick= (Button) findViewById(R.id.btnCalculer);


        this.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    Double SalaireM = Double.parseDouble(recupSM.getText().toString());
                    Double PensionA = Double.parseDouble(recupPA.getText().toString());
                    Double AutreS = Double.parseDouble(recupAR.getText().toString());


                    Double Total = SalaireM + PensionA + AutreS;

                    txtTotalMensuel.setText(Total.toString());


                    Double PaymentHypo = Double.parseDouble(recupPH.getText().toString());
                    Double PaymentAuto = Double.parseDouble(recupPAuto.getText().toString());
                    Double PaymentPerso = Double.parseDouble(recupPPretP.getText().toString());
                    Double PaymentCarteC = Double.parseDouble(recupSoldeCD.getText().toString());
                    Double PaymentEtudiant = Double.parseDouble(recupPEtud.getText().toString());
                    Double PaymentPension = Double.parseDouble(recupPSoutien.getText().toString());
                    Double PaymentDivers = Double.parseDouble(recupMDivers.getText().toString());

                    Double TotalPayment = PaymentHypo + PaymentAuto + PaymentPerso + PaymentCarteC
                            + PaymentEtudiant + PaymentPension + PaymentDivers;

                    txtTotalPayment.setText(TotalPayment.toString());

                    Double Ratio = (TotalPayment / Total) * 100;

                    DecimalFormat decimalFormat = new DecimalFormat("#,##");



                    txtRatio.setText(decimalFormat.format(Ratio).toString() + "%");
                }
                catch (NumberFormatException nfe) {
                    Toast.makeText (
                            MainActivity.this, "Champs vide ou invalide! Veuillez" +
                                    " entrez des nombres...", Toast.LENGTH_LONG
                    ).show();
                }






            }
        });
    }

}