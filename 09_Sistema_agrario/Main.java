public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        SysController controller = new SysController(catalog);
        View view = new View(controller);
        controller.init();       // carga de datos
        view.showMenu();         // toda la interacción se hace en la vista
    }
}
