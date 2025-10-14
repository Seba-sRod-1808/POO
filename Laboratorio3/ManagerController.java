/**
 * Controlador que maneja la lógica de negocio para la gestión de citas médicas
 * y personal en un sistema hospitalario.
 * Coordina la asignación de citas, resolución de conflictos, generación de informes
 * y cálculo de utilización del personal médico.
 */

import java.time.LocalDateTime;
import java.util.*;

public class ManagerController {
    private final StaffRepository repo;
    private final AppointmentBook book;
    private final AutoRescheduler rescheduler;
    private final ReportService reports;

    public ManagerController(StaffRepository repo, AppointmentBook book, AutoRescheduler rescheduler, ReportService reports) {
        this.repo = repo;
        this.book = book;
        this.rescheduler = rescheduler;
        this.reports = reports;
    }

    public Appointment assignAppointment(String type, String patient, LocalDateTime time) {
        List<MedicalWorker> candidates = repo.availableFor(type, time);
        if (candidates.isEmpty()) return null;
        MedicalWorker worker = candidates.get(0);
        worker.occupy(time);
        Appointment app = new Appointment(UUID.randomUUID().toString(), patient, type, time, "PROGRAMADA", worker);
        book.add(app);
        return app;
    }

    public void resolveConflicts() {
        List<Appointment> all = book.getAll();
        Map<String, List<Appointment>> byKey = new HashMap<>();
        for (Appointment a : all) {
            String key = a.getWorker().getId() + "@" + a.getDate().toString();
            byKey.computeIfAbsent(key, k -> new ArrayList<>()).add(a);
        }
        for (List<Appointment> group : byKey.values()) {
            if (group.size() > 1) {
                for (int i = 1; i < group.size(); i++) rescheduler.reschedule(group.get(i));
            }
        }
    }

    public Map<String, Double> generateReports() {
        Map<MedicalWorker, WorkLog> logs = new HashMap<>();
        for (MedicalWorker m : repo.all()) {
            int consult = 0, procedures = 0, nights = 0; double surgHours = 0.0;
            for (Appointment a : book.getAll()) {
                if (a.getWorker().equals(m)) {
                    switch (a.getType()) {
                        case "consulta": consult++; break;
                        case "cirugia": surgHours += 2.0; break;
                        case "diagnostico": procedures++; break;
                        case "terapia": procedures++; break;
                    }
                }
            }
            logs.put(m, new WorkLog(consult, surgHours, nights, procedures));
        }
        return reports.payrollByRole(repo.all(), logs);
    }

    public Map<MedicalWorker, Double> utilization(int totalSlots) {
        return reports.utilization(repo.all(), totalSlots);
    }

    public List<String> rescheduleHistory() { return book.getHistory(); }
    public List<Appointment> getAppointmentsByStatus(String s) { return book.getByStatus(s); }
    public List<MedicalWorker> getAllStaff() { return repo.all(); }
}