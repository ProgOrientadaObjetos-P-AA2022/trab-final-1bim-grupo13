/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete06;

import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

/**
 *
 * @author reroes
 */
public class Casa implements Serializable {

    private Propietario propietario;
    private double precioMetro;
    private double numeroMetros;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private int numeroCuartos;
    private Constructora constructora;

    public Casa(Propietario prop, double precio, double numero, Barrio barr,
            Ciudad ciud, int cuartos, Constructora construc) {

        propietario = prop;
        precioMetro = precio;
        numeroMetros = numero;
        barrio = barr;
        ciudad = ciud;
        numeroCuartos = cuartos;
        constructora = construc;

    }
    // Establecer -------------------------------------------------------->>

    public void setPropietario(Propietario n) {

        propietario = n;
    }

    public void setPrecioMetro(double n) {

        precioMetro = n;
    }

    public void setNumeroMetros(double n) {

        numeroMetros = n;
    }

    public void setBarrio(Barrio n) {

        barrio = n;
    }

    public void setCiudad(Ciudad n) {

        ciudad = n;
    }

    public void setNumeroCuartos(int n) {

        numeroCuartos = n;
    }

    public void setConstructora(Constructora n) {

        constructora = n;
    }

    public void setCostoFinal() {

        costoFinal = numeroMetros * precioMetro;
    }

    // Obtener -------------------------------------------------------->>
    
    public Propietario getPropietario() {

        return propietario;
    }

    public double getPrecioMetro() {

        return precioMetro;
    }

    public double getNumeroMetros() {

        return numeroMetros;
    }

    public Barrio getBarrio() {

        return barrio;
    }

    public Ciudad getCiudad() {

        return ciudad;
    }

    public int getNumeroCuartos() {

        return numeroCuartos;
    }

    public Constructora getConstructora() {

        return constructora;
    }

    public double getCostoFinal() {

        return costoFinal;
    }

    @Override
    public String toString() {
        String salto = "--------------------------------------------------";
        String cadena = String.format("%s\n-REGISTRO-\n\nDatos del Propietario:\n"
                + "Nombres del propietario: %s\nApellidos del Propietario: %s\n"
                + "Identificacion del propietario: %s\n\nDatos del Barrio:\n"
                + "Nombre del Barrio: %s\nReferencia del Barrio: %s\n\nDatos de"
                + " la ciudad:\nNombre de la ciudad: %s\nNombre de la provincia:"
                + " %s\n\nDatos de la Constructora:\nNombre de la constructora:"
                + " %s\nNombre del ID de la constructor: %s\n\nValores acerca "
                + "de la vivienda:\nPrecio del Metro cuadrado: %.2f\nNumero de "
                + "Metros cuadrado: %.2f\nNumero de cuartos: %d\nCosto final a "
                + "depositar: %.2f\n", salto,
                propietario.getNombre(),
                propietario.getApellido(),
                propietario.getIdentificacion(),
                barrio.getNombre(),
                barrio.getReferencia(),
                ciudad.getNombre(),
                ciudad.getProvincia(),
                constructora.getNombreConstructora(),
                constructora.getID(),
                precioMetro,
                numeroMetros,
                numeroCuartos,
                costoFinal);

        return cadena;
    }
}
