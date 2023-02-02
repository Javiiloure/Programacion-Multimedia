package com.example.agenda;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {

    private Context context;
    private ArrayList<Contacto> listItems;

    public Adaptador(Context context, ArrayList<Contacto> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item, null);

        ImageView imgFoto = convertView.findViewById(R.id.icono);
        TextView apodo = convertView.findViewById(R.id.apodo);
        TextView numero = convertView.findViewById(R.id.numero);

        Contacto contacto = (Contacto) getItem(position);

        imgFoto.setImageResource(R.drawable.contacto);
        apodo.setText(contacto.getApodo());
        numero.setText(String.valueOf(contacto.getTelefono()));

        return convertView;
    }
}
