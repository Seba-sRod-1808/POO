// Clase abstracta que representa un proceso en un sistema operativo
public abstract class Process {
    protected int pid;
    protected String name;

    public Process(int pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    public int getPid() { return pid; }
    public String getName() { return name; }

    // Método polimórfico, cada proceso concreto define su propio comportamiento
    public abstract String execute();

    @Override
    public String toString() {
        return "Proceso{pid=" + pid + ", nombre='" + name + "'}";
    }
}
