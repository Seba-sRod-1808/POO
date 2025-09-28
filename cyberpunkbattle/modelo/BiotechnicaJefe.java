package cyberpunkbattle.modelo;

import cyberpunkbattle.items.ItemEnemigo;

public class BiotechnicaJefe extends Biotechnica {
    private int bonusJefe = 12;

    public BiotechnicaJefe(ItemEnemigo habilidad) {
        super(habilidad);
        this.nombre = "Biotechnica Jefe";
        this.vida = 110;
        this.ataque += bonusJefe;
    }

    @Override
    public String mensajeInicio() { return "¡Biotechnica Jefe muta su poder!"; }

    @Override
    public String mensajeDerrota() { return "El líder de Biotechnica fue destruido."; }
}
