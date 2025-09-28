package cyberpunkbattle.controlador;

import cyberpunkbattle.modelo.*;
import cyberpunkbattle.items.ItemJugador;

public class ControladorBatalla {
    private Batalla batalla;

    public ControladorBatalla(Batalla batalla) {
        this.batalla = batalla;
    }

    public Batalla getBatalla() { return batalla; }

    // Acciones del jugador
    public void procesarAccionJugador(int opcion, Enemigo enemigoSeleccionado, ItemJugador item) {
        Jugador jugador = batalla.getJugador();

        switch (opcion) {
            case 1 -> { // Atacar a un enemigo
                int antes = enemigoSeleccionado.getVida();
                jugador.atacar(enemigoSeleccionado);
                int dmg = Math.max(0, antes - enemigoSeleccionado.getVida());
                batalla.registrarAccion(jugador.getNombre() + " atacó a " +
                        enemigoSeleccionado.getNombre() + " (-" + dmg + " HP)");
            }
            case 2 -> { // Usar ítem en sí mismo
                if (item == null) {
                    batalla.registrarAccion("No se seleccionó ítem.");
                    break;
                }
                int antes = jugador.getVida();
                jugador.usarItem(item, jugador);
                int delta = jugador.getVida() - antes;
                if (delta > 0) {
                    batalla.registrarAccion(jugador.getNombre() + " usó " + item.getNombre() +
                            " en sí mismo (+" + delta + " HP)");
                } else if (delta < 0) {
                    batalla.registrarAccion(jugador.getNombre() + " usó " + item.getNombre() +
                            " en sí mismo (" + delta + " HP)");
                } else {
                    batalla.registrarAccion(jugador.getNombre() + " activó " + item.getNombre());
                }
            }
            case 3 -> { // Usar ítem en enemigo
                if (item == null || enemigoSeleccionado == null) {
                    batalla.registrarAccion("Faltan selecciones para usar ítem.");
                    break;
                }
                int antes = enemigoSeleccionado.getVida();
                jugador.usarItem(item, enemigoSeleccionado);
                int delta = enemigoSeleccionado.getVida() - antes;
                if (delta < 0) {
                    batalla.registrarAccion(jugador.getNombre() + " usó " + item.getNombre() +
                            " contra " + enemigoSeleccionado.getNombre() + " (" + delta + " HP)");
                } else if (delta > 0) {
                    batalla.registrarAccion(jugador.getNombre() + " afectó a " +
                            enemigoSeleccionado.getNombre() + " con " + item.getNombre() +
                            " (+" + delta + " HP)");
                } else {
                    batalla.registrarAccion(jugador.getNombre() + " activó " + item.getNombre() +
                            " contra " + enemigoSeleccionado.getNombre());
                }
            }
            case 4 -> batalla.registrarAccion(jugador.getNombre() + " decidió pasar su turno");
            default -> batalla.registrarAccion("Opción inválida.");
        }
        batalla.verificarEstado();
    }

    // Acciones del enemigo (controladas por el usuario)
    public void procesarAccionEnemigo(int opcion, Enemigo enemigo, Combatiente objetivo) {
        switch (opcion) {
            case 1 -> { // Atacar
                int antes = objetivo.getVida();
                enemigo.atacar(objetivo);
                int dmg = Math.max(0, antes - objetivo.getVida());
                batalla.registrarAccion(enemigo.getNombre() + " atacó a " +
                        objetivo.getNombre() + " (-" + dmg + " HP)");
            }
            case 2 -> { // Habilidad especial
                int antes = objetivo.getVida();
                enemigo.usarHabilidad(objetivo);
                int delta = objetivo.getVida() - antes; // negativo = daño
                String efecto = (delta == 0)
                        ? ("usó " + enemigo.getNombreHabilidad())
                        : (delta < 0 ? "usó " + enemigo.getNombreHabilidad() + " (-" + Math.abs(delta) + " HP)"
                                    : "usó " + enemigo.getNombreHabilidad() + " (+" + delta + " HP)");
                batalla.registrarAccion(enemigo.getNombre() + " " + efecto + " contra " + objetivo.getNombre());
            }
            case 3 -> batalla.registrarAccion(enemigo.getNombre() + " decidió pasar su turno");
            default -> batalla.registrarAccion("Opción inválida para enemigo.");
        }
        batalla.verificarEstado();
    }
}
