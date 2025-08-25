// Archivo: Main.java
public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        LogicaEvento modelo = new LogicaEvento(20, 100);
        ControladorReservas controlador = new ControladorReservas(modelo, vista);

        controlador.iniciarSalonesIniciales();
        controlador.ejecutarMenu();
    }
}
