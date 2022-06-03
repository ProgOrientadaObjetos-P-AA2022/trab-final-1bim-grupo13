/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Barrio implements Serializable {
     private String nombreBarrio;
     private String nombreReferencia;

    public Barrio(String a, String b) {
        nombreBarrio = a;
        nombreReferencia = b;
    }

    public void establecerNombre(String n) {
        nombreBarrio = n;
    }

    public void establecerReferencia(String n) {
        nombreReferencia = n;
    }

    public String obtenerNombre() {
        return nombreBarrio;
    }

    public String obtenerReferencia() {
        return nombreReferencia;
    }
    
     @Override
    public String toString(){
        String cadena = String.format("Nombre del Barrio %s\nReferencia %s\n",
                nombreBarrio,
                nombreReferencia);
         return cadena;
    }
}
