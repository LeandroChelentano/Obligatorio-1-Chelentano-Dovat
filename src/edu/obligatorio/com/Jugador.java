package edu.obligatorio.com;

public class Jugador {
    private String nombre;
    private String apellido;
    private String puesto;
    private short numero;
    private short edad;

    // Geters y Seters
    public String Nombre() {
        return nombre;
    }
    public String Apellido() {
        return apellido;
    }
    public short Numero() {
        return numero;
    }
    public short Edad() {
        return edad;
    }

    @Override
    public String toString() {
        return "El nombre es " + nombre   + apellido + ", su edad es  " + edad + " y juega en el numero" + numero + ".";}

}
