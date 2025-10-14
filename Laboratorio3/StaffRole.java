/**
 * Clase abstracta que representa un rol de personal en el sistema de gestión hospitalaria.
 * Define métodos para verificar si el rol puede manejar un tipo específico de cita
 * y para calcular el salario basado en el registro de trabajo.
 */
public abstract class StaffRole {
    protected final String name;
    public StaffRole(String name) { this.name = name; }
    public String getName() { return name; }
    public abstract boolean canHandle(String type);
    public abstract double computeSalary(double base, WorkLog log);
}