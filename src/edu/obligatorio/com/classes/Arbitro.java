package edu.obligatorio.com.classes;


public class Arbitro extends Persona {


    private String puesto;

    // Geters y Seters


    String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return super.toString() + ", en el puesto " + puesto + ".";
    }

    public Arbitro() {
    }

    public Arbitro(short aId, String aName, String aSurname, String aPosition) {
        super(aId, aName, aSurname);
        puesto = aPosition;
    }


}
