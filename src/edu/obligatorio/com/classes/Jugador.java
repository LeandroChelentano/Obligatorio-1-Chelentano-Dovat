package edu.obligatorio.com.classes;

public class Jugador extends Persona {
    private String puesto;
    private short numero;
    private short edad;

//    #region Getters - Setters
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
//    #endregion

    @Override
    public String toString() {
        return super.toString() + ", su edad es " + edad + " y juega de " + puesto + " con el numero " + numero + ".";
    }

    public Jugador() {}

    public Jugador(short aId, String aName, String aSurname, String aPosition, short aNumber, short aAge) {
        super(aId, aName, aSurname);
        puesto = aPosition;
        numero = aNumber;
        edad = aAge;
    }
}
