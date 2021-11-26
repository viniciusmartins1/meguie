package com.example.meguie;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.meguie.dao.BancoDeDados;
import com.example.meguie.design.RoteiroAdapter;
import com.example.meguie.model.Pagamento;
import com.example.meguie.model.Roteiro;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class checkout extends AppCompatActivity {

    TextView txtNome, txtInstagram, txtTituloRoteiro, txtCidadeRoteiro, txtPrecoRoteiro, txtDuracaoRoteiro, txtDescricaoRoteiro, txtCnpj;
    Button btnData;
    Button btnConfirmar;
    DatePickerDialog.OnDateSetListener setListener;


    private ListView lvPag;
    private List<Pagamento> listPag = new ArrayList<Pagamento>();
    private BancoDeDados mBancoDeDados;
    private Context mContext;
    AutoCompleteTextView autoPag;
    String a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        inicializarComponentes();

        popularListaPag();

        inicializandoValores();

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        checkout.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dayOfMonth + "/" + month + "/" + year;
                        btnData.setText(date);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        autoPag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                autoPag.showDropDown();

            }
        });

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a = autoPag.getText().toString();

                //Toast.makeText(this, "ID: "+ a, Toast.LENGTH_LONG).show();

            }
        });

    }

    private void inicializandoValores() {
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

        String idCliente = (String) intent.getStringExtra("idCliente");
        String nomeCliente = (String) intent.getStringExtra("nomeCliente");

        txtNome.setText(nome);
        txtInstagram.setText(instagram);
        txtCnpj.setText(cnpj);

        txtCidadeRoteiro.setText(cidadeRoteiro);
        txtPrecoRoteiro.setText("R$ " + precoRoteiro + ",00");
        txtDuracaoRoteiro.setText(duracaoRoteiro+ " Horas");
        txtTituloRoteiro.setText(tituloRoteiro);
        txtDescricaoRoteiro.setText(descricaoRoteiro);


        //Toast.makeText(this, "ID: "+ idCliente, Toast.LENGTH_LONG).show();
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
        btnData = findViewById(R.id.btndata);
        btnConfirmar = findViewById(R.id.btnconfirmar);
        autoPag = findViewById(R.id.autoPag);

    }

    private void popularListaPag() {

        mBancoDeDados = new BancoDeDados(this);
        listPag.clear();
        listPag = mBancoDeDados.allPagamentos();

        ArrayAdapter<Pagamento> pagAdapter = new ArrayAdapter<Pagamento>(this, android.R.layout.simple_dropdown_item_1line, listPag);

        autoPag.setAdapter(pagAdapter);

    }


}