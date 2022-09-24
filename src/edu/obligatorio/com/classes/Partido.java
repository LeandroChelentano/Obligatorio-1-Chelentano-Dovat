package edu.obligatorio.com.classes;

import java.util.Date;

public class Partido {
    private short id;
    private String estadio;
    private String fecha;
    private String hora;
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

    public void Id(short aId) {id = aId;}
    public short Id() {return id;}
    public String Estadio() {return estadio;}
    public String Fecha() {return fecha;}
    public String Hora() {return hora;}
    public String Clima() {return clima;}
    public boolean Jugando() {return jugando;}
    public boolean Terminado() {return terminado;}
    public int MinutosJugados() {return minutosJugados;}
    @Override
    public String toString() {
        return "[" + id + "] Estadio \"" + estadio + "\", " + fecha + " " + hora + " - Clima: " + clima;}

    public Partido() {}
    public Partido(short Id, String Estadio, String Fecha, String Hora, String Clima) {
        id = Id;
        estadio = Estadio;
        fecha = Fecha;
        hora = Hora;
        clima = Clima;
    }

}
