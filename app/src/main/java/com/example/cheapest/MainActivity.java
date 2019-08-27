package com.example.cheapest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtLitrao;
    EditText edtLatao;
    EditText edtLatinha;
    Button btnCalcula;
    TextView txtResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtLatao = findViewById(R.id.edtValor500);
        edtLitrao = findViewById(R.id.edtValor1000);
        edtLatinha = findViewById(R.id.edtValor273);
        txtResposta = findViewById(R.id.txtResposta);
        btnCalcula = findViewById(R.id.btnCalcular);


        btnCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtLatinha.length() == 0 || edtLatinha.length() == 0 || edtLatinha.length() == 0) {
                    Toast.makeText(MainActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else{
                    String retorno = calcular(Double.valueOf(edtLitrao.getText().toString()), Double.valueOf(edtLatao.getText().toString()), Double.valueOf(edtLatinha.getText().toString()));
                    Toast.makeText(MainActivity.this, retorno, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public String calcular(Double litrao, Double latao, Double latinha) {

            int controle = 0;
            String camponegativo = "";


            if (litrao <=0) {
                controle = 1;
                camponegativo += " Litrao";
            }

            if (latao <= 0) {
                controle = 1;
                camponegativo += ", Latao";
            }
            if (latinha <= 0) {
                controle = 1;
                camponegativo += ", Latinha";
            }


            if (controle == 0) {

                double divLitrao = litrao / 1000;
                double divLatao = latao / 473;
                double divLatinha = latinha / 350;
                double talvez = divLitrao;
                String vai = "nada";
                double referencia = 0;

                if (talvez < divLatao) {
                    vai = "Vai de Litrão";
                } else {
                    talvez = divLatao;
                    vai = "Vai de Latao";
                    referencia = divLatao;
                }
                if (talvez > divLatinha) {
                    vai = "Vai de Latinha";
                    referencia = divLatinha;
                }

                referencia = talvez;

                if ((divLatao == divLatinha) & (referencia == divLatao)) {
                    vai = "Pode ir de Litrao ou Latinha";
                } else if ((divLatao == divLitrao) & (referencia == divLatao)) {
                    vai = "Pode ir de Latao ou Litrao";
                } else if ((divLatinha == divLitrao) & (referencia == divLatinha)) {
                    vai = "Pode ir de Latinha ou Latao";
                }

                if ((divLatao == divLatinha) & (divLatao == divLitrao))
                    vai = "Tanto faz";
                return vai;
            } else
                return "Voce digitou um valor invalido no(s) campo(s):" + camponegativo;


        }
    }


