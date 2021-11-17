package com.example.meguie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.meguie.dao.BancoDeDados;

public class MainActivity extends AppCompatActivity {

    Button btnTrocar, btnLogin;
    EditText editEmail, editSenha;
    BancoDeDados DB = new BancoDeDados(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intentCadastro = new Intent(this, cadastro.class);

        inicializarComponentes();
        mudarTelaCadastro(intentCadastro);
        fazerLogin();


    }

    private void mudarTelaCadastro(Intent intent) {
        btnTrocar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
    private void fazerLogin() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getText().toString();
                String senha = editSenha.getText().toString();

                if (email.equals("")|| senha.equals("")){
                    Toast.makeText(MainActivity.this,"Preencha todos os campos", Toast.LENGTH_LONG).show();
                } else {
                    boolean checkLogin = DB.checkEmailSenha(email,senha);
                    if (checkLogin){
                        Toast.makeText(MainActivity.this,"Login feito com sucesso", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), guias.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this,"Email ou senha inválidos", Toast.LENGTH_LONG).show();
                    }
                }

                //startActivity(intent);
            }
        });
    }

    private void inicializarComponentes() {
        btnTrocar = findViewById(R.id.btnTrocar);
        btnLogin = findViewById(R.id.btnLogin);
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
    }

}