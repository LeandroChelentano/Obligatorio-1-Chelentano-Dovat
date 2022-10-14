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
    public void Id(short aId) {id = aId;}
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
        if (
                terminado &&
                countPeople(e1Titulares) == 11 &&
                countPeople(e2Titulares) == 11 &&
                countPeople(e1Suplentes) == 5 &&
                countPeople(e2Suplentes) == 5 &&
                countPeople(arbitros) == 3 &&
                e1Dt != null &&
                e2Dt != null
        ) {
            return false;
        }

        jugando = true;
        return true;
    }
    public boolean End() {
        if (!terminado && jugando) return false;

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

    }
    public void scoreGoal(Jugador aPlayer) {

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
