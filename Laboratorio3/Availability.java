/**
 * Gestiona la disponibilidad de horarios para citas médicas.
 * Permite verificar si un horario está libre y marcar horarios como ocupados.
 */

import java.time.LocalDateTime;
import java.util.*;

public class Availability {
    private final Set<LocalDateTime> occupied = new HashSet<>();
    public boolean isFree(LocalDateTime date) { return !occupied.contains(date); }
    public void occupy(LocalDateTime date) { occupied.add(date); }
}