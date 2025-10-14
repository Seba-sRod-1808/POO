/**
 * Reprograma automáticamente citas médicas en caso de conflictos de horario.
 * Intenta mover la cita a una hora posterior con el mismo trabajador,
 * o asignarla a otro trabajador disponible del mismo tipo.
 */

import java.time.LocalDateTime;
import java.util.List;

public class AutoRescheduler {
    private final StaffRepository repo;
    private final AppointmentBook book;

    public AutoRescheduler(StaffRepository repo, AppointmentBook book) {
        this.repo = repo; this.book = book;
    }

    public boolean reschedule(Appointment app) {
        LocalDateTime t = app.getDate();
        MedicalWorker w = app.getWorker();
        for (int i = 1; i <= 4; i++) {
            LocalDateTime cand = t.plusHours(i);
            if (w.isAvailable(cand)) {
                w.occupy(cand);
                app.setDate(cand);
                app.setStatus("REAGENDADA");
                book.markRescheduled(app, "Reagendada a " + cand);
                return true;
            }
        }
        List<MedicalWorker> others = repo.availableFor(app.getType(), t.plusHours(1));
        for (MedicalWorker ow : others) {
            if (!ow.equals(w)) {
                ow.occupy(t.plusHours(1));
                app.setDate(t.plusHours(1));
                app.setStatus("REAGENDADA");
                book.markRescheduled(app, "Asignada a otro trabajador y movida a " + t.plusHours(1));
                return true;
            }
        }
        return false;
    }
}