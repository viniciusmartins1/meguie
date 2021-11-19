package com.example.meguie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.meguie.dao.BancoDeDados;
import com.example.meguie.design.GuiaAdapter;
import com.example.meguie.model.Guia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class guias extends AppCompatActivity {

    private BancoDeDados mBancoDeDados;
    private ListView lvGuia;
    private List<Guia> listGuia = new ArrayList<Guia>();
    private ArrayAdapter<Guia> arrayAdapterGuia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guias);

        inicializarComponentes();
        //inicializarBancoDeDados();

        popularLista();
    }

    private void inicializarComponentes() {
        lvGuia = (ListView) findViewById(R.id.lvGuia);
    }

    private void popularLista() {
        mBancoDeDados = new BancoDeDados(this);
        listGuia.clear();
        listGuia = mBancoDeDados.allGuia();

        ArrayList<Guia> arrayList = new ArrayList<>();

        for (Guia guia : listGuia){
            arrayList.add(new Guia(R.mipmap.user, guia.getNome()));
        }

        GuiaAdapter guiaAdapter = new GuiaAdapter(this,R.layout.list_roll,arrayList);

        lvGuia.setAdapter(guiaAdapter);

/*        arrayAdapterGuia = new ArrayAdapter<Guia>(this, android.R.layout.simple_list_item_1, listGuia);
        lvGuia.setAdapter(arrayAdapterGuia);*/
    }

/*    private void inicializarBancoDeDados() {
        mBancoDeDados = new BancoDeDados(this);

        File database = getApplicationContext().getDatabasePath(BancoDeDados.NOMEDB);
        if (database.exists() == false){
            mBancoDeDados.getReadableDatabase();
            if (copiaBanco(this)){
                alert("Banco copiado com sucesso!");
            } else {
                alert("Erro ao copiar o banco de dados");
            }
        }
    }*/

/*    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }*/


    /*private boolean copiaBanco(Context context) {
        try {
            InputStream inputStream = context.getAssets().open(BancoDeDados.NOMEDB);
            String outFile = BancoDeDados.LOCALDB + BancoDeDados.NOMEDB;
            OutputStream outputStream = new FileOutputStream(outFile);

            byte[] buff = new byte[1024];
            int length = 0;

            while ((length = inputStream.read(buff)) > 0){
                outputStream.write(buff, 0 , length);
            }
            outputStream.flush();
            outputStream.close();
            return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }*/
}