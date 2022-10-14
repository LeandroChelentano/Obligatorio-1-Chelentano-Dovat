package edu.obligatorio.com;

import edu.obligatorio.com.classes.*;

import java.util.Scanner;

public class Front {
    private static Controladora controladora = new Controladora();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("Bienvenido!\nObligatorio realizado por: \n\t- Leandro Chelentano\n\t- Guadalupe Dovat");

        controladora.addPlayer(new Jugador((short) 0, "Leandro", "Chelentano", "delantero", (short) 10, (short) 19));
        controladora.addMatch(new Partido((short) 0, "La Bombonera", "Hoy", "20:00", "Lloviendo"));

        while (running)
            showMenu();

        System.out.println("\nNos vemos!");
    }

//    #region utils
    public static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println(" 1- Nuevo jugador");
        System.out.println(" 2- Eliminar jugador");
        System.out.println(" 3- Listar jugadores");
        System.out.println(" 4- Nuevo Arbitro");
        System.out.println(" 5- Eliminar Arbitro");
        System.out.println(" 6- Listar Arbitro");
        System.out.println(" 7- Nuevo DT");
        System.out.println(" 8- Eliminar DT");
        System.out.println(" 9- Listar DT");
        System.out.println(" 10- Nuevo partido");
        System.out.println(" 11- Eliminar partido");
        System.out.println(" 12- Listar Partidos");
        System.out.println(" 13- Iniciar partido");
        System.out.println(" 14- Terminar Partido");
        System.out.println(" 15- Asignar jugador a partido");
        System.out.println(" 16- Remover jugador de partido");
        System.out.println(" 17- Mostrar asignaciones de partido");

        System.out.println("\n0- Salir (Perdida de datos)");

        switch (getInput()) {
            case "1":
                newPlayer();
                break;
            case "2":
                deletePlayer();
                break;
            case "3":
                listPeople(new Jugador());
                break;
            case "4":
                newArbitro();
                break;
            case "5":
                deleteArbitro();
                break;
            case "6":
                listPeople(new Arbitro());
                break;
            case "7":
                newDT();
                break;
            case "8":
                deleteDT();
                break;
            case "9":
                listPeople(new DT());
                break;
            case "10":
                newMatch();
                break;
            case "11":
                deleteMatch();
                break;
            case "12":
                listMatches();
                break;
            case "13":
                startMatch();
                break;
            case "14":
                endMatch();
                break;
            case "15":
                assignPlayer();
                break;
            case "16":
                unassignPlayer();
                break;
            case "17":
                listMatches();
                System.out.println("Escoja un partido:");
                Partido match = controladora.searchMatchById(Short.parseShort(getInput()));
                showMatch(match);
                break;
            case "0":
                running = false;
                break;
            default:
                System.out.println("Opción incorrecta!");
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
