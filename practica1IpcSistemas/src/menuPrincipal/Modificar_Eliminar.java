package menuPrincipal;
import java.util.Scanner;
import static menuPrincipal.NuevaPartida.BancoPalabras;
public class Modificar_Eliminar {
    private static Scanner s;
    public static void Modificar(){
        s = new Scanner(System.in);
        System.out.println("ingrese la palabra que desea modificar");
        String a = s.nextLine();
        
        for (int i = 0; i < 20; i++) {
            if (BancoPalabras[0]==null) {
                System.out.println("Aun no ha ingresado palabras.");
            }
            if (BancoPalabras[i]==null) {
                i=20;
            }else
            if (BancoPalabras[i].equals(a)) {
                System.out.println("palabra a modificar : "+BancoPalabras[i]);
                System.out.println("ingrese la nueva palabra");
                s.nextLine();
                String n = s.nextLine();
                BancoPalabras[i]=n;
                System.out.println("palabra modificada: "+BancoPalabras[i]);
            }
        }
        
    }
    
    public static void Eliminar(){
        s = new Scanner(System.in);
        System.out.println("ingrese la palabra que desea eliminar");
        String a = s.nextLine();
        
        for (int i = 0; i < 20; i++) {
            if (BancoPalabras[0]==null) {
                System.out.println("Aun no ha ingresado palabras.");
            }
            if (BancoPalabras[i]==null) {
                i=20;
            }else
            if (BancoPalabras[i].equals(a)) {
                System.out.println("palabra a eliminar : "+BancoPalabras[i]);
                BancoPalabras[i]="f";
                System.out.println("palabra modificada: "+BancoPalabras[i]);
            }
        }
    }
    
    
}
