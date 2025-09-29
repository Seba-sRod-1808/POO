package cyberpunkbattle.modelo;

import cyberpunkbattle.items.ItemEnemigo;

public class Biotechnica extends Enemigo {
    protected String poderCorporativo = "Control biológico";

    public Biotechnica(ItemEnemigo habilidad) {
        super("Biotechnica", 70, 10, habilidad);
    }

    @Override
    public void tomarTurno(Batalla batalla) { }

    @Override
    public String mensajeInicio() { return "Biotechnica libera su " + poderCorporativo; }

    @Override
    public String mensajeDerrota() { return "Biotechnica ha sido derrotada."; }
}
