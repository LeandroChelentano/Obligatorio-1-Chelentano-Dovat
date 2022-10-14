package edu.obligatorio.com.classes;

public class Jugador extends Persona {


    private String puesto;
    private short numero;
    private short edad;

    // Geters y Seters

    public String getPuesto() {
        return puesto;
    }

    public short getNumero() {
        return numero;
    }

    public short getEdad() {
        return edad;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public void setApellido(String apellido) {
        super.setApellido(apellido);
    }

    @Override
    public String toString() {

        return super.toString() + ", su edad es " + edad + " y juega de " + puesto + " con el numero " + numero + ".";
    }

    public Jugador() {
    }

    public Jugador(short aId, String aname, String asurname, String aposition, short anumber, short aage) {
        super(aId, aname, asurname);
        puesto = aposition;
        numero = anumber;
        edad = aage;
    }
}
