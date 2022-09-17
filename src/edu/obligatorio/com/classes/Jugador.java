package edu.obligatorio.com.classes;

public class Jugador {
    private short id;
    private String nombre;
    private String apellido;
    private String puesto;
    private short numero;
    private short edad;

    // Geters y Seters
    public short Id() {
        return id;
    }
    public short Id(short aId) {
        id = aId;
    }
    public String Nombre() {
        return nombre;
    }
    public String Apellido() {
        return apellido;
    }
    public String Puesto() {
        return puesto;
    }
    public short Numero() {
        return numero;
    }
    public short Edad() {
        return edad;
    }

    @Override
    public String toString() {
        return "El nombre es " + nombre + " " + apellido + ", su edad es " + edad + " y juega en " + puesto + " con el numero " + numero + ".";
    }

    public Jugador() {}

    public Jugador(short aId, String name, String surname, String position, short number, short age) {
        id = aId;
        nombre = name;
        apellido = surname;
        puesto = position;
        numero = number;
        edad = age;
    }
}
