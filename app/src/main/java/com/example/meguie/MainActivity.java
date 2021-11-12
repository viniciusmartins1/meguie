package com.example.meguie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnTrocar, btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentCadastro = new Intent(this, cadastro.class);
        Intent intentLogin = new Intent(this, guias.class);

        inicializarComponentes();
        mudarTelaCadastro(intentCadastro);
        fazerLogin(intentLogin);


    }

    private void mudarTelaCadastro(Intent intent) {
        btnTrocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
    private void fazerLogin(Intent intent) {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    private void inicializarComponentes() {
        btnTrocar = findViewById(R.id.btnTrocar);
        btnLogin = findViewById(R.id.btnLogin);
    }

}