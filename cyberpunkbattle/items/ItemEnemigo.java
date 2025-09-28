package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public abstract class ItemEnemigo {
    protected String nombre;

    public ItemEnemigo(String nombre) { this.nombre = nombre; }

    public abstract void activar(Combatiente objetivo);

    public String getNombre() { return nombre; }
}
