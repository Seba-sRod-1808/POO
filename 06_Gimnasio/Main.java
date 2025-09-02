public class Main { // ejecutar esta clase
    public static void main(String[] args) {
        CentralGimnasio sistema = new CentralGimnasio();
        ControladorGimnasio ctrl = new ControladorGimnasio(sistema);
        Vista vista = new Vista(ctrl);

        vista.mostrarMenuPrincipal();
    }
}
