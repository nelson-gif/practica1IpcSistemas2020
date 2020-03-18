package menuPrincipal;

import java.util.Random;

public class NuevaPartida {

    public static String BancoPalabras[];
    public static String tablero[][];
    private static String name;
    private static int tamanyo;
    private static Random random;
    private static String palabra;
    private static String palabratemporal;
    private static String vtemporal[];
    private static int posiciones[][];
    private static int f;

    public static void NuevaPartida() {
        posiciones = new int [50][3];
        f = 0;
        //limpiando el buffer
        (Menu.a).nextLine();
        System.out.println("Ingrese su usuario");
        name = (Menu.a).nextLine();
        //Menu.a.nextLine();
        System.out.println("Ingrese el tamaño del tablero");
        //Menu.a.nextLine();
        tamanyo = Menu.a.nextInt();
        tablero = new String[tamanyo][tamanyo];

        menuNewP();

    }

    public static void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print("[" + tablero[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public static void menuNewP() {
        System.out.println("");
        System.out.println("-----------------------------------------");
        System.out.println("Bienvenido al juego " + name + " ,que desea hacer: ");
        System.out.println("1. Ingresar Palabras");
        System.out.println("2. Jugar");
        System.out.println("3. Terminar Partida");
        Menu.a.nextLine();
        int que = Menu.a.nextInt();
        System.out.println("------------------------------------------");
        switch (que) {
            case 1:
                ingresoPalabras();
                break;
            case 2:
                imprimirTablero();
            break;
            case 3:
                Menu.menu();
            break;
        }
    }

    public static void ingresoPalabras() {
        System.out.println("-----------------------------------------");
        System.out.println("Elija una opcion:");
        System.out.println("1. insertar");
        System.out.println("2. modificar");
        System.out.println("3. eliminar");
        System.out.println("4. salir");
        System.out.println("-----------------------------------------");
        Menu.a.nextLine();
        int o = Menu.a.nextInt();
        switch (o) {
            case 1:
                BancoPalabras = new String[20];
                System.out.println("Cuantas palabras desea ingresar?");
                Menu.a.nextLine();
                int d = Menu.a.nextInt();

                for (int i = 0; i < d; i++) {

                    System.out.println("Ingrese una palabra de 5-10 caracteres");
                    Menu.a.nextLine();
                    palabra = Menu.a.nextLine();

                    if (palabra.length() < 5 || palabra.length() > 10) {
                        i--;
                        System.out.println("La palabra no cumple con los requisitos indicados");
                    } else {
                        BancoPalabras[i] = palabra;
                        random = new Random();
                        int ale = random.nextInt(2);

                        if (ale == 1) {
                            vertical();
                        } else {
                            horizontal();
                        }

                    }

                }
                Aleatorias();
                ingresoPalabras();
            break;
            case 2:
                Modificar_Eliminar.Modificar();
            break;
            case 3:
                Modificar_Eliminar.Eliminar();
            break;
            case 4:
                menuNewP();
            break;
        }
    }

    public static void vertical() {
        random = new Random();
        int columna = random.nextInt(tamanyo);
        int fila = random.nextInt(tamanyo);

        for (int i = 0; i < 20; i++) {
            if (BancoPalabras[i] == null) {
                i = 20;
            } else {

                palabratemporal = BancoPalabras[i];
                vtemporal = new String[palabratemporal.length() + 1];

                for (int j = 0; j < palabratemporal.length(); j++) {
                    char temporals = palabratemporal.charAt(j);
                    vtemporal[j] = "" + temporals;
                }

                int a = 0;

                while (a < palabratemporal.length()) {
                    if (tablero[fila][columna] == null) {
                        if (fila > (tamanyo - 10)) {
                            fila -= 10;
                        }
                        if (fila < 0) {
                            fila = 0;
                        }
                        if (fila >= 0 && fila <= (tamanyo - 10)) {
                            tablero[fila][columna] = vtemporal[a];
                            posiciones[f][0]=fila;
                            posiciones[f][1]=columna;
                            posiciones[f][2]=0;
                            f++;
                            //horizontal = 1
                            //vertical = 0
                            fila++;
                            a++;
                        }
                    } else {
                        columna = random.nextInt(tamanyo);
                        fila = random.nextInt(tamanyo);
                    }

                }
            }

        }
    }

    public static void horizontal() {
        random = new Random();
        int columna = random.nextInt(tamanyo);
        int fila = random.nextInt(tamanyo);
        int f = 0;
        for (int i = 0; i < 20; i++) {
            if (BancoPalabras[i] == null) {
                
                i = 20;
            } else {

                palabratemporal = BancoPalabras[i];
                vtemporal = new String[palabratemporal.length() + 1];

                for (int j = 0; j < palabratemporal.length(); j++) {
                    char temporals = palabratemporal.charAt(j);
                    vtemporal[j] = "" + temporals;
                }

                int a = 0;

                while (a < palabratemporal.length()) {
                    if (tablero[fila][columna] == null) {
                        if (columna > (tamanyo - 10)) {
                            columna -= 10;
                        }
                        if (columna < 0) {
                            columna = 0;
                        }
                        if (columna >= 0 && columna <= (tamanyo - 10)) {
                            tablero[fila][columna] = vtemporal[a];
                            posiciones[f][0]=fila;
                            posiciones[f][1]=columna;
                            posiciones[f][2]=1;
                            f++;
                            //horizontal = 1
                            //vertical = 0
                            i++;
                            columna++;
                            a++;
                        }
                    } else {
                        columna = random.nextInt(tamanyo);
                        fila = random.nextInt(tamanyo);
                    }

                }
            }

        }
    }

    public static void Aleatorias() {
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                String letras = new String("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
                Random noLetra = new Random();
                byte posLetra = (byte) noLetra.nextInt(letras.length());
                char aleatorio = letras.charAt(posLetra);
                if (tablero[i][j] == null) {
                    tablero[i][j]=""+aleatorio;
                } else {
                    
                }
            }
        }

    }

}
