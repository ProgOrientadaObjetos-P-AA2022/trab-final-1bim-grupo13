/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
import paquete06.Casa;
import paquete06.Departamento;

/**
 *
 * @author Usuario iTC
 */
public class LecturaArchivo {

    private ObjectInputStream entrada;
    private ArrayList<Casa> casas;
    private ArrayList<Departamento> departamentos;
    private ArrayList<Propietario> propietarios;
    private ArrayList<Barrio> barrios;
    private ArrayList<Ciudad> ciudades;
    private ArrayList<Constructora> constructoras;
    private String nombreArchivo;



    public LecturaArchivo(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaCasas() {

        casas = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casas.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public void establecerListaDepartamentos() {
        // 
        departamentos = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    departamentos.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public void establecerListaPropietarios() {
        propietarios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propietarios.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public void establecerListaBarrios() {
        // 
        barrios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            while (true) {
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    barrios.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public void establecerListaCiudades() {
        // 
        ciudades = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciudades.add(registro);
                } catch (EOFException endOfFileException) {
                    return;

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public void establecerListaConstructoras() {
        // 
        constructoras = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    constructoras.add(registro);
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    break;
                }
            }
        }

    }

    public ArrayList<Casa> obtenerListaCasas() {
        return casas;
    }

    public ArrayList<Departamento> obtenerListaDepartamento() {
        return departamentos;
    }

    public ArrayList<Propietario> obtenerListaPropietarios() {
        return propietarios;
    }

    public ArrayList<Barrio> obtenerListaBarrios() {
        return barrios;
    }

    public ArrayList<Ciudad> obtenerListaCiudades() {
        return ciudades;
    }

    public ArrayList<Constructora> obtenerListaConstructoras() {
        return constructoras;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }

    

    // -----------------------------------------------------------------------
    public String MostrarEnPantallaPropietarios() {
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

    public String MostrarEnPantallaBarrios() {
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

    public String MostrarEnPantallaCiudades() {
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

    public String MostrarEnPantallaConstructoras() {
        String cadena = "******************\n"
                + "Listado De Constructoras Ingresadas:\n";
        for (int i = 0; i < constructoras.size(); i++) {
            cadena = String.format("%s(Constructora Numero %d)\nNombre De La "
                    + "Constructora: %s\n Id De La Constructora %s\n",
                    cadena,
                    i + 1,
                    constructoras.get(i).obtenerNombreConstructora(),
                    constructoras.get(i).obtenerID());
        }
        return cadena;
    }

    public String MostrarEnPantallaCasas() {
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
                    + "Nombre De La Constructora: \nID De La constructora: "
                    + "%s\nCaracteristicas De La Casa\nPrecio Del Metro Cuadrado:"
                    + " %.2f\nNumero De Metros Cuadrados: %.2f\nNumero De "
                    + "Cuartos: %d\nCosto final: %.2f\n"      , 
                    cadena, 
                    (i + 1),
<<<<<<< HEAD
                    c.obtenerPropietario().obtenerNombre(),
                    c.obtenerPropietario().obtenerApellido(), 
                    c.obtenerPropietario().obtenerIdentificacion(),
                    c.obtenerBarrio().obtenerNombre(),
                    c.obtenerBarrio().obtenerReferencia(),                   
                    c.obtenerCiudad().obtenerNombre(),
                    c.obtenerCiudad().obtenerProvincia(),                   
                   
                    c.obtenerConstructora().obtenerID(),
                    c.obtenerPrecioMetro(), 
                    c.obtenerNumeroMetros(), 
                    c.obtenerNumeroCuartos(), 
                    c.obtenerCostoFinal());                                     
=======
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
>>>>>>> e2889d12b500fe706581cdf03e90ca4b5cc3d054

        }
        return cadena;
    }

    public String MostrarEnPantallaDepartamentos() {
        String cadena = "******************\n"
                + "Listado De Departamentos Ingresados\n";
        for (int i = 0; i < departamentos.size(); i++) {
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
                    departamentos.get(i).obtenerPropietario().obtenerNombre(), 
                    departamentos.get(i).obtenerPropietario().obtenerApellido(), 
                    departamentos.get(i).obtenerPropietario().obtenerIdentificacion(),     
                    departamentos.get(i).obtenerBarrio().obtenerNombre(),
                    departamentos.get(i).obtenerBarrio().obtenerReferencia(),
                    departamentos.get(i).obtenerCiudad().obtenerNombre(), 
                    departamentos.get(i).obtenerCiudad().obtenerProvincia(),
                    departamentos.get(i).obtenerConstructora().obtenerNombreConstructora(), 
                    departamentos.get(i).obtenerConstructora().obtenerID(),                   
                    departamentos.get(i).obtenerNombreEdificio(), 
                    departamentos.get(i).obtenerUbicacionDepartamento(),
                    departamentos.get(i).obtenerPrecioMetro(), 
                    departamentos.get(i).obtenerNumeroMetros(),
                    departamentos.get(i).obtenerAlicuotala(), 
                    departamentos.get(i).obtenerCostoFinal());



        }
        return cadena;
    }

}
