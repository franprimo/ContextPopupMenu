package com.example.franprimo.contextpopupmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by FranPrimo on 15/11/15.
 */
public class MenuAdapter extends ArrayAdapter<String> {
    private Context context;
    private ArrayList<String> datos;

    public MenuAdapter(Context context, ArrayList<String> opcionesMenu) {
        super(context, 0, opcionesMenu);
        this.context = context;
        this.datos = opcionesMenu;

    }
    //Con este metolo cargo el listView
    public View getView (int position, android.view.View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_layout, parent, false);
            TextView texto = (TextView) convertView.findViewById(R.id.textView);

            texto.setText(datos.get(position));

        }
        return convertView;
    }
}