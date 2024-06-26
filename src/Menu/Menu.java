package Menu;

import Busqueda.Busqueda;
import Busqueda.Historial;
import Busqueda.Conversion;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    private static final Historial historial = new Historial();
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);



        while(true) {
            System.out.println("****************************************"
                    + "\nBienvenido al conversor de divisas."
                    + "\n1.- ARS -> BOB"
                    + "\n2.- BOB -> ARS"
                    + "\n3.- BRL -> CLP"
                    + "\n4.- CLP -> BRL"
                    + "\n5.- COP -> USD"
                    + "\n6.- USD -> COP"
                    + "\n7.- Otra conversión"
                    + "\n8.- Mostrar historial de conversiones"
                    + "\n9.- Salir"
                    + "\n****************************************\n");

            int opcion = Integer.parseInt(lectura.nextLine());

            switch(opcion){
                case 1:
                    buscarConversion("ARS", "BOB", lectura);
                    break;
                case 2:
                    buscarConversion("BOB", "ARS", lectura);
                    break;
                case 3:
                    buscarConversion("BRL", "CLP", lectura);
                    break;
                case 4:
                    buscarConversion("CLP", "BRL", lectura);
                    break;
                case 5:
                    buscarConversion("COP", "USD", lectura);
                    break;
                case 6:
                    buscarConversion("USD", "COP", lectura);
                    break;
                case 7:
                    System.out.println("Escriba el código de la moneda de origen:");
                    var monedaOriginal = lectura.nextLine();
                    monedaOriginal = monedaOriginal.toUpperCase();
                    if(monedaOriginal.isEmpty() || !monedaOriginal.matches("[a-zA-Z]+")){
                        System.out.println("No se ingresó una moneda válida.");
                        break;
                    }
                    System.out.println("Escriba el código de la moneda a la que desea convertir:");
                    var monedaDestino = lectura.nextLine();
                    if(monedaDestino.isEmpty() || !monedaDestino.matches("[a-zA-Z]+")){
                        System.out.println("No se ingresó una moneda válida.");
                        break;
                    }
                    monedaDestino = monedaDestino.toUpperCase();
                    buscarConversion(monedaOriginal, monedaDestino, lectura);
                    break;

                case 8:
                    System.out.println("Historial de conversiones:");
                    for(Conversion conversion : historial.getHistorial()){
                        System.out.println(conversion.mostrarConversion());
                    }
                    break;

                case 9:
                    System.out.println("Gracias por usar el conversor de divisas.");
                    System.exit(0);
                    break;
            }
        }
    }
    private static void buscarConversion(String monedaOriginal, String monedaDestino, Scanner lectura) throws IOException, InterruptedException {
        System.out.println("Ingrese la cantidad que desea convertir: ");
        var input = lectura.nextLine();
        if(!input.matches("-?\\d+(\\.\\d+)?")){
            System.out.println("No se ingresó una cantidad válida.");
            return;
        }
        double cantidad = Double.parseDouble(input);
        Busqueda busqueda = new Busqueda();
        double resultado = busqueda.buscarDivisa(monedaOriginal, monedaDestino, cantidad);
        if (resultado == -1) {
            System.out.println("Ocurrió un error al realizar la conversión.");
        }
        Conversion conversion = new Conversion(monedaOriginal, monedaDestino, cantidad, resultado);
        historial.agregarConversion(conversion);
        System.out.printf("El valor de " + cantidad + " " + monedaOriginal + " en " + monedaDestino
               + " es: %.4f\n", resultado);
    }
}
