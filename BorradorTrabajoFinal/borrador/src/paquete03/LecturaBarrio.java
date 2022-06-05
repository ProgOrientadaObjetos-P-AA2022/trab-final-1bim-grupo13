/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Usuario iTC
 */
public class LecturaBarrio {

    private ObjectInputStream entrada;
    private ArrayList<Barrio> barrios;
    private String nombreArchivo;

    public LecturaBarrio(String n) {
        nombreArchivo = n;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } catch (IOException ioException) {
                System.out.println("Error al abrir el archivo" + ioException);
            }
        }
    }

    public void establecerBarrios() {
        barrios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    barrios.add(registro);
                } catch (EOFException endOfFileException) {
                    break;
                } catch (IOException ex) {
                    System.out.println("Error al leer el archivo");
                } catch (ClassNotFoundException ex) {
                    System.out.println("No se pudo crear el objeto" + ex);
                }
            }
        }

    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public ArrayList<Barrio> obtenerBarrios() {
        return barrios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "******************\n"
                + "Listado De Barrios Ingresados:\n";
        for (int i = 0; i < barrios.size(); i++) {
            cadena = String.format("%s(Barrio Numero %d)\nNombre Del Barrio: "
                    + "%s\nReferencia Para Encontrar El Barrio: %s\n",
                    cadena,
                    i + 1,
                    barrios.get(i).obtenerNombre(),
                    barrios.get(i).obtenerReferencia());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.out.println("Error al cerrar el archivo");
        }
    }
}
