import java.util.Scanner;

public class Vista {
    private Scanner in = new Scanner(System.in);

    public void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Registrar nuevo salón");
        System.out.println("2. Registrar nueva reserva");
        System.out.println("3. Mostrar resumen");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }

    public int leerOpcion() {
        return Integer.parseInt(in.nextLine());
    }

    public Salon leerSalon() {
        System.out.println("\n--- Registro de Salón ---");
        System.out.print("Numero: ");
        int numero = Integer.parseInt(in.nextLine());
        System.out.print("Tipo (Pequeño, mediano o grande): ");
        String tipo = in.nextLine();
        System.out.print("Capacidad: ");
        int capacidad = Integer.parseInt(in.nextLine());
        System.out.print("Costo por hora: ");
        double costoHora = Double.parseDouble(in.nextLine());
        return new Salon(numero, tipo, capacidad, costoHora);
    }

    public Reserva leerReserva() {
        System.out.println("\n--- Registro de Reserva ---");
        System.out.print("Encargado: ");
        String encargado = in.nextLine();
        System.out.print("Tipo de evento (Normal o VIP): ");
        String tipoEvento = in.nextLine();
        System.out.print("Fecha en AAAA-MM-DD:");
        String fecha = in.nextLine();
        System.out.print("Hora inicio en HH:MM: ");
        String horaInicio = in.nextLine();
        System.out.print("Hora fin en HH:MM: ");
        String horaFin = in.nextLine();
        System.out.print("Cantidad de asistentes: ");
        int asistentes = Integer.parseInt(in.nextLine());
        System.out.print("Pago de deposito realizado? (true o false): ");
        boolean depositoPagado = Boolean.parseBoolean(in.nextLine());
        return new Reserva(encargado, tipoEvento, fecha, horaInicio, horaFin, asistentes, depositoPagado);
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
