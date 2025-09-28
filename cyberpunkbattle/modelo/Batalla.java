package cyberpunkbattle.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Clase que controla la lógica de la batalla
public class Batalla {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private boolean terminada;
    private LinkedList<String> registroAcciones; // Últimas 3 acciones

    public Batalla(Jugador jugador, List<Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
        this.terminada = false;
        this.registroAcciones = new LinkedList<>();
    }

    public Jugador getJugador() { return jugador; }
    public List<Enemigo> getEnemigos() { return enemigos; }
    public boolean estaTerminada() { return terminada; }

    // Registrar acción y mantener solo las últimas 3
    public void registrarAccion(String accion) {
        registroAcciones.addFirst(accion);
        if (registroAcciones.size() > 3) {
            registroAcciones.removeLast();
        }
    }

    public List<String> getRegistroAcciones() {
        return new ArrayList<>(registroAcciones);
    }

    public void verificarEstado() {
        if (jugador.getVida() <= 0 || enemigos.stream().allMatch(e -> e.getVida() <= 0)) {
            terminada = true;
        }
    }
}
