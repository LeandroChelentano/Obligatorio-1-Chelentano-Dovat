package edu.obligatorio.com;

import edu.obligatorio.com.classes.Jugador;

import java.util.ArrayList;

public class Controladora {
    private static ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
    private static ArrayList<Jugador> listaDTs = new ArrayList<Jugador>();
    private static ArrayList<Jugador> listaPartidos = new ArrayList<Jugador>();
    private static ArrayList<Jugador> listaArbitros = new ArrayList<Jugador>();

    public static ArrayList<Jugador> getJugadores() {
        return  listaJugadores;
    }

    public void addPlayer(Jugador aJugador) {
        listaJugadores.add(aJugador);
    }

    public void deletePlayer(Jugador aJugador) {
        listaJugadores.add(aJugador);
    }
}
