package edu.obligatorio.com;

public class Arbitro {
    private String nombre;
    private String apellido;
    private String puesto;

    // Geters y Seters
    public String Nombre () {
        return nombre;
    }
    public String Apellido (){
        return apellido;
    }
    public String Puesto (){
        return puesto;
    }

    @Override
    public String toString() {
        return "El nombre es " + nombre   + apellido + ", en el puesto " + puesto + ".";}
}
