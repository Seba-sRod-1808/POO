/**
 * Representa un trabajador médico en el sistema de gestión hospitalaria.
 * Contiene información sobre el trabajador, su rol, salario base y disponibilidad.
 * Proporciona métodos para verificar disponibilidad, manejar citas y calcular salario.
 */

import java.time.LocalDateTime;
import java.util.*;

public class MedicalWorker {
    private final String id;
    private final String name;
    private final StaffRole role;
    private final double baseSalary;
    private final Availability availability;

    public MedicalWorker(String id, String name, StaffRole role, double baseSalary) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.availability = new Availability();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public StaffRole getRole() { return role; }
    public double getBaseSalary() { return baseSalary; }
    public Availability getAvailability() { return availability; }

    public boolean canHandle(String type) { return role.canHandle(type); }
    public boolean isAvailable(LocalDateTime date) { return availability.isFree(date); }
    public void occupy(LocalDateTime date) { availability.occupy(date); }
    public double calculateSalary(WorkLog log) { return role.computeSalary(baseSalary, log); }
    public String shortTag() { return role.getName() + "(" + name + ")"; }

    @Override public String toString() {
        return "[" + role.getName() + "] " + name + " (#" + id + ") base=" + baseSalary;
    }
    @Override public boolean equals(Object o) { return (o instanceof MedicalWorker) && id.equals(((MedicalWorker)o).id); }
    @Override public int hashCode() { return Objects.hash(id); }
}