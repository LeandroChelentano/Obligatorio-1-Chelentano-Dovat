package edu.obligatorio.com.classes;

public class Partido {
    private short id;
    private String estadio;
    private String fecha;
    private String hora;
    private String clima;
    private boolean jugando = false;
    private boolean terminado = false;
    private int minutosJugados = 0;

    private short e1Score = 0;
    private short e2Score = 0;

    private Jugador[] e1Titulares = new Jugador[11];
    private Jugador[] e1Suplentes = new Jugador[5];
    private DT e1Dt;

    private Jugador[] e2Titulares = new Jugador[11];
    private Jugador[] e2Suplentes = new Jugador[5];
    private DT e2Dt;

    private Arbitro[] arbitros = new Arbitro[3];

//    #region setters
    public void Id(short aId) {
        id = aId;
    }
    public void setE1Dt(DT aDt) {
        e1Dt = aDt;
    }
    public void setE2Dt(DT aDt) {
        e2Dt = aDt;
    }
//    #endregion

//    #region getters
    public short getId() {
        return id;
    }
    public short getE1Score() {
        return e1Score;
    }
    public short getE2Score() {
        return e2Score;
    }
    public DT getE1DT() {
        return e1Dt;
    }
    public DT getE2DT() {
        return e2Dt;
    }
    public String getEstadio() {
        return estadio;
    }
    public String getFecha() {
        return fecha;
    }
    public String getHora() {
        return hora;
    }
    public String getClima() {
        return clima;
    }
    public Jugador[] getE1Titulares() {
        return e1Titulares;
    }
    public Jugador[] getE2Titulares() {
        return e2Titulares;
    }
    public Jugador[] getE1Suplentes() {
        return e1Suplentes;
    }
    public Jugador[] getE2Suplentes() {
        return e2Suplentes;
    }
    public boolean getJugando() {return jugando;}
    public boolean getTerminado() {return terminado;}
    public int getMinutosJugados() {return minutosJugados;}
//    #endregion

//    #region methods
    public int countPeople(Persona[] arr) {
        int count = 0;
        for (Persona person : arr)
            if (person != null) count++;

        return count;
    }
    public boolean Start() {
//        if (
//                terminado ||
//                countPeople(e1Titulares) != 11 ||
//                countPeople(e2Titulares) != 11 ||
//                countPeople(e1Suplentes) != 5 ||
//                countPeople(e2Suplentes) != 5 ||
//                countPeople(arbitros) != 3 ||
//                e1Dt == null ||
//                e2Dt == null
//        ) {
//            return false;
//        }

        jugando = true;
        return true;
    }
    public boolean End() {
        if (!jugando) return false;

        jugando = false;
        terminado = true;
        return true;
    }
    public boolean isPlayerPlaying(Jugador aPlayer) {
        boolean isPlaying = false;

        for (Jugador player : e1Titulares)
            if (player != null)
                if (player.getId() == aPlayer.getId())
                    isPlaying = true;

        for (Jugador player : e2Titulares)
            if (player != null)
                if (player.getId() == aPlayer.getId())
                    isPlaying = true;

        for (Jugador player : e1Suplentes)
            if (player != null)
                if (player.getId() == aPlayer.getId())
                    isPlaying = true;

        for (Jugador player : e2Suplentes)
            if (player != null)
                if (player.getId() == aPlayer.getId())
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
            if (e1Titulares[i].getId() == aPlayer.getId())
                e1Titulares[i] = null;

        for (int i = 0; i < e2Titulares.length; i++)
            if (e2Titulares[i].getId() == aPlayer.getId())
                e2Titulares[i] = null;

        for (int i = 0; i < e1Suplentes.length; i++)
            if (e1Suplentes[i].getId() == aPlayer.getId())
                e1Suplentes[i] = null;

        for (int i = 0; i < e2Suplentes.length; i++)
            if (e2Suplentes[i].getId() == aPlayer.getId())
                e2Suplentes[i] = null;
    }
    public void changePlayer(Jugador aEnters, Jugador aExits) {
        int outTeam = -1;
        int inTeam = -1;

        // validar que el que sale es titular
        for (Jugador j : e1Titulares)
            if (j.getId() == aExits.getId())
                outTeam = 1;

        for (Jugador j : e2Titulares)
            if (j.getId() == aExits.getId())
                outTeam = 2;


        // validar que el jugador que entra es suplente
        for (Jugador j : e1Suplentes)
            if (j.getId() == aEnters.getId())
                inTeam = 1;

        for (Jugador j : e1Suplentes)
            if (j.getId() == aEnters.getId())
                inTeam = 2;

        // validar que sean del mismo equipo
        if (outTeam != inTeam || outTeam == -1) return;

        // sacamos de los titulares quien sale y lo guardamos en una variable auxiliar
        Jugador temp = null;
        for (Jugador j : (inTeam == 1 ? e1Titulares : e2Titulares))
            if (j.getId() == aExits.getId()) {
                temp = j;
                j = aEnters;
            }

        // reemplazar el que entra por el que sale
        for (Jugador j : (inTeam == 1 ? e1Suplentes : e2Suplentes))
            if (j.getId() == aExits.getId())
                j = temp;
    }
    public void scoreGoal(Jugador aPlayer) {
        if (!jugando || aPlayer == null) return;

        for (Jugador j : e1Titulares)
            if (j.getId() == aPlayer.getId()) {
                e1Score++;
                return;
            }

        for (Jugador j : e2Titulares)
            if (j.getId() == aPlayer.getId()) {
                e2Score++;
                return;
            }
    }
    public void assignReferee(Arbitro aReferee) {
         for (Arbitro a : arbitros)
             if (a.getId() == aReferee.getId())
                 return;

        for (Arbitro a : arbitros)
            if (a == null)
                a = aReferee;
    }
//    #endregion

    @Override
    public String toString() {
        return "[" + id + "] Estadio \"" + estadio + "\", " + fecha + " " + hora + " - Clima: " + clima + " " + e1Score + " - " + e2Score + (terminado ? " [TERMINADO]" : "");
    }

    public Partido() {}
    public Partido(short Id, String Estadio, String Fecha, String Hora, String Clima) {
        id = Id;
        estadio = Estadio;
        fecha = Fecha;
        hora = Hora;
        clima = Clima;
    }
}
