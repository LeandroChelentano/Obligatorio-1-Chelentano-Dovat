package edu.obligatorio.com.classes;

public class Arbitro {
    private short id;
    private String nombre;
    private String apellido;
    private String puesto;

    // Geters y Seters
    public short Id() {
        return id;
    }
    public void Id(short pId) { id = pId;
    }

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
        return "El Id es "+id+" nombre es " + nombre   +" "+ apellido + ", en el puesto " + puesto + ".";}

    public Arbitro() {}
    public Arbitro( short pId, String name, String surname, String position) {
        id = pId;
        nombre = name;
        apellido = surname;
        puesto = position;
    }




}
