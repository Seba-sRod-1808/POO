/**
 * Representa una cita médica en el sistema de gestión hospitalaria.
 * Contiene información sobre el paciente, el tipo de cita, la fecha y hora,
 * el estado de la cita y el trabajador médico asignado.
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    final String id;
    private String patient, type, status;
    private LocalDateTime date;
    final MedicalWorker worker;
    
    public Appointment(String id, String patient, String type, LocalDateTime date, String status, MedicalWorker worker) {
        this.id = id; this.patient = patient; this.type = type; this.date = date; this.status = status; this.worker = worker;
    }
    public String getId() { return id; }
    public String getPatient() { return patient; }
    public String getType() { return type; }
    public LocalDateTime getDate() { return date; }
    public String getStatus() { return status; }
    public MedicalWorker getWorker() { return worker; }
    public void setDate(LocalDateTime newDate) { this.date = newDate; }
    public void setStatus(String s) { this.status = s; }

    @Override public String toString() {
        return "(" + status + ") " + type + " | " + patient + " | " + worker.shortTag() + " | " +
               date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
}