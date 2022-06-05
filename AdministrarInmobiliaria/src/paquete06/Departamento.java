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
    
    public void setPropietario(Propietario n) {

        propietario = n;
    }

    public void setPrecioMetro(double n) {

        precioMetro = n;
    }

    public void setNumeroMetros(double n) {

        numeroMetros = n;
    }

    public void setAlicuotala(double n) {

        alicuotala = n;
    }

    public void setBarrio(Barrio n) {

        barrio = n;
    }

    public void setCiudad(Ciudad n) {

        ciudad = n;
    }

    public void setNombreEdificio(String n) {

        nombreEdificio = n;
    }

    public void setUbicacionDepartamento(String n) {

        ubicacionDepartamento = n;
    }

    public void setConstructora(Constructora n) {

        constructora = n;
    }

    public void setCostoFinal() {
        /*El costo final es igual al
        (número de metros * valor del metro cuadrado) 
        + (valor alícuota mensual * 12).*/

        costoFinal = (numeroMetros * precioMetro) + (alicuotala * 12);
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

    public double getAlicuotala() {

        return alicuotala;
    }

    public Barrio getBarrio() {

        return barrio;
    }

    public Ciudad getCiudad() {

        return ciudad;
    }

    public String getNombreEdificio() {

        return nombreEdificio;
    }

    public String getUbicacionDepartamento() {

        return ubicacionDepartamento;
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
                + "Metros cuadrado: %.2f\nNombre del edificio: %s\nUbicacion del "
                + "departamento en el edificio: %s\nValor de la alicuota mensual"
                + " :%.2f\nCosto final a depositar: %.2f\n", salto,
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
                nombreEdificio,
                ubicacionDepartamento,
                alicuotala,
                costoFinal);

        return cadena;
    }
}
