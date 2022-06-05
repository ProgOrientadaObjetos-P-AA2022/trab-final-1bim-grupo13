/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.util.Scanner;
import paquete02.EscrituraPropietario;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete03.EscrituraBarrio;
import paquete04.Ciudad;
import paquete04.EscrituraCiudad;
import paquete05.Constructora;
import paquete05.EscrituraConstructora;
import paquete06.Casa;
import paquete06.Departamento;
import paquete06.EscrituraCasa;
import paquete06.EscrituraDepartamento;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {

        boolean bandera = true;
        int opcion;
        int opcionElegida;

        do {
            opcion = interfaz();
            if (opcion == 1) {
                opcionElegida = menuDeIngresoDeDatos();
                switch (opcionElegida) {
                    case 1:
                        ingresarPropietario();
                        break;
                    case 2:
                        ingresarBarrio();
                        break;
                    case 3:
                        ingresarCiudad();
                        break;
                    case 4:
                        ingresarConstructora();
                        break;
                    case 5:
                        ingresarCasa();
                        break;
                    case 6:
                        ingresarDepartamento();
                        break;
                    case 0:
                        break;
                }
            } else {
                if (opcion == 2) {
                    opcionElegida = menuDeListaDeArchivos();
                    crearListaDeDatos(opcionElegida);
                } else {
                    if (opcion == 3) {

                        bandera = false;
                    }

                }

            }

        } while (bandera);
    }

    // Menus -------------------------------------------------------------------
    public static int interfaz() {
        Scanner entry = new Scanner(System.in);
        System.out.println("Ingrese 1 para el ingreso de Datos");
        System.out.println("Ingrese 2 para mostrar la lista de Datos");
        System.out.println("Ingrese 3 para salir del programa");

        int opcion = entry.nextInt();

        if (opcion < 1 || opcion > 3) {
            do {
                System.out.println("El valor esta fuera de los parametros, "
                        + "ingrese otro valor");
                opcion = entry.nextInt();
            } while (opcion < 0 || opcion > 2);
        }
        return opcion;
    }

    public static int menuDeIngresoDeDatos() {
        Scanner entry = new Scanner(System.in);
        System.out.println("Ingrese 1 para ingresar un nuevo propietario");
        System.out.println("Ingrese 2 para ingresar un nuevo barrio");
        System.out.println("Ingrese 3 para ingresar una nueva ciudad");
        System.out.println("Ingrese 4 para ingresar una nueva constructora");
        System.out.println("Ingrese 5 para ingresar una nueva casa");
        System.out.println("Ingrese 6 para ingresar un nuevo departamento");
        System.out.println("Ingrese 0 para volver al menu principal");
        int opcion = entry.nextInt();

        if (opcion < 0 || opcion > 6) {
            do {
                System.out.println("El valor esta fuera de los parametros, "
                        + "ingrese otro valor");
                opcion = entry.nextInt();
            } while (opcion < 1 || opcion > 7);
        }
        return opcion;
    }

    public static int menuDeListaDeArchivos() {
        Scanner entry = new Scanner(System.in);
        System.out.println("Ingrese 1 para ver la Lista de propietarios");
        System.out.println("Ingrese 2 para ver la lista de barrios");
        System.out.println("Ingrese 3 para ver la lista de ciudades");
        System.out.println("Ingrese 4 para ver la lista de constructoras");
        System.out.println("Ingrese 5 para ver la lista de casas");
        System.out.println("Ingrese 6 para ver la lista de departamentos");
        System.out.println("Ingrese 0 para volver al menu principal");
        int opcion = entry.nextInt();

        if (opcion < 0 || opcion > 6) {
            do {
                System.out.println("El valor esta fuera de los parametros, "
                        + "ingrese otro valor");
                opcion = entry.nextInt();
            } while (opcion < 0 || opcion > 6);
        }
        return opcion;
    }
    // Menus ------------------------------------------------------------------
    // Ingreso De Datos -----------------------------------------------------

    public static void ingresarPropietario() {
        Scanner entry = new Scanner(System.in);
        Propietario prop;
        System.out.println("Ingrese los nombres del propietario");
        String nombrePropietario = entry.nextLine();
        System.out.println("Ingrese los apellidos del propietario");
        String apellidosPropietario = entry.nextLine();
        System.out.println("Ingrese la identificacion del propietario");
        String identificacion = entry.nextLine();
        prop = new Propietario(nombrePropietario,
                apellidosPropietario,
                identificacion);
        EscrituraPropietario a1 = new EscrituraPropietario("propietarios.dat");
        a1.establecerRegistroPropietario(prop);
        a1.establecerSalidaPropietario();
    }

    public static void ingresarBarrio() {
        Scanner entry = new Scanner(System.in);
        Barrio barr;
        System.out.println("Ingrese el nombre del Barrio");
        String nombreBarrio = entry.nextLine();
        System.out.println("Ingrese una Referencia para hallar el "
                + "barrio");
        String referencia = entry.nextLine();
        barr = new Barrio(nombreBarrio, referencia);
        System.out.println(barr);
        EscrituraBarrio a2 = new EscrituraBarrio("barrios.dat");
        a2.establecerRegistroBarrio(barr);
        a2.establecerSalidaBarrio();
    }

    public static void ingresarCiudad() {
        Scanner entry = new Scanner(System.in);
        Ciudad ciud;
        System.out.println("Ingrese el nombre de la ciudad");
        String nombreCiudad = entry.nextLine();
        System.out.println("Ingrese el nombre de la provincia");
        String nombreProvincia = entry.nextLine();

        ciud = new Ciudad(nombreCiudad, nombreProvincia);
        EscrituraCiudad a3 = new EscrituraCiudad("ciudades.dat");
        System.out.println(ciud);
        a3.establecerRegistroCiudad(ciud);
        a3.establecerSalidaCiudad();
    }

    public static void ingresarConstructora() {
        Scanner entry = new Scanner(System.in);
        Constructora construc;
        System.out.println("Ingrese el nombre de la constructora");
        String nombreConstructora = entry.nextLine();
        System.out.println("Ingrese el ID de la constructora");
        String idConstructora = entry.nextLine();

        construc = new Constructora(nombreConstructora, idConstructora);
        System.out.println(construc);
        EscrituraConstructora a4 = new EscrituraConstructora("constructoras.dat");
        a4.establecerRegistroConstructora(construc);
        a4.establecerSalidaConstructora();
    }

    public static void ingresarCasa() {
        Scanner entry = new Scanner(System.in);
        Propietario prop;
        Barrio barr;
        Ciudad ciud;
        prop = buscadorPropietario();
        barr = buscadorBarrio();
        ciud = buscadorCiudad();
        Constructora construc;
        construc = buscadorConstructora();
        System.out.println("Ingrese el valor del precio del metro "
                + "cuadrado");
        double precioMetro = entry.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados");
        double numeroMetros = entry.nextDouble();
        System.out.println("Ingrese el numero de cuartos");
        int numeroCuartos = entry.nextInt();
        Casa casa = new Casa(prop, precioMetro, numeroMetros, barr,
                ciud, numeroCuartos, construc);
        casa.establecerCostoFinal();
        EscrituraCasa a5 = new EscrituraCasa("casas.dat");
        a5.establecerRegistroCasa(casa);
        a5.establecerSalidaCasa();

    }

    public static void ingresarDepartamento() {
        Scanner entry = new Scanner(System.in);
        Propietario prop;
        Barrio barr;
        Ciudad ciud;
        prop = buscadorPropietario();
        barr = buscadorBarrio();
        ciud = buscadorCiudad();
        Constructora construc;
        construc = buscadorConstructora();
        System.out.println("Ingrese el valor del precio del metro "
                + "cuadrado");
        double precioMetro = entry.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados");
        double numeroMetros = entry.nextDouble();
        System.out.println("Ingrese el valor de la alicuota");
        double alicuota = entry.nextDouble();
        entry.nextLine();
        System.out.println("Ingrese el nombre del edificio: ");
        String nombreEdificio = entry.nextLine();
        System.out.println("Ingrese la ubicacion del edificio: ");
        String ubiEdificio = entry.nextLine();
        Departamento departamento = new Departamento(prop, precioMetro,
                numeroMetros, alicuota, barr, ciud, nombreEdificio,
                ubiEdificio, construc);
        departamento.establecerCostoFinal();
        EscrituraDepartamento a6 = new EscrituraDepartamento("departamentos.dat");
        a6.establecerRegistroDepartamento(departamento);
        a6.establecerSalidaDepartamento();
    }
    // Ingreso De Datos -----------------------------------------------------
    // Lista De Datos ----------------------------------------------------------

    public static void crearListaDeDatos(int opcion) {
        switch (opcion) {
            case 1:
                LecturaArchivo l1 = new LecturaArchivo("propietarios.dat");
                l1.establecerListaPropietarios();
                System.out.printf("%s", l1.MostrarEnPantallaPropietarios());
                l1.cerrarArchivo();
                break;

            case 2:
                LecturaArchivo l2 = new LecturaArchivo("barrios.dat");
                l2.establecerListaBarrios();
                System.out.printf("%s", l2.MostrarEnPantallaBarrios());
                l2.cerrarArchivo();
                break;

            case 3:
                LecturaArchivo l3 = new LecturaArchivo("ciudades.dat");
                l3.establecerListaCiudades();
                System.out.printf("%s", l3.MostrarEnPantallaCiudades());
                l3.cerrarArchivo();
                break;
            case 4:
                LecturaArchivo l4 = new LecturaArchivo("constructoras.dat");
                l4.establecerListaConstructoras();
                System.out.printf("%s", l4.MostrarEnPantallaConstructoras());
                l4.cerrarArchivo();
                break;

            case 5:
                LecturaArchivo l5 = new LecturaArchivo("casas.dat");
                l5.establecerListaCasas();
                System.out.printf("%s", l5.MostrarEnPantallaCasas());
                l5.cerrarArchivo();
                break;

            case 6:
                LecturaArchivo l6 = new LecturaArchivo("departamentos.dat");
                l6.establecerListaDepartamentos();
                System.out.printf("%s", l6.MostrarEnPantallaDepartamentos());
                l6.cerrarArchivo();
                break;

        }
    }
    // Lista De Datos --------------------------------------------------------
    // Buscador de archivos -------------------------------------------------

    public static Propietario buscadorPropietario() {
        Scanner entry = new Scanner(System.in);
        boolean bandera = true;
        String identificacion;
        String nombres;
        String apellidos;
        String nombreArchivo = "propietarios.dat";

        do {
            System.out.println("Ingrese La Identifiacion Del Propietario(Cedula)");
            identificacion = entry.nextLine();
            Propietario propietarioBuscar;
            Buscar b = new Buscar(nombreArchivo);
            b.establecerIdentificador(identificacion);
            b.establecerPropietarioBuscado();
            propietarioBuscar = b.obtenerPropietarioBuscado();

            if (propietarioBuscar != null) {
                System.out.printf("Propietario encontrado\n%s\n", propietarioBuscar);
                bandera = false;
                return propietarioBuscar;
            } else {
                System.out.println("Propietario no encontrado si desea ingresar un "
                        + "nuevo propietario ingrese si, caso contrario ingrese "
                        + "cualquier otra letra para continuar buscando");
                String salida = entry.nextLine();

                if (salida.equals("si") || salida.equals("Si") || salida.equals("SI")) {

                    System.out.println("Ingrese nombres del propietario");
                    nombres = entry.nextLine();
                    System.out.println("Ingrese apellidos del propietario");
                    apellidos = entry.nextLine();
                    System.out.println("Ingrese identificacion del propietario");
                    identificacion = entry.nextLine();
                    Propietario prop = new Propietario(nombres, apellidos, identificacion);
                    EscrituraPropietario archivo = new EscrituraPropietario(nombreArchivo);
                    archivo.establecerRegistroPropietario(prop);
                    archivo.establecerSalidaPropietario();
                    propietarioBuscar = prop;
                    return propietarioBuscar;
                }
            }
        } while (bandera);
        return null;
    }

    public static Barrio buscadorBarrio() {
        Scanner entry = new Scanner(System.in);
        boolean bandera = true;
        String nombreBarrio;
        String referencia;
        String nombreArchivo = "barrios.dat";

        do {
            System.out.println("Ingrese El Nombre Del Barrio Del Propietario");
            nombreBarrio = entry.nextLine();
            Barrio barrioBuscar;
            Buscar b = new Buscar(nombreArchivo);
            b.establecerIdentificador(nombreBarrio);
            b.establecerBarrioBuscado();
            barrioBuscar = b.obtenerBarrioBuscado();
            if (barrioBuscar != null) {
                System.out.printf("Barrio encontrado\n%s\n", barrioBuscar);
                bandera = false;
                return barrioBuscar;
            } else {
                System.out.println("Barrio no encontrado si desea ingresar un "
                        + "nuevo Barrio ingrese si, caso contrario ingrese "
                        + "cualquier otra letra para continuar buscando");
                String salida = entry.nextLine();

                if (salida.equals("si") || salida.equals("Si") || salida.equals("SI")) {
                    System.out.println("Ingrese nombre del barrio: ");
                    nombreBarrio = entry.nextLine();
                    System.out.println("Ingrese referencia: ");
                    referencia = entry.nextLine();
                    Barrio barr = new Barrio(nombreBarrio, referencia);
                    EscrituraBarrio archivo2 = new EscrituraBarrio(nombreArchivo);
                    archivo2.establecerRegistroBarrio(barr);
                    archivo2.establecerSalidaBarrio();
                    barrioBuscar = barr;
                    return barrioBuscar;
                }
            }

        } while (bandera);
        return null;
    }

    public static Ciudad buscadorCiudad() {
        Scanner entry = new Scanner(System.in);
        boolean bandera = true;
        String nombreCiudad;
        String nombreProvincia;
        String nombreArchivo = "ciudades.dat";

        do {
            System.out.println("Ingrese El Nombre De La Ciudad");
            nombreCiudad = entry.nextLine();
            Ciudad ciudadBuscar;
            Buscar b = new Buscar(nombreArchivo);
            b.establecerIdentificador(nombreCiudad);
            b.establecerCiudadBuscado();
            ciudadBuscar = b.obtenerCiudadBuscado();
            if (ciudadBuscar != null) {
                System.out.printf("Ciudad encontrada\n%s\n", ciudadBuscar);
                bandera = false;
                return ciudadBuscar;
            } else {
                System.out.println("Ciudad no encontrada si desea ingresar una "
                        + "nueva ciudad ingrese si, caso contrario ingrese "
                        + "cualquier otra letra para continuar buscando");
                String salida = entry.nextLine();

                if (salida.equals("si") || salida.equals("Si") || salida.equals("SI")) {
                    System.out.println("Ingrese nombre de la ciudad: ");
                    nombreCiudad = entry.nextLine();
                    System.out.println("Ingrese nombre de la provincia: ");
                    nombreProvincia = entry.nextLine();
                    Ciudad ciud = new Ciudad(nombreCiudad, nombreProvincia);
                    EscrituraCiudad archivo = new EscrituraCiudad(nombreArchivo);
                    archivo.establecerRegistroCiudad(ciud);
                    archivo.establecerSalidaCiudad();
                    ciudadBuscar = ciud;
                    return ciudadBuscar;
                }
            }
        } while (bandera);
        return null;
    }

    public static Constructora buscadorConstructora() {
        Scanner entry = new Scanner(System.in);
        boolean bandera = true;
        String nombreConstructora;
        String idConstructora;
        String nombreArchivo = "constructoras.dat";

        do {
            System.out.println("Ingrese El ID De La Constructora");
            idConstructora = entry.nextLine();
            Constructora constructoraBuscar;
            Buscar b = new Buscar(nombreArchivo);
            b.establecerIdentificador(idConstructora);
            b.establecerConstructoraBuscado();
            constructoraBuscar = b.obtenerConstructoraBuscado();
            if (constructoraBuscar != null) {
                System.out.printf("Constructora encontrada\n%s\n", constructoraBuscar);
                bandera = false;
                return constructoraBuscar;
            } else {
                System.out.println("Constructora no encontrada si desea ingresar una "
                        + "nueva constructora ingrese si, caso contrario ingrese "
                        + "cualquier otra letra para continuar buscando");
                String salida = entry.nextLine();

                if (salida.equals("si") || salida.equals("Si") || salida.equals("SI")) {
                    System.out.println("Ingrese nombre constructora: ");
                    nombreConstructora = entry.nextLine();
                    System.out.println("Ingrese id constructora: ");
                    idConstructora = entry.nextLine();
                    Constructora construc = new Constructora(nombreConstructora, idConstructora);
                    EscrituraConstructora archivo = new EscrituraConstructora(nombreArchivo);
                    archivo.establecerRegistroConstructora(construc);
                    archivo.establecerSalidaConstructora();
                    constructoraBuscar = construc;
                    return constructoraBuscar;
                }
            }

        } while (bandera);
        return null;
    }
}

// Buscador de archivos -------------------------------------------------

