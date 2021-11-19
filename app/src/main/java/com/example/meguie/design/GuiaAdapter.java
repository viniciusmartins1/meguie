package com.example.meguie.design;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.meguie.R;
import com.example.meguie.model.Guia;

import java.util.ArrayList;

public class GuiaAdapter extends ArrayAdapter<Guia> {

    private Context mContext;
    private int mResource;

    public GuiaAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Guia> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource,parent,false);

        ImageView imageView = convertView.findViewById(R.id.image);

        TextView textoNome = convertView.findViewById(R.id.textoNome);

        TextView textoDes = convertView.findViewById(R.id.textoDes);

        imageView.setImageResource(getItem(position).getImagem());

        textoNome.setText(getItem(position).getNome());

        //textoDes.setText(getItem(position).getIdGuia());

        return convertView;
    }
}
