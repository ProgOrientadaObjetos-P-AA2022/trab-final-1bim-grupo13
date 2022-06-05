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

    // Establecer ----------------------------------------------------->
    public void setNombre(String n) {
        nombreBarrio = n;
    }

    public void setReferencia(String n) {
        nombreReferencia = n;
    }
    // Obtener --------------------------------------------------------->
    public String getNombre() {
        return nombreBarrio;
    }

    public String getReferencia() {
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
