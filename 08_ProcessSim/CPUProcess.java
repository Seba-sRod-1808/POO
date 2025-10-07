// Proceso que simula trabajo intensivo de CPU
public class CPUProcess extends Process {

    public CPUProcess(int pid, String name) {
        super(pid, name);
    }

    @Override
    public String execute() {
        return "CPUProcess [" + pid + "] corriendo: " + performCalculation();
    }

    // Ejemplo de acción encapsulada en un método auxiliar (es simulación)
    private String performCalculation() {
        return "escaneando RAM...";
    }
}
