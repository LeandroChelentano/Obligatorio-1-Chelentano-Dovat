package edu.obligatorio.com.classes;


public class DT extends Persona {

    private short edad;

    // Geters y Seters


    public short getEdad() {
        return edad;
    }

    public void setEdad(short edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return super.toString() + " y su edad es " + edad + ".";
    }


    public DT() {
    }

    public DT(short aId, String aName, String aSurname, short aAge) {
        super(aId, aName, aSurname);
        edad = aAge;
    }
}
