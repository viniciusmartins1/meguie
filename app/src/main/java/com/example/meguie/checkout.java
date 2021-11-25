package com.example.meguie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class checkout extends AppCompatActivity {

    TextView txtNome, txtInstagram, txtTituloRoteiro, txtCidadeRoteiro, txtPrecoRoteiro, txtDuracaoRoteiro, txtDescricaoRoteiro, txtCnpj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        inicializarComponentes();

        //inicializarTexto();

        Intent intent = getIntent();
        int id = (int) intent.getSerializableExtra("id");
        String nome = (String) intent.getStringExtra("nome");
        String instagram = (String) intent.getStringExtra("instagram");
        String cnpj = (String) intent.getStringExtra("cnpj");


        int idRoteiro = (int) intent.getSerializableExtra("idRoteiro");
        String tituloRoteiro = (String) intent.getStringExtra("tituloRoteiro");
        String cidadeRoteiro = (String) intent.getStringExtra("cidadeRoteiro");
        String precoRoteiro = (String) intent.getStringExtra("precoRoteiro");
        String duracaoRoteiro = (String) intent.getStringExtra("duracaoRoteiro");
        String descricaoRoteiro = (String) intent.getStringExtra("descricaoRoteiro");


        txtNome.setText(nome);
        txtInstagram.setText(instagram);
        txtCnpj.setText(cnpj);

        txtCidadeRoteiro.setText(cidadeRoteiro);
        txtPrecoRoteiro.setText("R$ " + precoRoteiro + ",00");
        txtDuracaoRoteiro.setText(duracaoRoteiro+ " Horas");
        txtTituloRoteiro.setText(tituloRoteiro);
        txtDescricaoRoteiro.setText(descricaoRoteiro);


        Toast.makeText(this, "ID: "+ id, Toast.LENGTH_LONG).show();


    }

/*    private void inicializarTexto() {
        Intent intent = getIntent();
        Long id = (long) intent.getSerializableExtra("id");
        String nome = (String) intent.getSerializableExtra("nome");
        String instagram = (String) intent.getSerializableExtra("instagram");

        txtNome.setText(nome);
        txtInstagram.setText(instagram);
    }*/

    private void inicializarComponentes () {

        txtNome = findViewById(R.id.txtNomeGuia);
        txtInstagram = findViewById(R.id.txtInstagram);
        txtCidadeRoteiro = findViewById(R.id.txtCidadeRoteiro);
        txtDuracaoRoteiro = findViewById(R.id.txtDuracaoRoteiro);
        txtPrecoRoteiro = findViewById(R.id.txtPrecoRoteiro);
        txtTituloRoteiro = findViewById(R.id.txtTituloRoteiro);
        txtDescricaoRoteiro = findViewById(R.id.txtDescricaoRoteiro);
        txtCnpj = findViewById(R.id.txtCNPJGuia);

    }

}