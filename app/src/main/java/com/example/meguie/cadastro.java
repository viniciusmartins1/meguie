package com.example.meguie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class cadastro extends AppCompatActivity {

    EditText editNome, editEmail, editSenha, editCpf, editTelefone;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        InicializarComponentes();


    }

    private void InicializarComponentes() {
        editNome = findViewById(R.id.editTextEmail);
        editNome = findViewById(R.id.editTextSenha);
        editNome = findViewById(R.id.editTextCpf);
        editNome = findViewById(R.id.editTextTelefone);
        editNome = findViewById(R.id.editTextNome);

        btnCadastrar = findViewById(R.id.btnCadastrar);
    }
}