package com.colombia.iwite.cajero;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by josevargas on 18/06/17.
 */

public class AdaptadorProductos extends BaseAdapter{

    private ArrayList<Producto> productos;
    private Context context;

    public AdaptadorProductos(ArrayList<Producto> productos, Context context) {
        this.productos = productos;
        this.context = context;
    }

    public void updateLista(ArrayList<Producto> newList){
        this.productos = newList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int position) {
        return productos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.card,parent,false);
        }

        TextView nombre = (TextView) convertView.findViewById(R.id.nombreProducto);
        TextView valor = (TextView) convertView.findViewById(R.id.precio);
        final TextView cantidad = (TextView) convertView.findViewById(R.id.contador);


        final Producto producto = productos.get(position);
        nombre.setText(producto.getNombre());
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        valor.setText(numberFormat.format(producto.getValor()));
        cantidad.setText("x"+producto.getCantidad());


        convertView.findViewById(R.id.mas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidad.setText("x"+ producto.addCantidad());
                ((MainActivity)context).aumentarValor(producto.getValor());
            }
        });

        convertView.findViewById(R.id.mennos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(producto.getCantidad()!= 0)
                    ((MainActivity)context).reducirValor(producto.getValor());
                int can = producto.removeCantidad();
                cantidad.setText("x"+ can);

            }
        });


        return convertView;
    }
}
