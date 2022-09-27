package Utils;

import java.util.Scanner;

public class Utils {
    public static String getTerminalValue(String text) {
        System.out.print(text);
        return new Scanner(System.in).nextLine();
    }
    public static int optionMenu() {
        System.out.println("""
                    Menú principal
                                        
                    1.       Ingreso de automóviles
                                        
                    2.       Ingreso de clientes
                                        
                    3.       Registro de alquiler
                                        
                    4.       Consultar automóviles
                                        
                    5.       Consultar clientes
                                        
                    6.       Consultar alquileres
                                        
                    7.       Consultar alquileres por cliente
                                        
                    8.       Salir
                    """);
        System.out.print("R: ");
        Scanner sc = new Scanner(System.in);

        return Integer.parseInt(sc.nextLine());
    }
}
