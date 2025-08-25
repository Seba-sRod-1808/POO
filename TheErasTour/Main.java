//AUTOR: SEBASTIAN RODAS RODRIGUEZ 25038
//FECHA: 27/07/2025
//PROYECTO: The Eras Tour
// DESCRIPCION: Simulación de compra de boletos para un concierto con localidades y validación de tickets.

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        Localidad loc1 = new Localidad("Localidad 1", 100);
        Localidad loc2 = new Localidad("Localidad 2", 500);
        Localidad loc3 = new Localidad("Localidad 3", 1000);

        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Presupuesto: ");
        double presupuesto = sc.nextDouble();
        System.out.print("Cantidad de boletos: ");
        int cantidad = sc.nextInt();

        Cliente cliente = new Cliente(nombre, email, presupuesto, cantidad);
        System.out.println("Ticket generado: " + cliente.getTicket());

        int a = rand.nextInt(15000) + 1;
        int b = rand.nextInt(15000) + 1;

        if (cliente.validoCompra(a, b)) {
            System.out.println("Ticket apto.");

            int aleatorio = rand.nextInt(3);
            Localidad seleccionada;

            if (aleatorio == 0) {
                seleccionada = loc1;
            } else if (aleatorio == 1) {
                seleccionada = loc2;
            } else {
                seleccionada = loc3;
            }

            System.out.println("Se asignó: " + seleccionada.getNombre(""));
            seleccionada.venderBoleto(cliente.getCantidad(), cliente.getPresupuesto());

        } else {
            System.out.println("Ticket no apto para compra.");
        }

        int totalVendidos = loc1.getVendidos(0) + loc2.getVendidos(0) + loc3.getVendidos(0);
        System.out.println("Total de boletos vendidos: " + totalVendidos);

        System.out.println("Boletos disponibles por localidad:");
        System.out.println(loc1.getNombre("") + ": " + (20 - loc1.getVendidos(0)));
        System.out.println(loc2.getNombre("") + ": " + (20 - loc2.getVendidos(0)));
        System.out.println(loc3.getNombre("") + ": " + (20 - loc3.getVendidos(0)));

        sc.close();
    }
}