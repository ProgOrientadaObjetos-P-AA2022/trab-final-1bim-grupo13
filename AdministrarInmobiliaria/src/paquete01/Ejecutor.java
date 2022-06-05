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

        Scanner entry = new Scanner(System.in);

        boolean bandera = true;
        int opcion;

        Propietario prop = null;
        Ciudad ciud = null;
        Barrio barr = null;
        Constructora construc = null;

        do {
            opcion = menuDeIngresoDeDatos();

            switch (opcion) {

                case 1:
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
                    break;

                case 2:
                    System.out.println("Ingrese el nombre del Barrio");
                    String nombreBarrio = entry.nextLine();
                    System.out.println("Ingrese una Referencia para hallar el "
                            + "barrio");
                    String referencia = entry.nextLine();
                    barr = new Barrio(nombreBarrio, referencia);
                    EscrituraBarrio a2 = new EscrituraBarrio("barrios.dat");
                    a2.establecerRegistroBarrio(barr);
                    a2.establecerSalidaBarrio();
                    break;

                case 3:
                    System.out.println("Ingrese el nombre de la ciudad");
                    String nombreCiudad = entry.nextLine();
                    System.out.println("Ingrese el nombre de la provincia");
                    String nombreProvincia = entry.nextLine();

                    ciud = new Ciudad(nombreCiudad, nombreProvincia);
                    EscrituraCiudad a3 = new EscrituraCiudad("ciudades.dat");
                    a3.establecerRegistroCiudad(ciud);
                    a3.establecerSalidaCiudad();
                    break;

                case 4:
                    System.out.println("Ingrese el nombre de la constructora");
                    String nombreConstructora = entry.nextLine();
                    System.out.println("Ingrese el ID de la constructora");
                    String idConstructora = entry.nextLine();

                    construc = new Constructora(nombreConstructora,
                            idConstructora);
                    System.out.println(construc);
                    EscrituraConstructora a4 = new EscrituraConstructora("constructoras.dat");
                    a4.establecerRegistroConstructora(construc);
                    a4.establecerSalidaConstructora();
                    break;

                case 5:
                    prop = buscadorPropietario();
                    barr = buscadorBarrio();
                    ciud = buscadorCiudad();
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

                    break;

                case 6:
                    prop = buscadorPropietario();
                    barr = buscadorBarrio();
                    ciud = buscadorCiudad();
                    construc = buscadorConstructora();
                    System.out.println("Ingrese el valor del precio del metro "
                            + "cuadrado");
                    precioMetro = entry.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados");
                    numeroMetros = entry.nextDouble();
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
                    break;

                case 7:
                    do {
                        opcion = menuDeListaDeArchivos();
                        crearListaDeDatos(opcion);

                    } while (opcion != 0);
                    opcion = 10;
                    break;
                case 8:
                    System.out.println("Programa finalizado");
                    bandera = false;
                    break;
            }

        } while (bandera);

    }

    public static int menuDeIngresoDeDatos() {
        Scanner entry = new Scanner(System.in);
        System.out.println("Ingrese 1 para ingresar un nuevo propietario");
        System.out.println("Ingrese 2 para ingresar un nuevo barrio");
        System.out.println("Ingrese 3 para ingresar una nueva ciudad");
        System.out.println("Ingrese 4 para ingresar una nueva constructora");
        System.out.println("Ingrese 5 para ingresar una nueva casa");
        System.out.println("Ingrese 6 para ingresar un nuevo departamento");
        System.out.println("Ingrese 7 para observar la lista de opciones");
        System.out.println("Ingrese 8 para salir del programa");
        int opcion = entry.nextInt();

        if (opcion < 1 || opcion > 8) {
            do {
                System.out.println("El valor esta fuera de los parametros, "
                        + "ingrese otro valor");
                opcion = entry.nextInt();
            } while (opcion < 1 || opcion > 8);
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

    public static Propietario buscadorPropietario() {
        Scanner sc = new Scanner(System.in);
        String identificacion;
        String nombres;
        String apellidos;
        String nombreArchivo = "propietarios.dat";
        System.out.println("Ingrese identifiacion del propietario: ");
        identificacion = sc.nextLine();
        Propietario propietarioBuscar;
        Buscar b = new Buscar(nombreArchivo);
        b.establecerIdentificador(identificacion);
        b.establecerPropietarioBuscado();
        propietarioBuscar = b.obtenerPropietarioBuscado();
        if (propietarioBuscar != null) {
            System.out.printf("Propietario encontrado %s\n", propietarioBuscar);
            return propietarioBuscar;
        } else {
            System.out.println("Propietario no encontrado,ingrese los datos como NUEVO PROPIETARIO!!");
            System.out.println("Ingrese nombres del propietario: ");
            nombres = sc.nextLine();
            System.out.println("Ingrese apellidos del propietario: ");
            apellidos = sc.nextLine();
            System.out.println("Ingrese identificacion del propietario: ");
            identificacion = sc.nextLine();
            Propietario prop = new Propietario(nombres, apellidos, identificacion);
            EscrituraPropietario archivo = new EscrituraPropietario(nombreArchivo);
            archivo.establecerRegistroPropietario(prop);
            archivo.establecerSalidaPropietario();
            return prop;
        }
    }

    public static Barrio buscadorBarrio() {
        Scanner sc = new Scanner(System.in);
        String nombreBarrio;
        String referencia;
        String nombreArchivo = "barrios.dat";
        System.out.println("Ingrese nombre del barrio: ");
        nombreBarrio = sc.nextLine();
        Barrio barrioBuscar;
        Buscar b = new Buscar(nombreArchivo);
        b.establecerIdentificador(nombreBarrio);
        b.establecerBarrioBuscado();
        barrioBuscar = b.obtenerBarrioBuscado();
        if (barrioBuscar != null) {
            System.out.printf("Barrio encontrado %s\n", barrioBuscar);
            return barrioBuscar;
        } else {
            System.out.println("Barrio no encontrado, ingrese los datos como NUEVO BARRIO!!");
            System.out.println("Ingrese nombre del barrio: ");
            nombreBarrio = sc.nextLine();
            System.out.println("Ingrese referencia: ");
            referencia = sc.nextLine();
            Barrio barr = new Barrio(nombreBarrio, referencia);
            EscrituraBarrio archivo2 = new EscrituraBarrio(nombreArchivo);
            archivo2.establecerRegistroBarrio(barr);
            archivo2.establecerSalidaBarrio();
            return barr;
        }
    }

    public static Ciudad buscadorCiudad() {
        Scanner sc = new Scanner(System.in);
        String nombreCiudad;
        String nombreProvincia;
        String nombreArchivo = "ciudades.dat";
        System.out.println("Ingrese nombre ciudad: ");
        nombreCiudad = sc.nextLine();
        Ciudad ciudadBuscar;
        Buscar b = new Buscar(nombreArchivo);
        b.establecerIdentificador(nombreCiudad);
        b.establecerCiudadBuscado();
        ciudadBuscar = b.obtenerCiudadBuscado();
        if (ciudadBuscar != null) {
            System.out.printf("Ciudad encontrada %s\n", ciudadBuscar);
            return ciudadBuscar;
        } else {
            System.out.println("Ciudad no encontrada, ingrese los datos como NUEVA CIUDAD!!");
            System.out.println("Ingrese nombre de la ciudad: ");
            nombreCiudad = sc.nextLine();
            System.out.println("Ingrese nombre de la provincia: ");
            nombreProvincia = sc.nextLine();
            Ciudad ciud = new Ciudad(nombreCiudad, nombreProvincia);
            EscrituraCiudad archivo = new EscrituraCiudad(nombreArchivo);
            archivo.establecerRegistroCiudad(ciud);
            archivo.establecerSalidaCiudad();
            return ciud;
        }
    }

    public static Constructora buscadorConstructora() {
        Scanner sc = new Scanner(System.in);
        String nombreConstructora;
        String idConstructora;
        String nombreArchivo = "constructoras.dat";
        System.out.println("Ingrese id de la constructora: ");
        idConstructora = sc.nextLine();
        Constructora constructoraBuscar;
        Buscar b = new Buscar(nombreArchivo);
        b.establecerIdentificador(idConstructora);
        b.establecerConstructoraBuscado();
        constructoraBuscar = b.obtenerConstructoraBuscado();
        if (constructoraBuscar != null) {
            System.out.printf("Constructora encontrada %s\n", constructoraBuscar);
            return constructoraBuscar;
        } else {
            System.out.println("Constructora no encontrada, ingrese los datos como NUEVA CONSTRUCTORA!!");
            System.out.println("Ingrese nombre constructora: ");
            nombreConstructora = sc.nextLine();
            System.out.println("Ingrese id constructora: ");
            idConstructora = sc.nextLine();
            Constructora construc = new Constructora(nombreConstructora, idConstructora);
            EscrituraConstructora archivo = new EscrituraConstructora(nombreArchivo);
            archivo.establecerRegistroConstructora(construc);
            archivo.establecerSalidaConstructora();
            return construc;
        }
    }

}
