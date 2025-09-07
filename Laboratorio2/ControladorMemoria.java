public class ControladorMemoria {
    private Juego juego;

    public ControladorMemoria(Juego juego) { this.juego = juego; }

    public void iniciarPartida(int filas, int columnas) {
        juego.iniciarNuevaPartida(filas, columnas);
    }

    public String previsualizarJugada(int f1, int c1, int f2, int c2) {
        try {
            return juego.previsualizarJugada(f1, c1, f2, c2);
        } catch (Exception e) {
            return "error: " + e.getMessage();
        }
    }

    public void confirmarJugada(int f1, int c1, int f2, int c2, boolean acierto) {
        juego.confirmarJugada(f1, c1, f2, c2, acierto);
    }

    public String[][] obtenerVistaTablero() { return juego.getTablero().vistaSimbolos(); }
    public Jugador obtenerTurno() { return juego.getTurnoActual(); }
    public boolean hayGanador() { return juego.esFinDeJuego(); }
    public Jugador getGanador() { return juego.getGanador(); }
}
