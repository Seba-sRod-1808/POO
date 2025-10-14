/**
 * Representa el rol de un cirujano en el sistema de gestión hospitalaria.
 * Define las capacidades específicas del rol y cómo se calcula su salario,
 * incluyendo tarifas por hora y un bono por riesgo.
 */
public class SurgeonRole extends StaffRole {
    private final double hourRate, riskBonus;
    public SurgeonRole(double hourRate, double riskBonus) { super("Cirujano"); this.hourRate = hourRate; this.riskBonus = riskBonus; }
    @Override public boolean canHandle(String type) { return type.equals("cirugia"); }
    @Override public double computeSalary(double base, WorkLog log) { return base + (log.getSurgeryHours() * hourRate) + riskBonus; }
}