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
public class LecturaCasa {

    private ArrayList<Casa> casas;
    private ObjectInputStream entarda;
    private String nomArchivo;

    public LecturaCasa(String nomArchivo) {
        this.nomArchivo = nomArchivo;
        File archivo = new File(nomArchivo);
        if (archivo.exists()) {
            try {
                entarda = new ObjectInputStream(new FileInputStream(nomArchivo));
            } catch (Exception e) {
                System.out.println("A ocurrido un error al abrir el archivo" + e);
                throw new RuntimeException(e);
            }
        }
    }

    public void establecerCasa() {
        this.casas = new ArrayList<>();
        File archivo = new File(nomArchivo);
        if (archivo.exists()) {
            while (true) {
                try {
                    Casa historial = (Casa) entarda.readObject();
                    casas.add(historial);
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

    public void establecerNombreArchivo(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }

    public ArrayList<Casa> obtenerCasa() {
        return casas;
    }

    public String obtenerNombreArchivo() {
        return nomArchivo;
    }

    @Override
    public String toString() {
        String cadena = "******************\n"
                + "Listado De Casas Ingresadas\n";
        for (int i = 0; i < casas.size(); i++) {
            Casa casa = casas.get(i);
            cadena = String.format("%sCasa Numero %d\nInformacion Basica De"
                    + "La Casa:\nDatos Del Propietario Encontrado O Ingresado\n"
                    + "Nombres: %s\nApellidos: %s\nIdentificacion: %s\n"
                    + "Datos Del Barrio Encontrado O Ingresado\nNombre Del "
                    + "Barrio Del Propietario: %s\nReferencia Para Hallar El "
                    + "Barrio %s\nDatos De La Ciudad Encontrada O Ingresada\n"
                    + "Nombre De La Ciudad: %s\nNombre De La Provincia: %s\n"
                    + "Datos De La Constructora Ingresados O Encontrados\n"
                    + "Nombre De La Constructora: %s\nID De La constructora: "
                    + "%s\nCaracteriticas De La Casa\nPrecio Del Metro Cuadrado:"
                    + " %.2f\nNumero De Metros Cuadrados: %.2f\nNumero De "
                    + "Cuartos: %d\nCosto final: %.2f\n",
                    cadena,
                    (i + 1),
                    casa.obtenerPropietario().obtenerNombre(),
                    casa.obtenerPropietario().obtenerApellido(),
                    casa.obtenerPropietario().obtenerIdentificacion(),
                    casa.obtenerBarrio().obtenerNombre(),
                    casa.obtenerBarrio().obtenerReferencia(),
                    casa.obtenerCiudad().obtenerNombre(),
                    casa.obtenerCiudad().obtenerProvincia(),
                    casa.obtenerConstructora().obtenerNombreConstructora(),
                    casa.obtenerConstructora().obtenerID(),
                    casa.obtenerPrecioMetro(),
                    casa.obtenerNumeroMetros(),
                    casa.obtenerNumeroCuartos(),
                    casa.obtenerCostoFinal());

        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entarda != null) {
                entarda.close();
            }
        } catch (Exception e) {
            System.out.println("A ocurrido un error al cerrar el archivo");
            throw new RuntimeException(e);
        }
    }

}
