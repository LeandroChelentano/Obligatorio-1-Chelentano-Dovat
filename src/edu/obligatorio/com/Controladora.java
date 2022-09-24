package edu.obligatorio.com;

import edu.obligatorio.com.classes.Arbitro;
import edu.obligatorio.com.classes.DT;
import edu.obligatorio.com.classes.Jugador;
import edu.obligatorio.com.classes.Partido;

import java.util.ArrayList;
import java.util.List;

public class Controladora {
    private static ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
    private static ArrayList<DT> listaDTs = new ArrayList<DT>();
    private static ArrayList<Partido> listaPartidos = new ArrayList<Partido>();
    private static ArrayList<Arbitro> listaArbitros = new ArrayList<Arbitro>();

//    #region listGets
    public static ArrayList<Jugador> getJugadores() {
        return listaJugadores;
    }
    public static ArrayList<Partido> getPartidos() {
        return listaPartidos;
    }
    public static ArrayList<Arbitro> getArbitro() {
        return listaArbitros;
    }
//    #endregion

//    #region searchMethods
    public Jugador buscarJugadorPorId(short aId) {
        for (int i = 0; i < listaJugadores.size(); i++)
            if (listaJugadores.get(i).Id() == aId) return listaJugadores.get(i);

        return null;
    }
    public Partido buscarPartidoPorId(short aId) {
        for (int i = 0; i < listaPartidos.size(); i++)
            if (listaPartidos.get(i).Id() == aId) return listaPartidos.get(i);

        return null;
    }
    public Arbitro buscarArbitroPorId(short pId) {
        for (int i = 0; i < listaArbitros.size(); i++)
            if (listaArbitros.get(i).Id() == pId) return listaArbitros.get(i);

        return null;
    }
//    #endregion

//    #region idGen
    public short getNextPlayerId() {
        short max = 0;
        for (Jugador j : listaJugadores) {
            if (j.Id() > max) max = j.Id();
        }
        return (short) ((short) max+1);
    }
    public short getNextArbitroId() {
        short max = 0;
        for (int i = 0; i < listaArbitros.size(); i++) {
            short id = listaArbitros.get(i).Id();
            if (id > max) max = id;
        }
        return max++;
    }
    public short getNextMatchId() {
        short max = 0;
        for (int i = 0; i < listaPartidos.size(); i++) {
            short id = listaPartidos.get(i).Id();
            if (id > max) max = id;
        }
        return max++;
    }
//    #endregion

//    #region players
    public void addPlayer(Jugador aJugador) {
        aJugador.Id(getNextPlayerId());
        listaJugadores.add(aJugador);
    }

    public void deletePlayer(short aId) {
        Jugador jugador = buscarJugadorPorId(aId);
        if (jugador != null)
            listaJugadores.remove(jugador);
    }
//    #endregion

//    region arbitros
    public void addArbitro(Arbitro pArbitro) {
        pArbitro.Id(getNextArbitroId());
       listaArbitros.add(pArbitro);
    }
    public void deleteArbitro(short pId) {
        Arbitro Arbitro = buscarArbitroPorId(pId);
        if (Arbitro != null)
            listaJugadores.remove(Arbitro);
    }
//    #endregion

//    #region matches
    public void addMatch(Partido aPartido) {
        aPartido.Id(getNextMatchId());
        listaPartidos.add(aPartido);
    }

    public void deleteMatch(short aId) {
        Partido partido = buscarPartidoPorId(aId);
        if (partido != null)
            listaPartidos.remove(partido);
    }
    public void startMatch(short aId) {
        Partido partido = buscarPartidoPorId(aId);
        if (partido != null)
            if (!partido.Jugando() && !partido.Terminado())
                partido.Start();
    }

    public void endMatch(short aId) {
        Partido partido = buscarPartidoPorId(aId);
        if (partido != null)
            if (partido.Jugando())
                partido.End();
    }
//    #endregion
}
