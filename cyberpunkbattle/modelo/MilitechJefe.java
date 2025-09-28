package cyberpunkbattle.modelo;

import cyberpunkbattle.items.ItemEnemigo;

public class MilitechJefe extends Militech {
    private int bonusJefe = 15;

    public MilitechJefe(ItemEnemigo habilidad) {
        super(habilidad);
        this.nombre = "Militech Jefe";
        this.vida = 130;
        this.ataque += bonusJefe;
    }

    @Override
    public String mensajeInicio() { return "¡Militech Jefe activa sus drones de asalto!"; }

    @Override
    public String mensajeDerrota() { return "El líder de Militech ha sido eliminado."; }
}
