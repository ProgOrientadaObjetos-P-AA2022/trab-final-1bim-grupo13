/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.util.Scanner;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {

        Scanner entry = new Scanner(System.in);

        boolean bandera = true;
        int opcion;
        

        do {

            opcion = menuDeOpciones();
            switch (opcion) {

                case 1:
                    System.out.println("Ingrese los nombres del propietario");
                    String nombrePropietario = entry.nextLine();
                    System.out.println("Ingrese los apellidos del propietario");
                    String apellidosPropietario = entry.nextLine();
                    System.out.println("Ingrese la identificacion del propietario");
                    String identificacion = entry.nextLine();
                    break;
                                       
                case 2:
                    System.out.println("Ingrese el nombre del Barrio");
                    String nombreBarrio = entry.nextLine();
                    System.out.println("Ingrese una Referencia para hallar el "
                            + "barrio");
                    String referencia = entry.nextLine();
                    break;
                    
                case 3:
                    System.out.println("Ingrese el nombre de la ciudad");
                    String nombreCiudad = entry.nextLine();
                    System.out.println("Ingrese el nombre de la provincia");
                    String nombreProvincia = entry.nextLine();
                    break;
                    
                case 4:
                    System.out.println("Ingrese el nombre de la constructora");
                    String nombreConstructora = entry.nextLine();
                    System.out.println("Ingrese el ID de la constructora");
                    String idConstructora = entry.nextLine();
                    break;
                    
                case 5:
                    System.out.println("Ingrese el valor del precio del metro "
                            + "cuadrado");
                    double precioMetro = entry.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados");
                    double numeroMetros = entry.nextDouble();
                    System.out.println("Ingrese el numero de cuartos");
                    int numeroCuartos = entry.nextInt();
                    break;
                    
                case 6:
                    System.out.println("Ingrese el valor del precio del metro "
                            + "cuadrado");
                    precioMetro = entry.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados");
                    numeroMetros = entry.nextDouble();
                    break;
            }

        } while (bandera);

    }

    public static int menuDeOpciones() {
        Scanner entry = new Scanner(System.in);
        System.out.println("Ingrese 1 para ingresar un nuevo propietario");
        System.out.println("Ingrese 2 para ingresar un nuevo barrio");
        System.out.println("Ingrese 3 para ingresar una nueva ciudad");
        System.out.println("Ingrese 4 para ingresar una nueva constructora");
        System.out.println("Ingrese 5 para ingresar una nueva casa");
        System.out.println("Ingrese 6 para ingresar un nuevo departamento");
        int opcion = entry.nextInt();
        return opcion;
    }
}
