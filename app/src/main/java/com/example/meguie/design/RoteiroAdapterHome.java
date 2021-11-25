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
import com.example.meguie.model.Roteiro;

import java.util.ArrayList;

public class RoteiroAdapterHome extends ArrayAdapter<Roteiro> {

    private Context mContext;
    private int mResource;

    public RoteiroAdapterHome(@NonNull Context context, int resource, @NonNull ArrayList<Roteiro> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView = layoutInflater.inflate(mResource,parent,false);

        ImageView imageView = convertView.findViewById(R.id.imagemRoteiroHome);

        TextView txtDescricaoHome = convertView.findViewById(R.id.DescricaoHome);

        TextView txtTituloRoteiroHome = convertView.findViewById(R.id.txtTituloHome);

        imageView.setImageResource(R.mipmap.farol_santander_foreground);

        txtDescricaoHome.setText(getItem(position).getDescricao());

        txtTituloRoteiroHome.setText(getItem(position).getTitulo());

        return convertView;
    }

}
