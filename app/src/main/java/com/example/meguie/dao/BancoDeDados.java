package com.example.meguie.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.meguie.model.Guia;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados extends SQLiteOpenHelper {

    public static final String NOMEDB = "DBMG2";
    public static final String LOCALDB = "/data/data/com.example.meguie/databases/";
    public static final int VERSION = 1;
    private Context mContext;
    private SQLiteDatabase mSqLiteDatabase;


    public BancoDeDados(@Nullable Context context) {
        super(context, NOMEDB, null, VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void openDataBase(){
        String dbPath = mContext.getDatabasePath(NOMEDB).getPath();
        if(mSqLiteDatabase != null && mSqLiteDatabase.isOpen()){
            return;
        }
        mSqLiteDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDataBase() {
        if (mSqLiteDatabase != null){
            mSqLiteDatabase.close();
        }
    }

    public List<Guia> allGuia(){
        openDataBase();
        mSqLiteDatabase = this.getWritableDatabase();
        List<Guia> listGuia = new ArrayList<Guia>();
        String sql = "SELECT * FROM TB_GUIA";
        Cursor cursor = mSqLiteDatabase.rawQuery(sql, null);
        if (cursor.getCount() > 0){
            if (cursor.moveToFirst()){
                do {
                    Guia g = new Guia();
                    g.setIdGuia(cursor.getInt(0));
                    g.setNome(cursor.getString(1));
                    listGuia.add(g);
                }while (cursor.moveToNext());
            }
        }
        cursor.close();
        mSqLiteDatabase.close();
        return listGuia;
    }
}
