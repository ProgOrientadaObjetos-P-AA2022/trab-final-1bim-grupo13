/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

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
public class LecturaDepartamento {

    private String nomArchivo;
    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamentos;

    public LecturaDepartamento(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        File archivo = new File(nomArchivo);
        if (archivo.exists()) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(nomArchivo));
            } catch (Exception e) {
                System.out.println("A ocurrido un error al abrir el archivo" + e);
                throw new RuntimeException(e);
            }
        }
    }

    public void establecerNombreArchivo(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }

    public void establecerDepartamento() {
        this.departamentos = new ArrayList<>();
        File archivo = new File(nomArchivo);
        if (archivo.exists()) {
            while (true) {
                try {
                    Departamento historial = (Departamento) entrada.readObject();
                    departamentos.add(historial);
                } catch (EOFException endOfFileException) {
                    break;
                } catch (IOException ex) {
                    System.out.println("A ocurrido un error al leer el archivo");
                } catch (ClassNotFoundException ex) {
                    System.out.println("No se pudo crear el objeto" + ex);
                }
            }
        }
    }

    public String obtenerNombreArchivo() {
        return nomArchivo;
    }

    public ArrayList<Departamento> obtenerDepartamento() {
        return departamentos;
    }

    @Override
    public String toString() {
        String cadena = "******************\n"
                + "Listado De Departamentos Ingresados\n";
        for (int i = 0; i < departamentos.size(); i++) {
            Departamento d = departamentos.get(i);
            cadena = String.format("%s(Departamento Numero %d)\nInformacion "
                    + "Basica Del Departamento\nDatos Del Propietario Encontrado "
                    + "O Ingresado\nNombres: %s\nApellidos: %s\nIdentificacion: "
                    + "%s\nDatos Del Barrio Encontrado O Ingresado\nNombre Del "
                    + "Barrio Del Propietario: %s\nReferencia Para Hallar El "
                    + "Barrio %s\nDatos De La Ciudad Encontrada O Ingresada\n"
                    + "Nombre De La Ciudad: %s\nNombre De La Provincia: %s\n"
                    + "Datos De La Constructora Ingresados O Encontrados\n"
                    + "Nombre De La Constructora: %s\nID De La constructora: "
                    + "%s\nCaracteriticas De La Departamento\n"
                    + "Nombre Edificio: %s\nUbicación Edificio: %s\n"
                    + "Precio por metro cuadrado: %.2f Numero de metros cuadrados: %.2f\n"
                    + "Valor Alícuota Mensual: %.2f\nCosto final: %.2f\n",
                    cadena,
                    i + 1,
                    d.obtenerPropietario().obtenerNombre(),
                    d.obtenerPropietario().obtenerApellido(),
                    d.obtenerPropietario().obtenerIdentificacion(),
                    d.obtenerBarrio().obtenerNombre(),
                    d.obtenerBarrio().obtenerReferencia(),
                    d.obtenerCiudad().obtenerNombre(),
                    d.obtenerCiudad().obtenerProvincia(),
                    d.obtenerConstructora().obtenerNombreConstructora(),
                    d.obtenerConstructora().obtenerID(),
                    d.obtenerNombreEdificio(),
                    d.obtenerUbicacionDepartamento(),
                    d.obtenerPrecioMetro(),
                    d.obtenerNumeroMetros(),
                    d.obtenerAlicuotala(),
                    d.obtenerCostoFinal());

        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.out.println("A ocurrido un error al cerrar el archivo");
        }
    }

}
