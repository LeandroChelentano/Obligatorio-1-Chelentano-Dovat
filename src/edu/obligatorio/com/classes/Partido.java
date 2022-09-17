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

}
