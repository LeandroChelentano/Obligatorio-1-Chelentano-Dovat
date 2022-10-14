package edu.obligatorio.com;

import edu.obligatorio.com.classes.*;

import java.util.ArrayList;
import java.util.List;

public class Controladora {
    private static ArrayList<Persona> listaPersonas = new ArrayList<Persona>();
    private static ArrayList<Partido> listaPartidos = new ArrayList<Partido>();

    //    #region listGets
    public ArrayList<Persona> getPersonas() {
        return listaPersonas;
    }

    public ArrayList<Partido> getPartidos() {
        return listaPartidos;
    }
//    #endregion

    //    #region searchMethods
    public Persona searchPeople(short aId) {
        for (Persona person : listaPersonas)
            if (person.getId() == aId) return person;

        return null;
    }
    public Partido searchMatchById(short aId) {
        for (Partido match : listaPartidos)
            if (match.getId() == aId) return match;

        return null;
    }
//    #endregion

    //    #region idGen
    public short getNextPersonId() {
        if (listaPersonas.size() == 0) return 0;

        short max = 0;
        for (Persona p : listaPersonas)
            if (p.getId() > max) max = p.getId();

        return (short) (max + 1);
    }

    public short getNextMatchId() {
        if (listaPartidos.size() == 0) return 0;

        short max = 0;
        for (Partido p : listaPartidos)
            if (p.getId() > max) max = p.getId();

        return (short) (max + 1);
    }
//    #endregion

    //    #region players
    public void addPlayer(Jugador aJugador) {
        aJugador.setId(getNextPersonId());
        listaPersonas.add(aJugador);
    }

    public void deletePlayer(short aId) {
        Persona jugador = searchPeople(aId);
        if (jugador instanceof Jugador)
            listaPersonas.remove(jugador);
    }
//    #endregion

    //    #region arbitros
    public void addArbitro(Arbitro pArbitro) {
        pArbitro.setId(getNextPersonId());
        listaPersonas.add(pArbitro);
    }

    public void deleteArbitro(short pId) {
        Arbitro Arbitro = (Arbitro) searchPeople(pId);
        if (Arbitro != null)
            listaPersonas.remove(Arbitro);
    }

    //    #endregion
//    #region DT
    public void addDT(DT pDT) {
        pDT.setId(getNextPersonId());
        listaPersonas.add(pDT);
    }

    public void deleteDT(short pId) {
        DT DT = (DT) searchPeople(pId);
        if (DT != null)
            listaPersonas.remove(DT);
    }
//    #endregion

    //    #region matches
    public void addMatch(Partido aPartido) {
        aPartido.Id(getNextMatchId());
        listaPartidos.add(aPartido);
    }

    public void deleteMatch(short aId) {
        Partido partido = searchMatchById(aId);
        if (partido != null)
            listaPartidos.remove(partido);
    }

    public void startMatch(short aId) {
        Partido partido = searchMatchById(aId);
        if (partido != null)
            if (!partido.getJugando() && !partido.getTerminado())
                partido.Start();
    }

    public void endMatch(short aId) {
        Partido partido = searchMatchById(aId);
        if (partido != null)
            if (partido.getJugando())
                partido.End();
    }

    public void assignPlayer(Partido match, Jugador player, String team, boolean isTitular) {
        if (match.isPlayerPlaying(player))
            return;

        switch (team) {
            case "1":
                match.addPlayerToTeamOne(player, isTitular);
                break;
            case "2":
                match.addPlayerToTeamTwo(player, isTitular);
                break;
        }
    }

    public void unassignPlayer(Partido match, Jugador player) {
        match.removePlayerFromTeam(player);
    }
//    #endregion


}
