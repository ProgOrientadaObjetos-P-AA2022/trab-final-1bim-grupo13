/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete04;

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
public class LecturaCiudad {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudades;
    private String nombreArchivo;

    public LecturaCiudad(String n) {
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

    public void establecerCiudades() {
        ciudades = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciudades.add(registro);
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

    public ArrayList<Ciudad> obtenerCiudades() {
        return ciudades;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "******************\n"
                + "Listado De Ciudades Ingresadas:\n";
        for (int i = 0; i < ciudades.size(); i++) {
            cadena = String.format("%s(Ciudad Numero %d)\n Nombre De La Ciudad: "
                    + "%s\nNombre De La Provincia: %s\n",
                    cadena,
                    i + 1,
                    ciudades.get(i).obtenerNombre(),
                    ciudades.get(i).obtenerProvincia());
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
