import edu.obligatorio.com.Jugador;

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

        String option = scanner.next();

        switch (option) {
            case "1":
                newPlayer();
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
        System.out.println("Nombre:\n>");
        String name = scanner.nextLine();
        System.out.println("Apellido:\n>");
        String surname = scanner.nextLine();
        System.out.println("Puesto:\n>");
        String position = scanner.nextLine();
        System.out.println("Número:\n>");
        short number = (short) scanner.nextInt();
        System.out.println("Edad:\n>");
        short age = (short) scanner.nextInt();

        Jugador player = new Jugador(name, surname, position, number, age);

        // upload this to controller list
    }
}
