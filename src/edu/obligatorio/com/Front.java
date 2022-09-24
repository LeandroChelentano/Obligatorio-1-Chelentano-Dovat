package edu.obligatorio.com;

import edu.obligatorio.com.classes.Jugador;

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

    public static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1- Nuevo jugador");
        System.out.println("2- Eliminar jugador");
        System.out.println("3- Listar jugadores");

        System.out.println("\n0- Salir (Perdida de datos)");

        switch (getInput()) {
            case "1":
                newPlayer();
                break;
            case "2":
                deletePlayer();
                break;
            case "3":
                listar(Controladora.getJugadores().toArray());
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

    public static void listar(Object[] lista) {
        System.out.println("\nListado:");
        for (Object obj : lista)
            System.out.println(obj.toString());
    }

    public static void deletePlayer() {
        listar(Controladora.getJugadores().toArray());
        System.out.println("\nSeleccione el identificador del jugador a eliminar:");
        String id = getInput();

        controladora.deletePlayer(Short.valueOf(id));
    }
}
