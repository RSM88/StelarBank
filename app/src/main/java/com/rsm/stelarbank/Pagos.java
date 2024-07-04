package com.rsm.stelarbank;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Pagos extends AppCompatActivity {


    Button btn_pagar;
    Boolean pagado = false;

    TextView tv_monto;
    TextView tv_deuda;
    TextView tv_pendientes;
    TextView tv_info;

    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);

        btn_pagar = findViewById(R.id.btn_pagar);
        tv_monto = findViewById(R.id.tv_monto);
        tv_deuda =  findViewById(R.id.tv_deuda);
        tv_pendientes = findViewById(R.id.tv_pendientes);
        tv_info = findViewById(R.id.tv_info);
        progressBar = findViewById(R.id.progressBar);

        /* Codigo extenso: Evento click
        btn_pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagarTDC();
            }
        });
        */

        // Codigo simplificado: Evento click
        btn_pagar.setOnClickListener(v -> pagarTDC());

        // Barra de progreso invisible
        progressBar.setVisibility(View.INVISIBLE);

    }


    private void pagarTDC(){

        // Barra de progreso visible
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(() -> { // Genera retrazo de 5 seg

            if(!pagado){    // pagado = false ?
                // Se cambia el texto y visibilidad de elementos
                tv_monto.setText("$2800");
                tv_deuda.setText("$0");
                tv_pendientes.setText("Usted no tiene deudas pendientes");
                tv_info.setText("Listo! Adeudo pagado");
                btn_pagar.setVisibility(View.INVISIBLE);
            }
            progressBar.setVisibility(View.INVISIBLE);
        }, 5000);

    }
}


