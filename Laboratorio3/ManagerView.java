/**
 * Vista que maneja la interacción con el usuario para la gestión de citas médicas
 * y personal en un sistema hospitalario.
 * Proporciona menús y opciones para asignar citas, resolver conflictos,
 * generar informes y ver detalles del personal y las citas.
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ManagerView {
    private final ManagerController controller;
    private final Scanner sc = new Scanner(System.in);

    public ManagerView(ManagerController controller) {
        this.controller = controller;
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }

    public void showAppointments(List<Appointment> list) {
        if (list.isEmpty()) {
            System.out.println("No hay citas registradas.");
            return;
        }
        System.out.println("\n== Citas ==");
        for (Appointment a : list) System.out.println(a);
    }

    public void showStaff(List<MedicalWorker> list) {
        System.out.println("\n== Personal Médico ==");
        for (MedicalWorker m : list) System.out.println(m);
    }

    public void showReport(Map<String, Double> rep) {
        System.out.println("\n== Reporte de Nómina ==");
        for (Map.Entry<String, Double> e : rep.entrySet())
            System.out.println(e.getKey() + ": Q" + String.format(Locale.US, "%.2f", e.getValue()));
    }

    // === NUEVO: menú principal ===
    public void runDemo() {
        int opcion;
        do {
            System.out.println("\n========= SISTEMA DEL MANAGER =========");
            System.out.println("1. Asignar cita (Asignación Inteligente)");
            System.out.println("2. Resolver conflictos de horario");
            System.out.println("3. Ver reporte de nómina");
            System.out.println("4. Ver reporte de utilización del personal");
            System.out.println("5. Ver reporte general de personal");
            System.out.println("6. Ver reporte de citas por estado");
            System.out.println("7. Ver historial de reagendamientos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = getInt();

            switch (opcion) {
                case 1 -> assignAppointmentMenu();
                case 2 -> resolveConflictsMenu();
                case 3 -> showPayrollReport();
                case 4 -> showUtilizationReport();
                case 5 -> showStaff(controller.getAllStaff());
                case 6 -> showAppointmentsByStatus();
                case 7 -> showRescheduleHistory();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    // === Submenús ===

    private void assignAppointmentMenu() {
        System.out.println("\n--- Asignar Cita ---");
        System.out.print("Ingrese tipo (consulta / cirugia / diagnostico / terapia): ");
        String tipo = sc.nextLine().trim().toLowerCase();
        System.out.print("Ingrese nombre del paciente: ");
        String paciente = sc.nextLine().trim();
        System.out.print("Ingrese fecha y hora (formato: yyyy-MM-dd HH:mm): ");
        LocalDateTime fecha;
        try {
            fecha = LocalDateTime.parse(sc.nextLine().trim(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        } catch (Exception e) {
            System.out.println("Formato inválido. Cita no creada.");
            return;
        }

        Appointment app = controller.assignAppointment(tipo, paciente, fecha);
        if (app == null)
            System.out.println("No hay personal disponible para esa cita.");
        else
            System.out.println("Cita creada exitosamente: " + app);
    }

    private void resolveConflictsMenu() {
        System.out.println("\n--- Resolviendo conflictos ---");
        controller.resolveConflicts();
        System.out.println("Conflictos revisados y reagendados automáticamente (si era posible).");
    }

    private void showPayrollReport() {
        Map<String, Double> report = controller.generateReports();
        showReport(report);
    }

    private void showUtilizationReport() {
        System.out.println("\n--- Reporte de Utilización ---");
        System.out.print("Ingrese número total de slots del día (ej: 8): ");
        int totalSlots = getInt();
        Map<MedicalWorker, Double> util = controller.utilization(totalSlots);
        for (Map.Entry<MedicalWorker, Double> e : util.entrySet()) {
            System.out.println(e.getKey().shortTag() + ": " + String.format(Locale.US, "%.2f", e.getValue()));
        }
    }

    private void showAppointmentsByStatus() {
        System.out.print("\nIngrese estado (PROGRAMADA / REAGENDADA / COMPLETADA): ");
        String status = sc.nextLine().trim().toUpperCase();
        List<Appointment> list = controller.getAppointmentsByStatus(status);
        showAppointments(list);
    }

    private void showRescheduleHistory() {
        System.out.println("\n--- Historial de Reagendamientos ---");
        for (String h : controller.rescheduleHistory()) System.out.println(h);
    }

    private int getInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }
}
