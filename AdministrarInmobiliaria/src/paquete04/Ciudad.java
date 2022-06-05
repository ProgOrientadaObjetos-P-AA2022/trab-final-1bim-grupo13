/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ciudad implements Serializable {

    private String nombreCiudad;
    private String nombreProvincia;

    public Ciudad(String a, String s) {
        nombreCiudad = a;
        nombreProvincia = s;
    }

    // Establecer ---------------------------------------------------->
    public void establecerNombre(String n) {
        nombreCiudad = n;
    }

    public void establecerProvincia(String n) {
        nombreProvincia = n;
    }

    // Obtener -------------------------------------------------------->
    public String obtenerNombre() {
        return nombreCiudad;
    }

    public String obtenerProvincia() {
        return nombreProvincia;
    }

    @Override
    public String toString() {
        String cadena = String.format("Nombre de la Ciudad: %s\nNombre de la"
                + " provincia: %s\n",
                nombreCiudad,
                nombreProvincia);
        return cadena;
    }
}
