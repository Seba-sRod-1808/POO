// Proceso que simula operaciones de I/O
public class IOProcess extends Process {

    public IOProcess(int pid, String name) {
        super(pid, name);
    }

    @Override
    public String execute() {
        return "IOProcess [" + pid + "] corriendo: " + performIO();
    }

    // Ejemplo de acción encapsulada en un método auxiliar que es llamado por execute()
    private String performIO() {
        return "guardando datos en un archivo en disco.";
    }
}
