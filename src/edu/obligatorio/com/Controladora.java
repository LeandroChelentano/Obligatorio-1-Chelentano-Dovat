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
    public ArrayList<Jugador> getJugadores() {
        return listaJugadores;
    }

    public ArrayList<Partido> getPartidos() {
        return listaPartidos;
    }

    public ArrayList<Arbitro> getArbitro() {
        return listaArbitros;
    }

    public ArrayList<DT> getDT() {
        return listaDTs;
    }
//    #endregion

    //    #region searchMethods
    public Jugador searchPlayerById(short aId) {
        for (int i = 0; i < listaJugadores.size(); i++)
            if (listaJugadores.get(i).getId() == aId) return listaJugadores.get(i);

        return null;
    }

    public Partido searchMatchById(short aId) {
        for (int i = 0; i < listaPartidos.size(); i++)
            if (listaPartidos.get(i).getId() == aId) return listaPartidos.get(i);

        return null;
    }

    public Arbitro searchRefereeById(short pId) {
        for (int i = 0; i < listaArbitros.size(); i++)
            if (listaArbitros.get(i).getId() == pId) return listaArbitros.get(i);

        return null;
    }

    public DT searchDTById(short pId) {
        for (int i = 0; i < listaDTs.size(); i++)
            if (listaDTs.get(i).getId() == pId) return listaDTs.get(i);

        return null;
    }


//    #endregion

    //    #region idGen
    public short getNextPlayerId() {
        if (listaJugadores.size() == 0) return 0;

        short max = 0;
        for (Jugador j : listaJugadores)
            if (j.getId() > max) max = j.getId();

        return (short) (max + 1);
    }

    public short getNextRefereeId() {
        if (listaArbitros.size() == 0) return 0;

        short max = 0;
        for (Arbitro a : listaArbitros)
            if (a.getId() > max) max = a.getId();

        return (short) (max + 1);
    }

    public short getNextDTId() {
        if (listaDTs.size() == 0) return 0;

        short max = 0;
        for (DT d : listaDTs)
            if (d.getId() > max) max = d.getId();

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
        aJugador.setId(getNextPlayerId());
        listaJugadores.add(aJugador);
    }

    public void deletePlayer(short aId) {
        Jugador jugador = searchPlayerById(aId);
        if (jugador != null)
            listaJugadores.remove(jugador);
    }
//    #endregion

    //    #region arbitros
    public void addArbitro(Arbitro pArbitro) {
        pArbitro.setId(getNextRefereeId());
        listaArbitros.add(pArbitro);
    }

    public void deleteArbitro(short pId) {
        Arbitro Arbitro = searchRefereeById(pId);
        if (Arbitro != null)
            listaJugadores.remove(Arbitro);
    }

    //    #endregion
//    #region DT
    public void addDT(DT pDT) {
        pDT.setId(getNextDTId());
        listaDTs.add(pDT);
    }

    public void deleteDT(short pId) {
        DT DT = searchDTById(pId);
        if (DT != null)
            listaDTs.remove(DT);
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
