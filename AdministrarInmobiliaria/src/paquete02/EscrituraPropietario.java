/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete01.LecturaArchivo;

/**
 *
 * @author DELL
 */
public class EscrituraPropietario {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Propietario registroPropietario;
    private ArrayList<Propietario> listaPropietarios;

    public EscrituraPropietario(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaPropietarios();
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (obtenerListaPropietarios().size() > 0) {
                for (int i = 0; i < obtenerListaPropietarios().size(); i++) {
                    establecerRegistroPropietario(obtenerListaPropietarios().get(i));
                    establecerSalidaPropietario();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistroPropietario(Propietario p) {
        registroPropietario = p;
    }

    public void establecerSalidaPropietario() {
        try {
            salida.writeObject(registroPropietario);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaPropietarios() {
        LecturaArchivo l = new LecturaArchivo(obtenerNombreArchivo());
        l.establecerListaPropietarios();
        listaPropietarios = l.obtenerListaPropietarios();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Propietario> obtenerListaPropietarios() {
        return listaPropietarios;
    }

    public ObjectOutputStream obtenerSalidaPropietario() {
        return salida;
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");

        }
    }
}
