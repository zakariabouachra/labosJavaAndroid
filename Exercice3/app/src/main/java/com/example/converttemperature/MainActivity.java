package com.example.converttemperature;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText txtTemp;
    private Button btnConvert;

    public Double Convert_To_F(Double C){
        return (9.0/5.0)*C + 32;
    }
    public Double Convert_To_C(Double F){
        return (5.0/9.0)*(F - 32);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.txtTemp = (EditText) findViewById(R.id.txtTemperature);
        this.btnConvert = (Button) findViewById(R.id.btnConvert);


        this.btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this,MainActivity2.class);
                    try {
                        String temp = txtTemp.getText().toString();
                        if(temp.isEmpty()) {
                            Toast.makeText (
                                    MainActivity.this, "Champs vide!", Toast.LENGTH_SHORT
                            ).show();
                            return;
                        }
                        String[] STemp = temp.split("@");
                        Double T = Double.parseDouble(STemp[0]);
                        if (STemp[1].equals("C")|| STemp[1].equals("c")) {
                            Double result = Convert_To_F(T);
                            it.putExtra("temp",result.toString()+" F");
                            startActivity(it);
                        } else if (STemp[1].equals("F") || STemp[1].equals("f")) {
                            Double result = Convert_To_C(T);
                            it.putExtra("temp",result.toString()+" C");
                            startActivity(it);
                        }
                        else{
                            Toast.makeText (
                                    MainActivity.this, "Format invalide ! (Temp@C ou F)", Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                    catch(Exception ee) {
                        Toast.makeText(
                                MainActivity.this, "Format invalide ! (Temp@C ou F)", Toast.LENGTH_SHORT
                        ).show();
                    }

            }
        });
    }
}