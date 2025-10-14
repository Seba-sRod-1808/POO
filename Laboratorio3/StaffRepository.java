/**
 * Representa un repositorio para gestionar el personal médico en el sistema de gestión hospitalaria.
 * Permite agregar trabajadores médicos, obtener la lista completa y buscar disponibilidad
 * según el tipo de cita y la fecha.
 */
import java.time.LocalDateTime;
import java.util.*;

public class StaffRepository {
    private final List<MedicalWorker> staff = new ArrayList<>();
    public void add(MedicalWorker m) { staff.add(m); }
    public List<MedicalWorker> all() { return Collections.unmodifiableList(staff); }
    public List<MedicalWorker> availableFor(String type, LocalDateTime date) {
        List<MedicalWorker> out = new ArrayList<>();
        for (MedicalWorker m : staff)
            if (m.canHandle(type) && m.isAvailable(date)) out.add(m);
        return out;
    }
}