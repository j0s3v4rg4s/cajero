package com.colombia.iwite.cajero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private GridView gridView;
    private AdaptadorProductos adaptadorProductos;
    private ArrayList<Producto> productos;
    private TextView total;
    private NumberFormat numberFormat;

    private double tot = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberFormat = NumberFormat.getCurrencyInstance();

        productos = new ArrayList<Producto>();
        gridView = (GridView) findViewById(R.id.miGrid);


        for (int i = 0; i< 10; i++)
            productos.add(new Producto("producto "+i,1000 + (int)(Math.random() * ((50000 - 1000) + 1)),0));

        adaptadorProductos = new AdaptadorProductos(productos,this);
        gridView.setAdapter(adaptadorProductos);

        total = (TextView) findViewById(R.id.total);
        total.setText( numberFormat.format(tot));


    }

    public void aumentarValor(double valor){
        tot += valor;
        total.setText( numberFormat.format(tot));
    }

    public void reducirValor(double valor){
        tot -= valor;
        total.setText( numberFormat.format(tot));
    }



    @Override
    public void onClick(View v) {

    }
}
