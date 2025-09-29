package cyberpunkbattle.controlador;

import cyberpunkbattle.modelo.*;
import cyberpunkbattle.items.ItemJugador;

public class ControladorBatalla {
    private Batalla batalla;

    public ControladorBatalla(Batalla batalla) {
        this.batalla = batalla;
    }

    public Batalla getBatalla() { return batalla; }

    // Procesar accion del jugador según la opcion elegida
    public void procesarAccionJugador(int opcion, Enemigo enemigoSeleccionado, ItemJugador item) {
        Jugador jugador = batalla.getJugador();

        switch (opcion) {
            case 1 -> { // Ataque normal contra enemigo
                int antes = enemigoSeleccionado.getVida();
                jugador.atacar(enemigoSeleccionado);
                int dmg = Math.max(0, antes - enemigoSeleccionado.getVida());
                batalla.registrarAccion(jugador.getNombre() + " ataco a " +
                        enemigoSeleccionado.getNombre() + " (-" + dmg + " HP)");
            }
            case 2 -> { // Item en si mismo
                if (item == null) {
                    batalla.registrarAccion("No se selecciono item.");
                    break;
                }
                int antes = jugador.getVida();
                jugador.usarItem(item, jugador);
                int delta = jugador.getVida() - antes;
                if (delta > 0) {
                    batalla.registrarAccion(jugador.getNombre() + " uso " + item.getNombre() +
                            " en si mismo (+" + delta + " HP)");
                } else {
                    batalla.registrarAccion(jugador.getNombre() + " activo " + item.getNombre());
                }
            }
            case 3 -> { // Item ofensivo contra enemigo
                if (item == null || enemigoSeleccionado == null) {
                    batalla.registrarAccion("Faltan selecciones para usar item.");
                    break;
                }
                int antes = enemigoSeleccionado.getVida();
                jugador.usarItem(item, enemigoSeleccionado);
                int delta = enemigoSeleccionado.getVida() - antes;
                if (delta < 0) {
                    batalla.registrarAccion(jugador.getNombre() + " uso " + item.getNombre() +
                            " contra " + enemigoSeleccionado.getNombre() + " (" + delta + " HP)");
                } else {
                    batalla.registrarAccion(jugador.getNombre() + " activo " + item.getNombre() +
                            " contra " + enemigoSeleccionado.getNombre());
                }
            }
            case 4 -> batalla.registrarAccion(jugador.getNombre() + " decidió pasar su turno");
            default -> batalla.registrarAccion("Opcion inválida.");
        }
        batalla.verificarEstado();
    }

    // Procesar acción de un enemigo (controlado por el usuario en este caso)
    public void procesarAccionEnemigo(int opcion, Enemigo enemigo, Combatiente objetivo) {
        switch (opcion) {
            case 1 -> { // Ataque normal contra el jugador
                if (objetivo instanceof Jugador j && j.tieneEvasionActiva()) {
                    batalla.registrarAccion(j.getNombre() + " evadió el ataque de " +
                            enemigo.getNombre() + " gracias a las Botas de Salto");
                    j.desactivarEvasion(); // efecto se consume
                } else {
                    int antes = objetivo.getVida();
                    enemigo.atacar(objetivo);
                    int dmg = Math.max(0, antes - objetivo.getVida());
                    batalla.registrarAccion(enemigo.getNombre() + " atacó a " +
                            objetivo.getNombre() + " (-" + dmg + " HP)");
                }
            }

            case 2 -> { // Habilidad especial propia del enemigo
                int antes = objetivo.getVida();
                enemigo.usarHabilidad(objetivo);
                int delta = objetivo.getVida() - antes;
                if (delta < 0) {
                    batalla.registrarAccion(enemigo.getNombre() + " uso " +
                            enemigo.getNombreHabilidad() + " contra " + objetivo.getNombre() +
                            " (-" + Math.abs(delta) + " HP)");
                } else {
                    batalla.registrarAccion(enemigo.getNombre() + " activo " +
                            enemigo.getNombreHabilidad() + " contra " + objetivo.getNombre());
                }
            }
            case 3 -> batalla.registrarAccion(enemigo.getNombre() + " decidió pasar su turno");
            default -> batalla.registrarAccion("Opcion inválida para enemigo.");
        }
        batalla.verificarEstado();
    }
}