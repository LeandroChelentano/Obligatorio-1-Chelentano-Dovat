package edu.obligatorio.com.classes;

public class DT {
    private String nombre;
    private String apellido;
    private short edad;

    // Geters y Seters

    public String  Nombre() {
        return nombre;
    }
    public String  Apellido() {
        return apellido;
    }
    public short Edad() {
        return edad;
    }

    @Override
    public String toString() {
        return "El nombre es " + nombre   + apellido +  ".";}
}
