/**
 * Representa un registro de trabajo para un trabajador médico.
 * Contiene detalles sobre consultas, horas de cirugía, turnos nocturnos y procedimientos realizados.
 */
public class WorkLog {
    private final int consultations;
    private final double surgeryHours;
    private final int nightShifts;
    private final int procedures;

    public WorkLog(int consultations, double surgeryHours, int nightShifts, int procedures) {
        this.consultations = consultations;
        this.surgeryHours = surgeryHours;
        this.nightShifts = nightShifts;
        this.procedures = procedures;
    }
    public int getConsultations() { return consultations; }
    public double getSurgeryHours() { return surgeryHours; }
    public int getNightShifts() { return nightShifts; }
    public int getProcedures() { return procedures; }
}