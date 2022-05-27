/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;

/**
 *
 * @author reroes
 */
public class Ciudad {
    private String ciudad;
    private String provincia;

    public Ciudad(String a, String s) {
        ciudad = a;
        provincia = s;
    }

    public void establecerNombre(String n) {
        ciudad = n;
    }

    public void establecerProvincia(String n) {
        provincia = n;
    }

    public String obtenerNombre() {
        return ciudad;
    }

    public String obtenerProvincia() {
        return provincia;
    }
}
