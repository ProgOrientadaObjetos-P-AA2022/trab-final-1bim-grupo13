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
                    EscrituraPropietario archivo3 = new EscrituraPropietario("propietarios.dat");
                    archivo3.setRegistroPropietario(prop);
                    archivo3.setSalidaPropietario();
                    break;

                case 2:
                    System.out.println("Ingrese el nombre del Barrio");
                    String nombreBarrio = entry.nextLine();
                    System.out.println("Ingrese una Referencia para hallar el "
                            + "barrio");
                    String referencia = entry.nextLine();
                    barr = new Barrio(nombreBarrio, referencia);
                    EscrituraBarrio archivo4 = new EscrituraBarrio("barrios.dat");
                    archivo4.setRegistroBarrio(barr);
                    archivo4.setSalidaBarrio();
                    break;

                case 3:
                    System.out.println("Ingrese el nombre de la ciudad");
                    String nombreCiudad = entry.nextLine();
                    System.out.println("Ingrese el nombre de la provincia");
                    String nombreProvincia = entry.nextLine();

                    ciud = new Ciudad(nombreCiudad, nombreProvincia);
                    EscrituraCiudad archivo5 = new EscrituraCiudad("ciudades.dat");
                    archivo5.setRegistroCiudad(ciud);
                    archivo5.setSalidaCiudad();
                    break;

                case 4:
                    System.out.println("Ingrese el nombre de la constructora");
                    String nombreConstructora = entry.nextLine();
                    System.out.println("Ingrese el ID de la constructora");
                    String idConstructora = entry.nextLine();

                    construc = new Constructora(nombreConstructora,
                            idConstructora);
                    EscrituraConstructora archivo6 = new EscrituraConstructora("constructoras.dat");
                    archivo6.setRegistroConstructora(construc);
                    archivo6.setSalidaConstructora();
                    break;

                case 5:
                    prop = buscarPro();
                    barr = buscarBarr();
                    ciud = buscarCiu();
                    System.out.println("Ingrese el valor del precio del metro "
                            + "cuadrado");
                    double precioMetro = entry.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados");
                    double numeroMetros = entry.nextDouble();
                    System.out.println("Ingrese el numero de cuartos");
                    int numeroCuartos = entry.nextInt();
                    Casa casa = new Casa(prop, precioMetro, numeroMetros, barr,
                            ciud, numeroCuartos, construc);
                    casa.setCostoFinal();
                    EscrituraCasa archivo = new EscrituraCasa("casas.dat");
                    archivo.setRegistroCasa(casa);
                    archivo.setSalidaCasa();
                    break;

                case 6:
                    prop = buscarPro();
                    barr = buscarBarr();
                    ciud = buscarCiu();
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
                    departamento.setCostoFinal();
                    EscrituraDepartamento archivo2 = new EscrituraDepartamento("departamentos.dat");
                    archivo2.setRegistroDepartamento(departamento);
                    archivo2.setSalidaDepartamento();
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
                LecturaArchivo lectura3 = new LecturaArchivo("propietarios.dat");
                lectura3.setListaPropietarios();
                System.out.printf("%s", lectura3.MostrarEnPantallaPropietarios());
                lectura3.cerrarArchivo();
                break;

            case 2:
                LecturaArchivo lectura4 = new LecturaArchivo("barrios.dat");
                lectura4.setListaBarrios();
                System.out.printf("%s", lectura4.MostrarEnPantallaBarrios());
                lectura4.cerrarArchivo();
                break;

            case 3:
                LecturaArchivo lectura5 = new LecturaArchivo("ciudades.dat");
                lectura5.setListaCiudades();
                System.out.printf("%s", lectura5.MostrarEnPantallaCiudades());
                lectura5.cerrarArchivo();
                break;
            case 4:
                LecturaArchivo lectura6 = new LecturaArchivo("constructoras.dat");
                lectura6.setListaConstructoras();
                System.out.printf("%s", lectura6.MostrarEnPantallaConstructoras());
                lectura6.cerrarArchivo();
                break;

            case 5:
                LecturaArchivo lectura = new LecturaArchivo("casas.dat");
                lectura.setListaCasas();
                System.out.printf("%s", lectura.MostrarEnPantallaCasas());
                lectura.cerrarArchivo();
                break;

            case 6:
                LecturaArchivo lectura2 = new LecturaArchivo("departamentos.dat");
                lectura2.setListaDepartamentos();
                System.out.printf("%s", lectura2.MostrarEnPantallaDepartamentos());
                lectura2.cerrarArchivo();
                break;

        }
    }

    public static Propietario buscarPro() {
        Scanner sc = new Scanner(System.in);
        String identificacion;
        String nombres;
        String apellidos;
        String nombreArchivo = "propietarios.dat";
        System.out.println("Ingrese identifiacion del propietario: ");
        identificacion = sc.nextLine();
        Propietario propietarioBuscar;
        LecturaArchivo lectura = new LecturaArchivo(nombreArchivo);
        lectura.setIdentificador(identificacion);
        lectura.setPropietarioBuscado();
        propietarioBuscar = lectura.getPropietarioBuscado();
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
            Propietario p = new Propietario(nombres, apellidos, identificacion);
            EscrituraPropietario archivo = new EscrituraPropietario(nombreArchivo);
            archivo.setRegistroPropietario(p);
            archivo.setSalidaPropietario();
            return p;
        }
    }

    public static Barrio buscarBarr() {
        Scanner sc = new Scanner(System.in);
        String nombreBarrio;
        String referencia;
        String nombreArchivo = "barrios.dat";
        System.out.println("Ingrese nombre del barrio: ");
        nombreBarrio = sc.nextLine();
        Barrio barrioBuscar;
        LecturaArchivo lectura = new LecturaArchivo(nombreArchivo);
        lectura.setIdentificador(nombreBarrio);
        lectura.setBarrioBuscado();
        barrioBuscar = lectura.getBarrioBuscado();
        if (barrioBuscar != null) {
            System.out.printf("Barrio encontrado %s\n", barrioBuscar);
            return barrioBuscar;
        } else {
            System.out.println("Barrio no encontrado, ingrese los datos como NUEVO BARRIO!!");
            System.out.println("Ingrese nombre del barrio: ");
            nombreBarrio = sc.nextLine();
            System.out.println("Ingrese referencia: ");
            referencia = sc.nextLine();
            Barrio b = new Barrio(nombreBarrio, referencia);
            EscrituraBarrio archivo2 = new EscrituraBarrio(nombreArchivo);
            archivo2.setRegistroBarrio(b);
            archivo2.setSalidaBarrio();
            return b;
        }
    }

    public static Ciudad buscarCiu() {
        Scanner sc = new Scanner(System.in);
        String nombreCiudad;
        String nombreProvincia;
        String nombreArchivo = "ciudades.dat";
        System.out.println("Ingrese nombre ciudad: ");
        nombreCiudad = sc.nextLine();
        Ciudad ciudadBuscar;
        LecturaArchivo lectura = new LecturaArchivo(nombreArchivo);
        lectura.setIdentificador(nombreCiudad);
        lectura.setCiudadBuscado();
        ciudadBuscar = lectura.getCiudadBuscado();
        if (ciudadBuscar != null) {
            System.out.printf("Ciudad encontrada %s\n", ciudadBuscar);
            return ciudadBuscar;
        } else {
            System.out.println("Ciudad no encontrada, ingrese los datos como NUEVA CIUDAD!!");
            System.out.println("Ingrese nombre de la ciudad: ");
            nombreCiudad = sc.nextLine();
            System.out.println("Ingrese nombre de la provincia: ");
            nombreProvincia = sc.nextLine();
            Ciudad c = new Ciudad(nombreCiudad, nombreProvincia);
            EscrituraCiudad archivo = new EscrituraCiudad(nombreArchivo);
            archivo.setRegistroCiudad(c);
            archivo.setSalidaCiudad();
            return c;
        }
    }

    public static Constructora buscarCons() {
        Scanner sc = new Scanner(System.in);
        String nombreConstructora;
        String idConstructora;
        String nombreArchivo = "constructoras.dat";
        System.out.println("Ingrese id de la constructora: ");
        idConstructora = sc.nextLine();
        Constructora constructoraBuscar;
        LecturaArchivo lectura = new LecturaArchivo(nombreArchivo);
        lectura.setIdentificador(idConstructora);
        lectura.setConstructoraBuscado();
        constructoraBuscar = lectura.getConstructoraBuscado();
        if (constructoraBuscar != null) {
            System.out.printf("Constructora encontrada %s\n", constructoraBuscar);
            return constructoraBuscar;
        } else {
            System.out.println("Constructora no encontrada, ingrese los datos como NUEVA CONSTRUCTORA!!");
            System.out.println("Ingrese nombre constructora: ");
            nombreConstructora = sc.nextLine();
            System.out.println("Ingrese id constructora: ");
            idConstructora = sc.nextLine();
            Constructora cons = new Constructora(nombreConstructora, idConstructora);
            EscrituraConstructora archivo = new EscrituraConstructora(nombreArchivo);
            archivo.setRegistroConstructora(cons);
            archivo.setSalidaConstructora();
            return cons;
        }
    }

}
