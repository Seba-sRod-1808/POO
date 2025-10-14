/**
 * Representa el rol de un especialista en el sistema de gestión hospitalaria.
 * Define las capacidades específicas del rol y cómo se calcula su salario,
 * incluyendo comisiones por procedimientos realizados.
 */
public class SpecialistRole extends StaffRole {
    private final String specialtyName;
    private final double commissionPerProcedure;
    public SpecialistRole(String specialtyName, double commissionPerProcedure) {
        super("Especialista");
        this.specialtyName = specialtyName;
        this.commissionPerProcedure = commissionPerProcedure;
    }
    @Override public boolean canHandle(String type) { return type.equals("diagnostico") || type.equals("terapia"); }
    @Override public double computeSalary(double base, WorkLog log) { return base + (log.getProcedures() * commissionPerProcedure); }
}