/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 *
 * @author DELL
 */
public class EscrituraBarrio {
       private String nombreArchivo;
    private ObjectOutputStream salida;
    private Barrio registroBarrio;
    private ArrayList<Barrio> listaBarrios;

    public EscrituraBarrio(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaBarrios();
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            if (obtenerListaBarrios().size() > 0) {
                for (int i = 0; i < obtenerListaBarrios().size(); i++) {
                    establecerRegistroBarrio(obtenerListaBarrios().get(i));
                    establecerSalidaBarrio();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerRegistroBarrio(Barrio p) {
        registroBarrio = p;
    }

    public void establecerSalidaBarrio() {
        try {
            salida.writeObject(registroBarrio);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    public void establecerListaBarrios() {
        LecturaBarrio l = new LecturaBarrio(obtenerNombreArchivo());
        l.establecerBarrios();
        listaBarrios = l.obtenerBarrios();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Barrio> obtenerListaBarrios() {
        return listaBarrios;
    }

    public ObjectOutputStream obtenerSalidaBarrio() {
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
