package edu.obligatorio.com.classes;

import java.util.Date;

public class Partido {
    private int id;
    private String estadio;
    private Date fecha;
    private int hora;
    private String clima;
    private boolean jugando = false;
    private boolean terminado = false;
    private int minutosJugados = 0;

    private int[] e1Titulares = new int[11];
    private int[] e1Suplentes = new int[5];
    private DT e1Dt;

    private int[] e2Titulares = new int[11];
    private int[] e2Suplentes = new int[5];
    private DT e2Dt;

    private Arbitro[] arbitros = new Arbitro[3];

    public int Id() {return id;}
    public String Estadio() {return estadio;}
    public Date Fecha() {return fecha;}
    public int Hora() {return hora;}
    public String Clima() {return clima;}
    public boolean Jugando() {return jugando;}
    public boolean Terminado() {return terminado;}
    public int MinutosJugados() {return minutosJugados;}
    @Override
    public String toString() {
        return "El ID del partido es " + id   + " en el Estadio " + estadio + ", fecha  " + fecha + " Hora" + hora + " Clima " + clima + ".";}

    public Partido() {}
    public Partido(int Id, String Estadio, Date Fecha, int Hora, String Clima) {
        id = Id;
        estadio = Estadio;
        fecha = Fecha;
        hora = Hora;
        clima = Clima;
    }

}
