import java.util.List;

// Puente entre el modelo (Scheduler) y la vista (ProcessView)
public class ProcessController {
    private final Scheduler scheduler;
    private final ProcessView view;

    // Constructor
    public ProcessController(Scheduler scheduler, ProcessView view) {
        this.scheduler = scheduler;
        this.view = view;
    }

    // Registra un nuevo proceso en el scheduler
    public void registerProcess(Process p) {
        scheduler.addProcess(p);
    }
    
    // Inicia la ejecución de los procesos y muestra los resultados en la vista
    public void startExecution() {
        List<String> outputs = scheduler.runProcesses();
        for (String msg : outputs) {
            view.showMessage(msg);
        }
    }
}
