package cyberpunkbattle.modelo;

import cyberpunkbattle.items.ItemEnemigo;

public class ArasakaJefe extends Arasaka {
    private int bonusJefe = 10;

    public ArasakaJefe(ItemEnemigo habilidad) {
        super(habilidad);
        this.nombre = "Arasaka Jefe";
        this.vida = 120;
        this.ataque += bonusJefe;
    }

    @Override
    public String mensajeInicio() { return "¡Arasaka Jefe libera su poder supremo!"; }

    @Override
    public String mensajeDerrota() { return "El líder de Arasaka ha caído."; }
}
