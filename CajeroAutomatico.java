import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CajeroAutomatico {
    private static final String ARCHIVO_SALDO = "/Users/randalrosales/Desktop/LABORATORIO I/saldo.data";
    
    public static void main(String[] args) {
        try {
            inicializarSaldo(1000.0); // Si el archivo no existe, se creara uno nuevo con 1,000.00 iniciales.
        } catch (IOException e) {
            System.out.println("Error al inicializar el saldo.");
            return;
        }
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n*********************");
            System.out.println("* Cajero Automático *");
            System.out.println("*********************");
            System.out.println("\n");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        consultarSaldo();
                        break;
                    case 2:
                        System.out.print("Ingrese el monto a retirar: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Error: Por favor expresar el saldo únicamente en términos numéricos.");
                            scanner.next(); // Evita el input de caracteres no deseados como alfanumericos, ya que el monto deberia ser unicamente numeros.
                            continue;
                        }
                        double monto = scanner.nextDouble();
                        retirarDinero(monto);
                        break;
                    case 3:
                        System.out.println("Gracias por usar el cajero automático.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor expresar el saldo únicamente en términos numéricos.");
                scanner.next();
            }
        }
    }
    
    private static void inicializarSaldo(double saldoInicial) throws IOException {
        File archivo = new File(ARCHIVO_SALDO);
        if (!archivo.exists()) {
            escribirSaldo(saldoInicial);
        }
    }
    
    private static double leerSaldo() throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(ARCHIVO_SALDO))) {
            return dis.readDouble();
        }
    }
    
    private static void escribirSaldo(double saldo) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ARCHIVO_SALDO))) {
            dos.writeDouble(saldo);
        }
    }
    
    private static void consultarSaldo() {
        try {
            double saldo = leerSaldo();
            System.out.println("Su saldo actual es: $" + saldo);
        } catch (IOException e) {
            System.out.println("Error al leer el saldo.");
        }
    }
    
    private static void retirarDinero(double monto) {
        try {
            double saldo = leerSaldo();
            if (monto > saldo) {
                System.out.println("Saldo insuficiente. No se puede completar el retiro.");
            } else {
                saldo -= monto;
                escribirSaldo(saldo);
                System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldo);
            }
        } catch (IOException e) {
            System.out.println("Error al procesar el retiro.");
        }
    }
}
