package com.example.meguie;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meguie.dao.BancoDeDados;
import com.example.meguie.model.Guia;

import java.time.temporal.TemporalUnit;


public class cadastro extends AppCompatActivity {

    private EditText editNome, editEmail, editSenha, editCPF, editTel;
    private Button btnCadastrar;
    BancoDeDados DB = new BancoDeDados(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        InicializarComponentes();
        Cadastrar();


    }

    private void Cadastrar() {
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = editNome.getText().toString();
                String senha = editSenha.getText().toString();
                String email = editEmail.getText().toString();
                String cpf = editCPF.getText().toString();
                String telefone = editTel.getText().toString();

                if (nome.equals("") || senha.equals("") || email.equals("") || cpf.equals("") || telefone.equals("")){
                    Toast.makeText(cadastro.this,"Preencha todos os campos!", Toast.LENGTH_LONG).show();

                } else {

                    Boolean insert = DB.salvarDadosCliente(nome,email,senha,cpf,telefone);
                    if (insert==true){
                        Toast.makeText(cadastro.this,"Cadastrado com sucesso", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),guias.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(cadastro.this,"Cadastro falhou", Toast.LENGTH_LONG).show();
                    }
/*                    Boolean checkemail = DB.checkEmail(email);
                    if (checkemail==false){

                    } else {
                        Toast.makeText(cadastro.this,"Email já cadastrado", Toast.LENGTH_LONG).show();
                    }*/

                }
            }
        });
    }

    private void InicializarComponentes() {
        editNome = findViewById(R.id.editTextNome);
        editEmail = findViewById(R.id.editTextEmail);
        editSenha = findViewById(R.id.editTextSenha);
        editCPF = findViewById(R.id.editTextCpf);
        editTel = findViewById(R.id.editTextTelefone);

        btnCadastrar = findViewById(R.id.btnCadastrar);
    }
}