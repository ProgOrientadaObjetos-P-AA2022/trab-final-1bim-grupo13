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

    public void establecerPropietario(Propietario n) {

        propietario = n;
    }

    public void establecerPrecioMetro(double n) {

        precioMetro = n;
    }

    public void establecerNumeroMetros(double n) {

        numeroMetros = n;
    }

    public void establecerBarrio(Barrio n) {

        barrio = n;
    }

    public void establecerCiudad(Ciudad n) {

        ciudad = n;
    }

    public void establecerNumeroCuartos(int n) {

        numeroCuartos = n;
    }

    public void establecerConstructora(Constructora n) {

        constructora = n;
    }

    public void establecerCostoFinal() {

        costoFinal = numeroMetros * precioMetro;
    }

    // Obtener -------------------------------------------------------->>
    
    public Propietario obtenerPropietario() {

        return propietario;
    }

    public double obtenerPrecioMetro() {

        return precioMetro;
    }

    public double obtenerNumeroMetros() {

        return numeroMetros;
    }

    public Barrio obtenerBarrio() {

        return barrio;
    }

    public Ciudad obtenerCiudad() {

        return ciudad;
    }

    public int obtenerNumeroCuartos() {

        return numeroCuartos;
    }

    public Constructora obtenerConstructora() {

        return constructora;
    }

    public double obtenerCostoFinal() {

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
                propietario.obtenerNombre(),
                propietario.obtenerApellido(),
                propietario.obtenerIdentificacion(),
                barrio.obtenerNombre(),
                barrio.obtenerReferencia(),
                ciudad.obtenerNombre(),
                ciudad.obtenerProvincia(),
                constructora.obtenerNombreConstructora(),
                constructora.obtenerID(),
                precioMetro,
                numeroMetros,
                numeroCuartos,
                costoFinal);

        return cadena;
    }
}
