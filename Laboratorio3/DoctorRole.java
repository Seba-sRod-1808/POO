/**
 * Representa el rol de un doctor en el sistema de gestión hospitalaria.
 * Define las capacidades específicas del rol y cómo se calcula su salario.
 */
public class DoctorRole extends StaffRole {
    private final double consultFee;
    public DoctorRole(double consultFee) { super("Doctor"); this.consultFee = consultFee; }
    @Override public boolean canHandle(String type) { return type.equals("consulta") || type.equals("diagnostico"); }
    @Override public double computeSalary(double base, WorkLog log) { return base + log.getConsultations() * consultFee; }
}