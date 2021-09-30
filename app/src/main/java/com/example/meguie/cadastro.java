package com.example.meguie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meguie.model.*;

import java.time.temporal.TemporalUnit;


public class cadastro extends AppCompatActivity {

    private EditText editNome, editEmail;
    private Button btnCadastrar;
    private  ClienteDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        InicializarComponentes();

        dao = new ClienteDAO(this);


    }

    public void  salvar(View view) {

        Cliente cliente = new Cliente();
        cliente.setEmail(editNome.getText().toString());
        cliente.setEmail(editEmail.getText().toString());

        long codigo = dao.inserir(cliente);

        Toast.makeText(this, "Cliente inserid o com id " + codigo, Toast.LENGTH_SHORT).show();
    }

    private void InicializarComponentes() {
        editNome = findViewById(R.id.editTextEmail);
        editEmail = findViewById(R.id.editTextSenha);

        btnCadastrar = findViewById(R.id.btnCadastrar);
    }
}