/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

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
public class LecturaPropietario {

    private ObjectInputStream entrada;
    private ArrayList<Propietario> propietarios;
    private String nombreArchivo;

    public LecturaPropietario(String n) {
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

    public void establecerPropietarios() {
        propietarios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propietarios.add(registro);
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

    public ArrayList<Propietario> obtenerPropietarios() {
        return propietarios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "******************\n"
                + "Listado De Propitearios Ingresados:\n";
        for (int i = 0; i < propietarios.size(); i++) {
            cadena = String.format("%s(Propiteario Numero %d)\nNombres Del "
                    + "Propiteario: %s\nApellidos Del Propiteario: %s\n"
                    + "Identificacion Del Propiteario(Cedula): %s\n",
                    cadena,
                    i + 1,
                    propietarios.get(i).obtenerNombre(),
                    propietarios.get(i).obtenerApellido(),
                    propietarios.get(i).obtenerIdentificacion());
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
