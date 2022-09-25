package edu.obligatorio.com.classes;

import java.util.Arrays;
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

    private Jugador[] e1Titulares = new Jugador[11];
    private Jugador[] e1Suplentes = new Jugador[5];
    private DT e1Dt;

    private Jugador[] e2Titulares = new Jugador[11];
    private Jugador[] e2Suplentes = new Jugador[5];
    private DT e2Dt;

    private Arbitro[] arbitros = new Arbitro[3];

//    #region setters
    public void Id(short aId) {id = aId;}
//    #endregion

//    #region getters
    public short Id() {
        return id;
    }
    public String Estadio() {
        return estadio;
    }
    public String Fecha() {
        return fecha;
    }
    public String Hora() {
        return hora;
    }
    public String Clima() {
        return clima;
    }
    public Jugador[] E1Titulares() {
        return e1Titulares;
    }
    public Jugador[] E2Titulares() {
        return e2Titulares;
    }
    public Jugador[] E1Suplentes() {
        return e1Suplentes;
    }
    public Jugador[] E2Suplentes() {
        return e2Suplentes;
    }
    public boolean Jugando() {return jugando;}
    public boolean Terminado() {return terminado;}
    public int MinutosJugados() {return minutosJugados;}
//    #endregion

//    #region methods
    public void Start() {
    jugando = true;
}
    public void End() {
        jugando = false;
        terminado = true;
    }
    public boolean isPlayerPlaying(Jugador aPlayer) {
        boolean isPlaying = false;

        for (Jugador player : e1Titulares)
            if (player != null)
                if (player.Id() == aPlayer.Id())
                    isPlaying = true;

        for (Jugador player : e2Titulares)
            if (player != null)
                if (player.Id() == aPlayer.Id())
                    isPlaying = true;

        for (Jugador player : e1Suplentes)
            if (player != null)
                if (player.Id() == aPlayer.Id())
                    isPlaying = true;

        for (Jugador player : e2Suplentes)
            if (player != null)
                if (player.Id() == aPlayer.Id())
                    isPlaying = true;

        return isPlaying;
    }
    public void addPlayerToTeamOne(Jugador aPlayer, boolean isTitular) {
        if (isTitular) {
            for (int i = 0; i < e1Titulares.length; i++)
                if (e1Titulares[i] == null) {
                    e1Titulares[i] = aPlayer;
                    break;
                }
        } else {
            for (int i = 0; i < e1Suplentes.length; i++)
                if (e1Suplentes[i] == null) {
                    e1Suplentes[i] = aPlayer;
                    break;
                }
        }
    }
    public void addPlayerToTeamTwo(Jugador aPlayer, boolean isTitular) {
        if (isTitular) {
            for (int i = 0; i < e2Titulares.length; i++)
                if (e2Titulares[i] == null)
                    e2Titulares[i] = aPlayer;
        } else {
            for (int i = 0; i < e2Suplentes.length; i++)
                if (e2Suplentes[i] == null)
                    e2Suplentes[i] = aPlayer;
        }
    }
    public void removePlayerFromTeam(Jugador aPlayer) {
        for (int i = 0; i < e1Titulares.length; i++)
            if (e1Titulares[i].Id() == aPlayer.Id())
                e1Titulares[i] = null;

        for (int i = 0; i < e2Titulares.length; i++)
            if (e2Titulares[i].Id() == aPlayer.Id())
                e2Titulares[i] = null;

        for (int i = 0; i < e1Suplentes.length; i++)
            if (e1Suplentes[i].Id() == aPlayer.Id())
                e1Suplentes[i] = null;

        for (int i = 0; i < e2Suplentes.length; i++)
            if (e2Suplentes[i].Id() == aPlayer.Id())
                e2Suplentes[i] = null;
    }
//    #endregion

    @Override
    public String toString() {
        return "[" + id + "] Estadio \"" + estadio + "\", " + fecha + " " + hora + " - Clima: " + clima + (jugando ? " [JUGANDO]" : "") + (terminado ? " [TERMINADO]" : "");}



    public Partido() {}
    public Partido(short Id, String Estadio, String Fecha, String Hora, String Clima) {
        id = Id;
        estadio = Estadio;
        fecha = Fecha;
        hora = Hora;
        clima = Clima;
    }

}
