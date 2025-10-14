/**
 * Clase principal del sistema de gestión hospitalaria.
 * Inicializa los componentes del sistema y ejecuta una demostración de sus funcionalidades.
 * Coordina la interacción entre el repositorio de personal, el libro de citas, el reprogramador automático,
 * el servicio de informes, el controlador del gerente y la vista del gerente.
 */

public class Main {
    public static void main(String[] args) {
        // Inicialización del ecosistema MVC
        StaffRepository repo = SeedData.makeRepository();
        AppointmentBook book = new AppointmentBook();
        AutoRescheduler rescheduler = new AutoRescheduler(repo, book);
        ReportService reports = new ReportService();
        ManagerController controller = new ManagerController(repo, book, rescheduler, reports);

        // La vista maneja toda la interacción con el usuario
        ManagerView view = new ManagerView(controller);
        view.runDemo();
    }
}