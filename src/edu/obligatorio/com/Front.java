package edu.obligatorio.com;

import edu.obligatorio.com.classes.Arbitro;
import edu.obligatorio.com.classes.Jugador;
import edu.obligatorio.com.classes.Partido;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Front {
    private static Controladora controladora = new Controladora();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("Bienvenido!\nObligatorio realizado por: \n\t- Leandro Chelentano\n\t- Guadalupe Dovat");

        while (running)
            showMenu();

        System.out.println("\nNos vemos!");
    }

//    #region utils
    public static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1- Nuevo jugador");
        System.out.println("2- Eliminar jugador");
        System.out.println("3- Listar jugadores");
        System.out.println("4- Nuevo Arbitro");
        System.out.println("5- Eliminar Arbitro");
        System.out.println("6- Listar Arbitro");
        System.out.println("7- Nuevo partido");
        System.out.println("8- Eliminar partido");
        System.out.println("9- Listar Partidos");
        System.out.println("10- Iniciar partido");
        System.out.println("11- Terminar Partido");

        System.out.println("\n0- Salir (Perdida de datos)");

        switch (getInput()) {
            case "1":
                newPlayer();
                break;
            case "2":
                deletePlayer();
                break;
            case "3":
                list(Controladora.getJugadores().toArray());
                break;
            case "4":
                newArbitro();
                break;
            case "5":
                deleteArbitro();
                break;
            case "6":
                list(Controladora.getArbitro().toArray());
                break;
            case "7":
                newMatch();
                break;
            case "8":
                deleteMatch();
                break;
            case "9":
                list(Controladora.getPartidos().toArray());
                break;
            case "10":
                startMatch();
                break;
            case "11":
                endMatch();
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
        list(Controladora.getJugadores().toArray());
        System.out.println("\nSeleccione el identificador del jugador a eliminar:");
        String id = getInput();

        controladora.deletePlayer(Short.valueOf(id));
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
        list(Controladora.getArbitro().toArray());
        System.out.println("\nSeleccione el identificador del Arbitro a eliminar:");
        String id = getInput();

        controladora.deleteArbitro(Short.valueOf(id));
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
        list(Controladora.getPartidos().toArray());
        System.out.println("\nSeleccione el identificador del partido a eliminar:");
        String id = getInput();

        controladora.deleteMatch(Short.valueOf(id));
    }
    public static void startMatch() {
        list(Controladora.getPartidos().toArray());
        System.out.println("\nSeleccione el identificador del partido a iniciar:");
        String id = getInput();

        controladora.startMatch(Short.valueOf(id));
    }
    public static void endMatch() {
        list(Controladora.getPartidos().toArray());
        System.out.println("\nSeleccione el identificador del partido a terminar:");
        String id = getInput();

        controladora.endMatch(Short.valueOf(id));
    }
//    #endregion
}
