import javax.security.auth.login.AppConfigurationEntry.LoginModuleControlFlag;

public class ControladorReservas {
    private LogicaEvento modelo;
    private Vista vista;
    private boolean activo = true;

    public ControladorReservas(LogicaEvento modelo, Vista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciarSalonesIniciales() {
        vista.mostrarMensaje("\n=== Registro de Salones Iniciales ===");
        for (int i = 0; i < 4; i++) {
            Salon s = vista.leerSalon();
            modelo.registrarSalon(s);
        }
    }

    public void ejecutarMenu() {
        while (activo) {
            vista.mostrarMenu();
            int opcion = vista.leerOpcion();

            switch (opcion) {
                case 1:
                    accionRegistrarSalon();
                    break;
                case 2:
                    accionRegistrarReserva();
                    break;
                case 3:
                    accionListarBasico();
                    break;
                case 0:
                    activo = false;
                    break;
                default:
                    vista.mostrarMensaje("Opcion invalida");
            }
        }
    }

    public void accionRegistrarSalon() {
        Salon s = vista.leerSalon();
        boolean exito = modelo.registrarSalon(s);
        if (exito) {
            vista.mostrarMensaje("Salon registrado correctamente.\n");
        } else {
            vista.mostrarMensaje("No se pudo registrar el salon.\n");
        }
    }

    public void accionRegistrarReserva() {
        Reserva r = vista.leerReserva();
        int id = modelo.registrarReservaYAsignar(r);
        if (id != -1) {
            vista.mostrarMensaje("Reserva registrada con ID: " + id);
        } else {
            vista.mostrarMensaje("No se pudo registrar la reserva.\n");
        }
    }

    public void accionListarBasico() {
        vista.mostrarMensaje("Total salones: " + modelo.getUsadosSalones());
        vista.mostrarMensaje("Total reservas: " + modelo.getUsadasReservas());
    }
}
