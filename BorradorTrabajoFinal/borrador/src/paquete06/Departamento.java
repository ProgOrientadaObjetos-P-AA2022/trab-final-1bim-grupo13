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
public class Departamento implements Serializable {

    private Propietario propietario;
    private double precioMetro;
    private double numeroMetros;
    private double alicuotala;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private String nombreEdificio;
    private String ubicacionDepartamento;
    private Constructora constructora;

    public Departamento(Propietario prop, double precio, double numero,
            double alicuota, Barrio barr, Ciudad ciud, String nombreEdi, 
            String ubiDeparta, Constructora construc) {

        propietario = prop;
        precioMetro = precio;
        numeroMetros = numero;
        alicuotala = alicuota;
        barrio = barr;
        ciudad = ciud;
        nombreEdificio = nombreEdi;
        ubicacionDepartamento = ubiDeparta;
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

    public void establecerAlicuotala(double n) {

        alicuotala = n;
    }

    public void establecerBarrio(Barrio n) {

        barrio = n;
    }

    public void establecerCiudad(Ciudad n) {

        ciudad = n;
    }

    public void establecerNombreEdificio(String n) {

        nombreEdificio = n;
    }

    public void establecerUbicacionDepartamento(String n) {

        ubicacionDepartamento = n;
    }

    public void establecerConstructora(Constructora n) {

        constructora = n;
    }

    public void establecerCostoFinal() {
        /*El costo final es igual al
        (número de metros * valor del metro cuadrado) 
        + (valor alícuota mensual * 12).*/

        costoFinal = (numeroMetros * precioMetro) + (alicuotala * 12);
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

    public double obtenerAlicuotala() {

        return alicuotala;
    }

    public Barrio obtenerBarrio() {

        return barrio;
    }

    public Ciudad obtenerCiudad() {

        return ciudad;
    }

    public String obtenerNombreEdificio() {

        return nombreEdificio;
    }

    public String obtenerUbicacionDepartamento() {

        return ubicacionDepartamento;
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
                + "Metros cuadrado: %.2f\nNombre del edificio: %s\nUbicacion del "
                + "departamento en el edificio: %s\nValor de la alicuota mensual"
                + " :%.2f\nCosto final a depositar: %.2f\n", salto,
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
                nombreEdificio,
                ubicacionDepartamento,
                alicuotala,
                costoFinal);

        return cadena;
    }
}
