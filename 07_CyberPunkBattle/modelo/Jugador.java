package cyberpunkbattle.modelo;

import cyberpunkbattle.items.ItemJugador;
import java.util.List;

public abstract class Jugador extends Combatiente {
    protected List<ItemJugador> items;

    public Jugador(String nombre, int vida, int ataque, List<ItemJugador> items) {
        super(nombre, vida, ataque);
        this.items = items;
    }

    public List<ItemJugador> getItems() { return items; }

    public void usarItem(ItemJugador item, Combatiente objetivo) {
        if (items.contains(item)) {
            item.usar(objetivo);
        }
    }

    // logicas para que las botas de salto funcionen
    private boolean evasiónActiva = false;   // true cuando las botas estan activas
    private boolean botasUsadas = false;     // true si ya se usaron en toda la batalla

    public boolean tieneEvasionActiva() {
        return evasiónActiva;
    }

    public void activarEvasion() {
        this.evasiónActiva = true;
        this.botasUsadas = true;
    }

    public void desactivarEvasion() {
        this.evasiónActiva = false;
    }

    public boolean botasDisponibles() {
        return !botasUsadas;
    }

}
