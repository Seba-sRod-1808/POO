package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public abstract class ItemJugador {
    protected String nombre;

    public ItemJugador(String nombre) { this.nombre = nombre; }

    public abstract void usar(Combatiente objetivo);

    public String getNombre() { return nombre; }
}