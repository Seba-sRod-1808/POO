// Proceso similar a un servicio en segundo plano (simulado)
public class DaemonProcess extends Process {

    public DaemonProcess(int pid, String name) {
        super(pid, name);
    }

    @Override
    public String execute() {
        return "DaemonProcess [" + pid + "] corriendo: " + monitor();
    }

    // Ejemplo de acción encapsulada en un método auxiliar
    private String monitor() {
        return "monitorizando conexiones de red.";
    }
}
