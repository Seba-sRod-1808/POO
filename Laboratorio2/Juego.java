import java.util.*;

public class Juego {
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador turnoActual;

    public void iniciarNuevaPartida(int filas, int columnas) {
        List<String> simbolos = new ArrayList<>();
        int pares = (filas * columnas) / 2;
        for (int i = 0; i < pares; i++) {
            String simbolo = String.valueOf((char) ('A' + i));
            simbolos.add(simbolo);
            simbolos.add(simbolo);
        }
        tablero = new Tablero(filas, columnas, simbolos);
        jugador1 = new Jugador("Jugador 1");
        jugador2 = new Jugador("Jugador 2");
        turnoActual = jugador1;
    }

    public String previsualizarJugada(int f1, int c1, int f2, int c2) throws Exception {
        Ficha ficha1 = null;
        try {
            ficha1 = tablero.revelarFicha(f1, c1);
            Ficha ficha2 = tablero.revelarFicha(f2, c2);
            return ficha1.getSimbolo().equals(ficha2.getSimbolo()) ? "acierto" : "fallo";
        } catch (Exception e) {
            if (ficha1 != null) tablero.ocultarFicha(f1, c1);
            throw e;
        }
    }

    public void confirmarJugada(int f1, int c1, int f2, int c2, boolean acierto) {
        if (acierto) {
            tablero.obtenerFicha(f1, c1).emparejar();
            tablero.obtenerFicha(f2, c2).emparejar();
            turnoActual.incrementarPuntaje();
        } else {
            tablero.ocultarFicha(f1, c1);
            tablero.ocultarFicha(f2, c2);
            cambiarTurno();
        }
    }

    private void cambiarTurno() {
        turnoActual = (turnoActual == jugador1) ? jugador2 : jugador1;
    }

    public boolean esFinDeJuego() { return tablero.todasEmparejadas(); }
    public Tablero getTablero() { return tablero; }
    public Jugador getTurnoActual() { return turnoActual; }

    public Jugador getGanador() {
        if (jugador1.getPuntaje() > jugador2.getPuntaje()) return jugador1;
        if (jugador2.getPuntaje() > jugador1.getPuntaje()) return jugador2;
        return null;
    }
}
