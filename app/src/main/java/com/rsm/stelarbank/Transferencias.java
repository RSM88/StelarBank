package com.rsm.stelarbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// Vista para seleccionar inversiones
public class Transferencias extends AppCompatActivity {

    Button btn_pagos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencias);

        btn_pagos = findViewById(R.id.btn_pagos);

        btn_pagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Transferencias.this, Pagos.class);
                startActivity(intent);
            }
        });

    }
}