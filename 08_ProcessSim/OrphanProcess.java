// Proceso huérfano (simulado)
public class OrphanProcess extends Process {

    public OrphanProcess(int pid, String name) {
        super(pid, name);
    }

    @Override
    public String execute() {
        return "OrphanProcess [" + pid + "] corriendo: " + idle();
    }

    // Ejemplo de acción encapsulada en un método auxiliar que es llamado por execute()
    private String idle() {
        return "esperando recursos sin padre asignado.";
    }
}
