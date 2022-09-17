package edu.obligatorio.com;

import edu.obligatorio.com.classes.Jugador;

import java.util.ArrayList;
import java.util.List;

public class Controladora {
    private static ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
    private static ArrayList<Jugador> listaDTs = new ArrayList<Jugador>();
    private static ArrayList<Jugador> listaPartidos = new ArrayList<Jugador>();
    private static ArrayList<Jugador> listaArbitros = new ArrayList<Jugador>();

    public static ArrayList<Jugador> getJugadores() {
        return listaJugadores;
    }

    public Jugador buscarJugadorPorId(short aId) {
        for (int i = 0; i < listaJugadores.size(); i++)
            if (listaJugadores.get(i).Id() == aId) return listaJugadores.get(i);

        return null;
    }

    public short getNextId() {
        short max = 0;
        for (int i = 0; i < listaJugadores.size(); i++) {
            short id = listaJugadores.get(i).Id();
            if (id > max) max = id;
        }
        return max++;
    }

    public void addPlayer(Jugador aJugador) {
        aJugador.Id(getNextId());
        listaJugadores.add(aJugador);
    }

    public void deletePlayer(short aId) {
        Jugador jugador = buscarJugadorPorId(aId);
        if (jugador != null)
            listaJugadores.remove(jugador);
    }
}
