// EntryPoint del programa, aca se instancia todo y se lanza la simulacion
public class Main {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        ProcessView view = new ProcessView();
        ProcessController controller = new ProcessController(scheduler, view);

        // Procesos son registrados
        controller.registerProcess(new CPUProcess(1, "CalcRAM"));
        controller.registerProcess(new IOProcess(2, "SaveReport"));
        controller.registerProcess(new DaemonProcess(3, "NetWatcher"));
        controller.registerProcess(new OrphanProcess(4, "ZombieProc"));

        // Ejecuta todos los procesos y muestra los resultados en la vista
        controller.startExecution();
    }
}
