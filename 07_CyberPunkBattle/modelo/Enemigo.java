package cyberpunkbattle.modelo;

import cyberpunkbattle.items.ItemEnemigo;

public abstract class Enemigo extends Combatiente {
    protected ItemEnemigo habilidad;

    public Enemigo(String nombre, int vida, int ataque, ItemEnemigo habilidad) {
        super(nombre, vida, ataque);
        this.habilidad = habilidad;
    }

    public void usarHabilidad(Combatiente objetivo) {
        if (habilidad != null) {
            habilidad.activar(objetivo);
        }
    }

    // Para logging en controlador
    public String getNombreHabilidad() {
        return (habilidad != null) ? habilidad.getNombre() : "Habilidad";
    }
}
