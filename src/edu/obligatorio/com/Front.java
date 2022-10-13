package edu.obligatorio.com;

import edu.obligatorio.com.classes.Arbitro;
import edu.obligatorio.com.classes.DT;
import edu.obligatorio.com.classes.Jugador;
import edu.obligatorio.com.classes.Partido;

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
                list(controladora.getJugadores().toArray());
                break;
            case "4":
                newArbitro();
                break;
            case "5":
                deleteArbitro();
                break;
            case "6":
                list(controladora.getArbitro().toArray());
                break;
            case "7":
                newDT();
                break;
            case "8":
                deleteDT();
                break;
            case "9":
                list(controladora.getDT().toArray());
                break;
            case "10":
                newMatch();
                break;
            case "11":
                deleteMatch();
                break;
            case "12":
                list(controladora.getPartidos().toArray());
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
                list(controladora.getPartidos().toArray());
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
    public static void list(Object[] list) {
        System.out.println("\nListado:");
        for (Object obj : list)
            System.out.println(obj.toString());

        if (list.length == 0)
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
        list(controladora.getJugadores().toArray());
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
        list(controladora.getArbitro().toArray());
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
        list(controladora.getDT().toArray());
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
        list(controladora.getPartidos().toArray());
        System.out.println("\nSeleccione el identificador del partido a eliminar:");
        String id = getInput();

        controladora.deleteMatch(Short.parseShort(id));
    }
    public static void startMatch() {
        list(controladora.getPartidos().toArray());
        System.out.println("\nSeleccione el identificador del partido a iniciar:");
        String id = getInput();

        controladora.startMatch(Short.parseShort(id));
    }
    public static void endMatch() {
        list(controladora.getPartidos().toArray());
        System.out.println("\nSeleccione el identificador del partido a terminar:");
        String id = getInput();

        controladora.endMatch(Short.parseShort(id));
    }
    public static void assignPlayer() {
        list(controladora.getPartidos().toArray());
        System.out.println("Seleccione un partido:");
        String matchId = getInput();
        Partido match = controladora.searchMatchById(Short.parseShort(matchId));

        list(controladora.getJugadores().toArray());
        System.out.println("Seleccione un jugador:");
        String playerId = getInput();
        Jugador player = controladora.searchPlayerById(Short.parseShort(playerId));

        System.out.println("Para que equipo?\t[1 o 2]");
        String team = getInput();

        System.out.println("Seria titular?\t[S o N]");
        String isTitularStr = getInput();
        boolean isTitular = isTitularStr.equalsIgnoreCase("S");

        controladora.assignPlayer(match, player, team, isTitular);
    }
    public static void unassignPlayer() {
        list(controladora.getPartidos().toArray());
        System.out.println("Seleccione un partido:");
        String matchId = getInput();
        Partido match = controladora.searchMatchById(Short.parseShort(matchId));

        list(controladora.getJugadores().toArray());
        System.out.println("Seleccione un jugador:");
        String playerId = getInput();
        Jugador player = controladora.searchPlayerById(Short.parseShort(playerId));

        controladora.unassignPlayer(match, player);
    }
//    #endregion
}
