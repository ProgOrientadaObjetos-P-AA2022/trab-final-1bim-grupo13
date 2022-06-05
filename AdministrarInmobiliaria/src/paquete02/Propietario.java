/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Propietario implements Serializable {

    private String nombrePropietario;
    private String apellidosPropietario;
    private String identificacion;

    public Propietario(String a, String s, String d) {
        nombrePropietario = a;
        apellidosPropietario = s;
        identificacion = d;
    }

    // Establecer ---------------------------------------------------->
    public void setNombre(String n) {
        nombrePropietario = n;
    }

    public void setApellidos(String n) {
        apellidosPropietario = n;
    }

    public void setIdentificacion(String n) {
        identificacion = n;
    }

    // Obtener ---------------------------------------------------->
    public String getNombre() {
        return nombrePropietario;
    }

    public String getApellido() {
        return apellidosPropietario;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    @Override
    public String toString() {

        String cadena = String.format("Nombre del Propietario: %s\nApellidos del"
                + " Propietario: %s\nIdentificacion del Propietario:",
                nombrePropietario,
                apellidosPropietario,
                identificacion);
        return cadena;

    }
}
