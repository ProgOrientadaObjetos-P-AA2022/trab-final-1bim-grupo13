/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete03;

/**
 *
 * @author reroes
 */
public class Barrio {
     private String barrio;
     private String referencia;

    public Barrio(String a, String b) {
        barrio = a;
        referencia = b;
    }

    public void establecerNombre(String n) {
        barrio = n;
    }

    public void establecerReferencia(String n) {
        referencia = n;
    }

    public String obtenerNombre() {
        return barrio;
    }

    public String obtenerReferencia() {
        return referencia;
    }
}
