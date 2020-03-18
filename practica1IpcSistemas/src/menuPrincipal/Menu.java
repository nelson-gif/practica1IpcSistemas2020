package menuPrincipal;
import java.util.Scanner;
public class Menu {
    static Scanner a = new Scanner(System.in);
    public static void menu(){
        int recibir;
        System.out.println("----------------------------------------------------------------");
        System.out.println("Elija una de las siguientes opciones: ");
        System.out.println("1. Nueva Partida");
        System.out.println("2. Ver el Historial de Partidas");
        System.out.println("3. Mostrar puntuaciones mas altas");
        System.out.println("4. Mostar jugadores que no encontraron todas las palabras");
        System.out.println("5. Mostrar jugadores que encontraron todas las palabras");
        System.out.println("6. Mostrar informacion del desarrollador");
        System.out.println("7. Salir");
        System.out.println("-----------------------------------------------------------------");
        recibir = a.nextInt();
        
        switch (recibir) {
            case 1:
                NuevaPartida.NuevaPartida();
                break;
            default:
                throw new AssertionError();
        }
    }
}
