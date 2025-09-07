public class Main {
    public static void main(String[] args) {
        Juego juego = new Juego();
        ControladorMemoria ctrl = new ControladorMemoria(juego);
        VistaMemoria vista = new VistaMemoria(ctrl);

        vista.mostrarMenu();
    }
}
