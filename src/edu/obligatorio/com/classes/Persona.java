package edu.obligatorio.com.classes;

public class Persona {
    private short id;
    private String nombre;
    private String apellido;


    //Geters y Seters

    public short getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setId(short id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "[" + id + "] El nombre es " + nombre + " " + apellido;
    }

    public Persona() {
    }

    public Persona(short aId, String name, String surname) {
        id = aId;
        nombre = name;
        apellido = surname;
    }


}
