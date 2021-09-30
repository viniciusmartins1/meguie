package com.example.meguie.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClienteDAO {

    private Conexao conexao;
    private SQLiteDatabase banco;

    public ClienteDAO(Context context) {
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir(Cliente cliente) {

        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("email", cliente.getEmail());

        return banco.insert("cliente", null, values);
    }


}
