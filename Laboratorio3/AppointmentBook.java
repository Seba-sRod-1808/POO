/**
 * Gestiona un conjunto de citas médicas, permitiendo agregar nuevas citas,
 * filtrar por estado y mantener un historial de cambios.
 */
import java.util.*;

public class AppointmentBook {
    private final List<Appointment> appointments = new ArrayList<>();
    private final List<String> history = new ArrayList<>();

    public void add(Appointment app) { appointments.add(app); }
    public List<Appointment> getAll() { return Collections.unmodifiableList(appointments); }
    public List<Appointment> getByStatus(String s) {
        List<Appointment> out = new ArrayList<>();
        for (Appointment a : appointments) if (a.getStatus().equals(s)) out.add(a);
        return out;
    }
    public List<String> getHistory() { return Collections.unmodifiableList(history); }
    public void markRescheduled(Appointment app, String note) { history.add("Cita " + app.getId() + " -> " + note); }
}