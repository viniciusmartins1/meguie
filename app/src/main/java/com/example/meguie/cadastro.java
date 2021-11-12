package com.example.meguie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.temporal.TemporalUnit;


public class cadastro extends AppCompatActivity {

    private EditText editNome, editEmail;
    private Button btnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        InicializarComponentes();



    }

    private void InicializarComponentes() {
        editNome = findViewById(R.id.editTextEmail);
        editEmail = findViewById(R.id.editTextSenha);

        btnCadastrar = findViewById(R.id.btnCadastrar);
    }
}