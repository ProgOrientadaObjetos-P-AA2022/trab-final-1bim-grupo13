/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Constructora implements Serializable {

    private String nombreConstructora;
    private String idConstructora;

    public Constructora(String a, String s) {
        nombreConstructora = a;
        idConstructora = s;
    }

    public void establecerConstructora(String n) {
        nombreConstructora = n;
    }

    public void establecerID(String n) {
        idConstructora = n;
    }

    public String obtenerConstructora() {
        return nombreConstructora;
    }

    public String obtenerID() {
        return idConstructora;
    }

    @Override
    public String toString() {
        String cadena = String.format("Nombre de la Constructora: %s\nNombre del"
                + " ID de la Constructora %s\n",
                nombreConstructora,
                idConstructora);
        return cadena;
    }
}
