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

        controladora.addPlayer(new Jugador((short) 0, "Leandro", "Chelentano", "delantero", (short) 10, (short) 19));
        controladora.addMatch(new Partido((short) 0, "La Bombonera", "Hoy", "20:00", "Lloviendo"));

        while (running)
            showMenu();

        System.out.println("\nNos vemos!");
    }

//    #region utils
    public static String alignLeft(String line) {
        if (line.length() == columnWidth) return line;
        if (line.length() > columnWidth) return line.substring(0, columnWidth);

        int spacesLeft = columnWidth - line.length();
        for (int i = 0; i < spacesLeft; i++)
            line += " ";

        return line;
    }
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
            case "0":
                running = false;
                break;
            default:
                System.out.println("Opción incorrecta!");
                break;
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

    // .toArray() returns Object[]
    //
    public static void listPeople(Object neededClass) {
        System.out.println("\nListado:");
        for (Persona person : controladora.getPersonas())
            if (person.getClass().getName().equals(neededClass.getClass().getName()))
                System.out.println(person);

        if (controladora.getPersonas().size() == 0)
            System.out.println("No hay elementos..");
    }
    public static void listMatches() {
        System.out.println("\nListado:");
        for (Partido match : controladora.getPartidos())
            System.out.println(match);

        if (controladora.getPartidos().size() == 0)
            System.out.println("No hay elementos..");
    }
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

        System.out.println("\nEquipo 2:\n\tTitulares:");
        for (Jugador jugador : match.getE2Titulares())
            if (jugador != null)
                System.out.println("\t" + jugador);

        System.out.println("\n\tSuplentes:");
        for (Jugador jugador : match.getE2Suplentes())
            if (jugador != null)
                System.out.println("\t" + jugador);
    }
//    #endregion

//    #region player
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
    public static void deletePlayer() {
        listPeople(new Jugador());
        System.out.println("\nSeleccione el identificador del jugador a eliminar:");
        String id = getInput();

        controladora.deletePlayer(Short.parseShort(id));
    }
//    #endregion

//    #region arbitro
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
    public static void deleteArbitro() {
        listPeople(new Arbitro());
        System.out.println("\nSeleccione el identificador del Arbitro a eliminar:");
        String id = getInput();

        controladora.deleteArbitro(Short.parseShort(id));
    }
//    #endregion

    //    #region DT
    public static void newDT() {
        System.out.print("\nNombre:\n> ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("\nApellido:\n> ");
        String surname = scanner.nextLine();
        System.out.print("\nEdad:\n> ");
        short age = (short) scanner.nextInt();



        DT pDT = new DT((short) 0, name, surname, age );

        controladora.addDT(pDT);
    }
    public static void deleteDT() {
        listPeople(new DT());
        System.out.println("\nSeleccione el identificador del DT a eliminar:");
        String id = getInput();

        controladora.deleteDT(Short.parseShort(id));
    }
//    #endregion

//    #region match
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
    public static void deleteMatch() {
        listMatches();
        System.out.println("\nSeleccione el identificador del partido a eliminar:");
        String id = getInput();

        controladora.deleteMatch(Short.parseShort(id));
    }
    public static void startMatch() {
        listMatches();
        System.out.println("\nSeleccione el identificador del partido a iniciar:");
        String id = getInput();

        controladora.startMatch(Short.parseShort(id));
    }
    public static void endMatch() {
        listMatches();
        System.out.println("\nSeleccione el identificador del partido a terminar:");
        String id = getInput();

        controladora.endMatch(Short.parseShort(id));
    }
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
//    #endregion
}
