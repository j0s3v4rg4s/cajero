package com.colombia.iwite.cajero;

/**
 * Created by josevargas on 18/06/17.
 */

public class Producto {

    private String nombre;
    private double valor;
    private int cantidad;


    public Producto(String nombre, double valor, int cantidad) {
        this.nombre = nombre;
        this.valor = valor;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getValor() {
        return valor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public int addCantidad(){
        cantidad ++;
        return cantidad;
    }

    public int removeCantidad(){
        if(cantidad==0)
            return cantidad;
        else{
            cantidad --;
            return cantidad;
        }

    }

}
