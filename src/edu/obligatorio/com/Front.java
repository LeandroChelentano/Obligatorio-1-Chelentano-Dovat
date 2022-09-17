package edu.obligatorio.com;

import edu.obligatorio.com.classes.Jugador;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Front {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;

    public static void main(String[] args) {
        System.out.println("Bienvenido!\n");

        while (running)
            showMenu();

        System.out.println("\nNos vemos!");
    }

    public static void showMenu() {
        System.out.println("Menu:");
        System.out.println("1- Nuevo jugador");
        System.out.println("2- Eliminar jugador");
        System.out.println("3- Listar jugadores");

        System.out.println("0- Salir (Perdida de datos)");

        System.out.print("\n\t> ");
        String option = scanner.next();



        switch (option) {
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

    public static void newPlayer() {
        System.out.print("\nNombre:\n> ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("\nApellido:\n> ");
        scanner.nextLine();
        String surname = scanner.nextLine();
        System.out.print("\nPuesto:\n> ");
        scanner.nextLine();
        String position = scanner.nextLine();
        System.out.print("\nNúmero:\n> ");
        scanner.nextLine();
        short number = (short) scanner.nextInt();
        System.out.print("\nEdad:\n> ");
        scanner.nextLine();
        short age = (short) scanner.nextInt();

        Jugador player = new Jugador(name, surname, position, number, age);

        Controladora controladora = new Controladora();
        controladora.addPlayer(player);
    }

    public static void listar(Object[] lista) {
        for (int i = 0; i < lista.length; i++)
            System.out.println(i+1 + ": " + lista[i].toString());
    }

    public static void deletePlayer() {

    }


}
