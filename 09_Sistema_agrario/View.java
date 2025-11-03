import java.util.*;

public class View {
    private final SysController controller;
    private final Scanner sc = new Scanner(System.in);

    public View(SysController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        int op;
        do {
            System.out.println("\n=== Cooperativa AgroTec ===");
            System.out.println("1) Listar todos");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Buscar por nombre");
            System.out.println("4) Ordenar por consumo (asc)");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            op = readInt();

            switch (op) {
                case 1 -> showDevices(controller.listAll());
                case 2 -> {
                    System.out.print("ID: ");
                    controller.searchById(sc.nextLine().trim())
                              .ifPresentOrElse(this::showDevice, () -> System.out.println("No encontrado."));
                }
                case 3 -> {
                    System.out.print("Nombre contiene: ");
                    showDevices(controller.searchByName(sc.nextLine().trim()));
                }
                case 4 -> showDevices(controller.orderByConsumption());
                case 0 -> System.out.println("Fin.");
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 0);
    }

    public void showDevices(List<Device> list) {
        if (list.isEmpty()) {
            System.out.println("Sin resultados.");
            return;
        }
        for (Device d : list) System.out.println(d);
        // ejemplo de uso de interfaces, solo que no implementa logica extra
        var medibles = list.stream().filter(d -> d instanceof Measurable).count();
        var accionables = list.stream().filter(d -> d instanceof Actionable).count();
        System.out.println("(Measurables: " + medibles + ", Actionables: " + accionables + ")");
    }

    public void showDevice(Device d) {
        System.out.println(d);
        if (d instanceof Measurable m) System.out.println("measure(): " + m.measure());
        if (d instanceof Actionable a) System.out.println("perform('start'): " + a.perform("start"));
        if (d instanceof Loggable l) {
            l.log("vistazo");
            System.out.println("log size: " + l.getLog().size());
        }
    }

    private int readInt() {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (Exception e) { return -1; }
    }
}
