package edu.obligatorio.com.classes;

public class DT {
    private short id;
    private String nombre;
    private String apellido;
    private short edad;

    // Geters y Seters
    public short Id() {
        return id;
    }

    public void Id(short pId) {
        id = pId;
    }


    public String Nombre() {
        return nombre;
    }

    public String Apellido() {
        return apellido;
    }

    public short Edad() {
        return edad;
    }

    @Override
    public String toString() {
        return "[" + id + "] El nombre es " + nombre + " " + apellido + " y su edad es " + edad + ".";
    }

    public DT() {
    }

    public DT(short pId, String name, String surname, short age) {
        id = pId;
        nombre = name;
        apellido = surname;
        edad = age;
    }
}
