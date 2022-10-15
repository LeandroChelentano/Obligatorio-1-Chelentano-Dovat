package edu.obligatorio.com;

import edu.obligatorio.com.classes.*;

import java.util.Scanner;

public class Front {
    private static Controladora controladora = new Controladora();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;
    private static int columnWidth = 25;

    public static void main(String[] args) {
        System.out.println("\n\nBienvenido!\nObligatorio realizado por: \n\t- Leandro Chelentano\n\t- Guadalupe Dovat");
        System.out.println("\nTutorial: Ej. Para crear un jugador se debe introducir 11.");

        controladora.addPlayer(new Jugador((short) 0, "Fernando", "Muslera", "portero", (short) 1, (short) 19));
        controladora.addPlayer(new Jugador((short) 1, "Sebastián", "Sosa", "portero", (short) 23, (short) 36));
        controladora.addPlayer(new Jugador((short) 2, "Ronal", "Araujo", "defensa central", (short) 4, (short) 23));
        controladora.addPlayer(new Jugador((short) 4, "Agustin", "Ragel", "defensa central", (short) 2, (short) 24));
        controladora.addPlayer(new Jugador((short) 5, "Sebastián", "Cáceres", "defensa central", (short) 3, (short) 23));
        controladora.addPlayer(new Jugador((short) 6, "Leandro", "Cabrera", "defensa central", (short) 26, (short) 31));
        controladora.addPlayer(new Jugador((short) 7, "Martin", "Cáceres", "defensa central", (short) 22, (short) 35));
        controladora.addPlayer(new Jugador((short) 8, "Mathías", "Olivera", "Lateral izquierdo", (short) 17, (short) 24));
        controladora.addPlayer(new Jugador((short) 9, "Guillermo", "Varela", "Lateral derecho", (short) 10, (short) 19));
        controladora.addPlayer(new Jugador((short) 10, "Leandro", "Chelentano", "delantero", (short) 13, (short) 34));
        controladora.addPlayer(new Jugador((short) 11, "Lucas", "Torreira", "Pivote", (short) 14, (short) 26));
        controladora.addPlayer(new Jugador((short) 12, "Manuel", "Ugarte", "Pivote", (short) 25, (short) 21));
        controladora.addPlayer(new Jugador((short) 13, "Federico", "Valverde", "Mediocentro", (short) 7, (short) 25));
        controladora.addPlayer(new Jugador((short) 14, "Rodrigo", "Bentacour", "Mediocentro", (short) 6, (short) 25));
        controladora.addPlayer(new Jugador((short) 15, "Matías", "Vecino", "Mediocentro", (short) 5, (short) 31));
        controladora.addPlayer(new Jugador((short) 16, "Giorgian", "de Arrscaeta", "Mediocentro ofensivo", (short) 10, (short) 28));
        controladora.addPlayer(new Jugador((short) 17, "Diego", "Rossi", "Extremo izquierdo", (short) 20, (short) 24));
        controladora.addPlayer(new Jugador((short) 18, "Agustin", "Canaobio", "Extremo derecho", (short) 18, (short) 24));
        controladora.addPlayer(new Jugador((short) 19, "Brian", "Ocampo", "Delantero centro", (short) 11, (short) 23));
        controladora.addPlayer(new Jugador((short) 20, "Luis", "Suarez", "Delantero centro", (short) 9, (short) 35));
        controladora.addPlayer(new Jugador((short) 21, "Martín", "Satriano",    "Delantero centro", (short) 19, (short) 21));
        controladora.addPlayer(new Jugador((short) 22, "Roberto", "Sanchez", "portero", (short) 1, (short) 24));
        controladora.addPlayer(new Jugador((short) 23, "David", "Gea", "portero", (short) 35, (short) 31));
        controladora.addPlayer(new Jugador((short) 24, "Iñaki", "Peña", "Mediocentro", (short) 23, (short) 23));
        controladora.addPlayer(new Jugador((short) 25, "Unai", "Simon", "Delantero centro", (short) 20, (short) 25));
        controladora.addPlayer(new Jugador((short) 26, "Oscar", "Mingueza", "Extremo izquierdo", (short) 21, (short) 23));
        controladora.addPlayer(new Jugador((short) 27, "Cesar", "Azpilicueta", "Pivote", (short) 33, (short) 33));
        controladora.addPlayer(new Jugador((short) 28, "Diego", "Llorente", "Pivote", (short) 17, (short) 29));
        controladora.addPlayer(new Jugador((short) 29, "Aymeric", "Laporte", "Mediocentro", (short) 15, (short) 28));
        controladora.addPlayer(new Jugador((short) 30, "Hugo", "Guillamón", "Extremo izquierdo", (short) 12, (short) 22));
        controladora.addPlayer(new Jugador((short) 31, "Oscar", "Gil", "Extremo derecho", (short) 18, (short) 24));

        controladora.addMatch(new Partido((short) 0, "La Bombonera", "Hoy", "20:00", "Lloviendo"));
        Partido match = controladora.searchMatchById((short) 0);

        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 0), true);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 1), true);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 2), true);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 3), true);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 4), true);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 5), true);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 6), true);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 7), true);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 8), true);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 9), true);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 10), true);

        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 11), false);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 12), false);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 13), false);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 14), false);
        match.addPlayerToTeamOne((Jugador) controladora.searchPeople((short) 15), false);

        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 16), true);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 17), true);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 18), true);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 19), true);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 20), true);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 21), true);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 22), true);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 23), true);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 24), true);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 25), true);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 26), true);

        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 27), false);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 28), false);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 29), false);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 30), false);
        match.addPlayerToTeamTwo((Jugador) controladora.searchPeople((short) 31), false);

        controladora.addArbitro(new Arbitro((short) 33, "Diego", "Alba", "Arbitro Central"));
        controladora.addArbitro(new Arbitro((short) 34, "Héctor", "Baldassi", "Arbitro Lareal Derecho"));
        controladora.addArbitro(new Arbitro((short) 35, "Leandro", "Chelentano", "Arbitro Lareal Isquierdo"));
        match.assignReferee((Arbitro) controladora.searchPeople((short) 33));
        match.assignReferee((Arbitro) controladora.searchPeople((short) 34));
        match.assignReferee((Arbitro) controladora.searchPeople((short) 35));

        controladora.addDT(new DT((short) 36, "Oscar", "Tabarez", (short) 75));
        controladora.addDT(new DT((short) 37, "Luis", "Martínez", (short) 51));
        match.setE1Dt((DT) controladora.searchPeople((short) 36));
        match.setE2Dt((DT) controladora.searchPeople((short) 37));

        while (running)
            showMenu();

        System.out.println("\nNos vemos!");
    }

//    #region utils
    public static String[] alignLeft(String[] lines) {
        String[] toReturn = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == null) {
                toReturn[i] = " ";
                continue;
            }

            String line = lines[i];

            if (line.length() == columnWidth) {
                toReturn[i] = line;
                continue;
            }

            if (line.length() > columnWidth) {
                toReturn[i] = line.substring(0, columnWidth);
                continue;
            }

            int spacesLeft = columnWidth - line.length();
            for (int k = 0; k < spacesLeft; k++)
                line += " ";

            toReturn[i] = line;
        }
        return toReturn;
    }
    public static void showMenu() {
        System.out.println("\nMenu:");

        String[] header = {"1. Jugadores", "2. Arbitros", "3. Directores Técnicos", "4. Partidos"};

        String f = "";
        for (String s : header)
            f += "%" + columnWidth + "s";

        System.out.format(f + "\n", alignLeft(header));

        String[][] menuData = {
                {
                    //  Jugadores
                        " 1. Nuevo",
                        " 2. Eliminar",
                        " 3. Listar",
                },
                {
                    //  Arbitros
                        " 1. Nuevo",
                        " 2. Eliminar",
                        " 3. Listar",
                },
                {
                    //  Directores Tecnicos
                        " 1. Nuevo",
                        " 2. Eliminar",
                        " 3. Listar",
                },
                {
                    //  Partidos
                        " 1. Nuevo",
                        " 2. Eliminar",
                        " 3. Listar",
                        " 4. Asignar",
                        " 5. Remover jugador",
                        " 6. Mostrar asignaciones",
                        " 7. Iniciar",
                        " 8. Finalizar",
                        " 9. Meter gol",
                        " 0. Hacer cambio",
                },
        };

        int rows = 0;
        for (String[] col : menuData)
            if (col.length > rows) rows = col.length;

        for (int k = 0; k < rows; k++) {
            String[] data = new String[menuData.length];
            String format = "";
            for (int i = 0; i < menuData.length; i++) {
                try {
                    data[i] = menuData[i][k];
                } catch (Exception e) {
                    data[i] = null;
                }
                format += "%" + columnWidth + "s";
            }
            System.out.format(format + "\n", alignLeft(data));
        }

        System.out.println("\n0- Salir (Perdida de datos)");

        try {
            switch (getInput()) {
                case "11":
                    newPlayer();
                    break;
                case "12":
                    deletePlayer();
                    break;
                case "13":
                    listPeople(new Jugador());
                    break;
                case "21":
                    newArbitro();
                    break;
                case "22":
                    deleteArbitro();
                    break;
                case "23":
                    listPeople(new Arbitro());
                    break;
                case "31":
                    newDT();
                    break;
                case "32":
                    deleteDT();
                    break;
                case "33":
                    listPeople(new DT());
                    break;
                case "41":
                    newMatch();
                    break;
                case "42":
                    deleteMatch();
                    break;
                case "43":
                    listMatches();
                    break;
                case "44":
                    assignMenu();
                    break;
                case "45":
                    unassignPlayer();
                    break;
                case "46":
                    listMatches();
                    System.out.println("Escoja un partido:");
                    Partido match = controladora.searchMatchById(Short.parseShort(getInput()));
                    showMatch(match);
                    break;
                case "47":
                    startMatch();
                    break;
                case "48":
                    endMatch();
                    break;
                case "49":
                    score();
                    break;
                case "40":
                    changePlayer();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Opción incorrecta!");
                    break;
            }
        } catch (Exception e) {
            System.out.println("\nHa ocurrido un error. Volvamos al menu..\n");
        }
    }

    public static void assignMenu() {
        System.out.println("Que deseas asignar?\n1. Jugador\n2. Director Tecnico\n3. Arbitro");

        String option = getInput();
        switch (option) {
            case "1":
                assignPlayer();
                break;
            case "2":
                assignDT();
                break;
            case "3":
                assignReferee();
                break;
        }
    }

    public static String getInput() {
        System.out.print("\n\t> ");
        return scanner.next();
    }

    // listPeople is a method that prints in the console objects that extends Persona class
    // as a param we receive an object, then on the loop we condition the print, doing it only if the
    // person object class is the same as the class of the object we passed as a param
    public static void listPeople(Object neededClass) {
        System.out.println("\nListado:");
        for (Persona person : controladora.getPersonas())
            if (person.getClass().getName().equals(neededClass.getClass().getName()))
                System.out.println(person);

        if (controladora.getPersonas().size() == 0)
            System.out.println("No hay elementos..");
    }

    // this is a simple method that loops the list of matches and prints them
    public static void listMatches() {
        System.out.println("\nListado:");
        for (Partido match : controladora.getPartidos())
            System.out.println(match);

        if (controladora.getPartidos().size() == 0)
            System.out.println("No hay elementos..");
    }

    // this method receives a match as param, and prints the players on each team
    public static void showMatch(Partido match) {
        System.out.println(match.toString());

        System.out.println("\nEquipo 1:\n\tTitulares:");
        for (Jugador jugador : match.getE1Titulares())
            if (jugador != null)
                System.out.println("\t" + jugador);

        System.out.println("\n\tSuplentes:");
        for (Jugador jugador : match.getE1Suplentes())
            if (jugador != null)
                System.out.println("\t" + jugador);

        DT e1DT = match.getE1DT();
        if (e1DT != null) System.out.println("\nArbitro equipo 1: " + e1DT);

        System.out.println("\nEquipo 2:\n\tTitulares:");
        for (Jugador jugador : match.getE2Titulares())
            if (jugador != null)
                System.out.println("\t" + jugador);

        System.out.println("\n\tSuplentes:");
        for (Jugador jugador : match.getE2Suplentes())
            if (jugador != null)
                System.out.println("\t" + jugador);

        DT e2DT = match.getE2DT();
        if (e2DT != null) System.out.println("\nArbitro equipo 1: " + e2DT);

        System.out.println("\nArbitros:");
        for (Arbitro referee : match.getReferees())
            if (referee != null)
                System.out.println("\t" + referee);
    }
//    #endregion

//    #region player

    // this is the method responsible for collecting the info of the new player, then calling the controller class
    // in order to effectively add the player
    public static void newPlayer() {
        System.out.print("\nNombre:\n> ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("\nApellido:\n> ");
        String surname = scanner.nextLine();
        System.out.print("\nPuesto:\n> ");
        String position = scanner.nextLine();
        System.out.print("\nNúmero:\n> ");
        short number = (short) scanner.nextInt();
        System.out.print("\nEdad:\n> ");
        short age = (short) scanner.nextInt();

        Jugador player = new Jugador((short) 0, name, surname, position, number, age);

        controladora.addPlayer(player);
    }

    // this is a simple method that calls the listPeople method in order to list all the players,
    // sand then we select an id of one of them
    public static void deletePlayer() {
        listPeople(new Jugador());
        System.out.println("\nSeleccione el identificador del jugador a eliminar:");
        String id = getInput();

        controladora.deletePlayer(Short.parseShort(id));
    }
//    #endregion

//    #region arbitro

    // this is the method responsible for collecting the info of the new referee, then calling the controller class
    // in order to effectively add the referee
    public static void newArbitro() {
        System.out.print("\nNombre:\n> ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("\nApellido:\n> ");
        String surname = scanner.nextLine();
        System.out.print("\nPuesto:\n> ");
        String position = scanner.nextLine();

        Arbitro pArbitro = new Arbitro((short) 0, name, surname, position);

        controladora.addArbitro(pArbitro);
    }

    // this is a simple method that calls the listPeople method in order to list all the referees, and
    // then we select an id of one of them
    public static void deleteArbitro() {
        listPeople(new Arbitro());
        System.out.println("\nSeleccione el identificador del Arbitro a eliminar:");
        String id = getInput();

        controladora.deleteArbitro(Short.parseShort(id));
    }
//    #endregion

    //    #region DT

    // this is the method responsible for collecting the info of the new DT, then calling the controller class
    // in order to effectively add the DT
    public static void newDT() {
        System.out.print("\nNombre:\n> ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("\nApellido:\n> ");
        String surname = scanner.nextLine();
        System.out.print("\nEdad:\n> ");
        short age = (short) scanner.nextInt();

        DT dt = new DT((short) 0, name, surname, age );

        controladora.addDT(dt);
    }

    // this is a simple method that calls the listPeople method in order to list all the DTs, and
    // then we select an id of one of them
    public static void deleteDT() {
        listPeople(new DT());
        System.out.println("\nSeleccione el identificador del DT a eliminar:");
        String id = getInput();

        controladora.deleteDT(Short.parseShort(id));
    }
//    #endregion

//    #region match

    // this is the method responsible for collecting the info of the new match, then calling the controller class
    // in order to effectively add the new match
    public static void newMatch() {
        System.out.print("\nEstadio:\n> ");
        scanner.nextLine();
        String estadio = scanner.nextLine();
        System.out.print("\nFecha:\n> ");
        String fecha = scanner.nextLine();
        System.out.print("\nHora:\n> ");
        String hora = scanner.nextLine();
        System.out.print("\nClima:\n> ");
        String clima = scanner.nextLine();

        Partido partido = new Partido((short) 0, estadio, fecha, hora, clima);

        controladora.addMatch(partido);
    }

    // this is a simple method that calls the listPeople method in order to list all the matches, and
    // then we select an id of one of them
    public static void deleteMatch() {
        listMatches();
        System.out.println("\nSeleccione el identificador del partido a eliminar:");
        String id = getInput();

        controladora.deleteMatch(Short.parseShort(id));
    }

    // this method exists in order to select the match that we want to start
    public static void startMatch() {
        listMatches();
        System.out.println("\nSeleccione el identificador del partido a iniciar:");
        String id = getInput();

        controladora.startMatch(Short.parseShort(id));
    }

    // this is the method responsible for collecting the match id, in order to finish it
    public static void endMatch() {
        listMatches();
        System.out.println("\nSeleccione el identificador del partido a terminar:");
        String id = getInput();

        controladora.endMatch(Short.parseShort(id));
    }

    // this method collects the info in order to relate a player with a match
    public static boolean assignPlayer() {
        listMatches();
        System.out.println("Seleccione un partido:");
        String matchId = getInput();
        Partido match = controladora.searchMatchById(Short.parseShort(matchId));

        listPeople(new Jugador());
        System.out.println("Seleccione un jugador:");
        String playerId = getInput();
        Persona player = controladora.searchPeople(Short.parseShort(playerId));

        System.out.println("Para que equipo?\t[1 o 2]");
        String team = getInput();

        System.out.println("Seria titular?\t[S o N]");
        String isTitularStr = getInput();
        boolean isTitular = isTitularStr.equalsIgnoreCase("S");

        if (match == null || !(player instanceof Jugador)) return false;

        controladora.assignPlayer(match, (Jugador) player, team, isTitular);
        return true;
    }

    // this method is used when a player scores a goal
    public static boolean score() {
        listMatches();
        System.out.println("Seleccione un partido:");
        String matchId = getInput();
        Partido match = controladora.searchMatchById(Short.parseShort(matchId));

        showMatch(match);
        System.out.println("Seleccione un jugador:");
        String playerId = getInput();
        Persona player = controladora.searchPeople(Short.parseShort(playerId));

        if (match == null || !(player instanceof Jugador)) return false;

        match.scoreGoal((Jugador) player);
        return true;
    }

    // this method adds a dt to a team inside a match
    public static boolean assignDT() {
        listMatches();
        System.out.println("Seleccione un partido:");
        String matchId = getInput();
        Partido match = controladora.searchMatchById(Short.parseShort(matchId));

        listPeople(new DT());
        System.out.println("Seleccione un director tecnico:");
        String playerId = getInput();
        Persona dt = controladora.searchPeople(Short.parseShort(playerId));

        System.out.println("Para que equipo?\t[1 o 2]");
        String team = getInput();

        if (match == null || !(dt instanceof DT)) return false;

        controladora.assignDT(match, (DT) dt, team);
        return true;
    }

    // this method collects the match and the referee and calls the controller class
    // in order to add a referee inside a match
    public static boolean assignReferee() {
        listMatches();
        System.out.println("Seleccione un partido:");
        String matchId = getInput();
        Partido match = controladora.searchMatchById(Short.parseShort(matchId));

        listPeople(new Arbitro());
        System.out.println("Seleccione un arbitro:");
        String refereeId = getInput();
        Persona referee = controladora.searchPeople(Short.parseShort(refereeId));

        if (match == null || !(referee instanceof Arbitro)) return false;

        controladora.assignReferee(match, (Arbitro) referee);
        return true;
    }

    // this method collects the match and the player and calls the controller class
    // in order to remove a player from a team inside a match
    public static boolean unassignPlayer() {
        listMatches();
        System.out.println("Seleccione un partido:");
        String matchId = getInput();
        Partido match = controladora.searchMatchById(Short.parseShort(matchId));

        listPeople(new Jugador());
        System.out.println("Seleccione un jugador:");
        String playerId = getInput();
        Persona player = controladora.searchPeople(Short.parseShort(playerId));

        if (match == null || !(player instanceof Jugador)) return false;

        controladora.unassignPlayer(match, (Jugador) player);
        return true;
    }

    public static void changePlayer() {
        listMatches();
        System.out.println("Seleccione un partido:");
        String matchId = getInput();
        Partido match = controladora.searchMatchById(Short.parseShort(matchId));

        listPeople(new Jugador());
        System.out.println("Seleccione el jugador a cambiar:");
        String player1 = getInput();
        Persona playerOUT = controladora.searchPeople(Short.parseShort(player1));

        listPeople(new Jugador());
        System.out.println("Seleccione el jugador que entra:");
        String player2 = getInput();
        Persona playerIN = controladora.searchPeople(Short.parseShort(player2));

        match.changePlayer((Jugador) playerIN, (Jugador) playerOUT);
    }
//    #endregion
}
