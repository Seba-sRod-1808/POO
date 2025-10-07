import java.util.ArrayList;
import java.util.List;

// Manejador simple de procesos que los ejecuta secuencialmente
public class Scheduler {
    private final List<Process> processes;

    public Scheduler() {
        this.processes = new ArrayList<>();
    }

    public void addProcess(Process p) {
        processes.add(p);
    }

    // Ejecuta todos los procesos y devuelve sus mensajes
    public List<String> runProcesses() {
        List<String> messages = new ArrayList<>();
        for (Process p : processes) {
            messages.add(p.execute());
        }
        return messages;
    }
}
