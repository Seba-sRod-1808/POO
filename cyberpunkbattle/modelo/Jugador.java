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
}
