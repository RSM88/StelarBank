package com.rsm.stelarbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    Button btn_enter;
    TextView txv_reset;


    // Pantalla Login para introducir credenciales
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        btn_enter = findViewById(R.id.btn_enter);
        txv_reset = findViewById(R.id.txv_reset);


        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        txv_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "An email has been sent to reset your password, please check your acoount",
                        Toast.LENGTH_LONG).show();
            }
        });


    }
}