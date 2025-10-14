/**
 * Representa el rol de un enfermero en el sistema de gestión hospitalaria.
 * Define las capacidades específicas del rol y cómo se calcula su salario,
 * incluyendo un bono por turnos nocturnos.
 */

public class NurseRole extends StaffRole {
    private final boolean night;
    private final double nightBonus;
    public NurseRole(boolean night, double nightBonus) { super("Enfermero"); this.night = night; this.nightBonus = nightBonus; }
    @Override public boolean canHandle(String type) { return type.equals("consulta") || type.equals("terapia") || type.equals("diagnostico"); }
    @Override public double computeSalary(double base, WorkLog log) { return night ? base + nightBonus : base; }
}