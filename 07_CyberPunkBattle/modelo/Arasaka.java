package cyberpunkbattle.modelo;

import cyberpunkbattle.items.ItemEnemigo;

public class Arasaka extends Enemigo {
    protected String poderCorporativo = "Tecnología letal";

    public Arasaka(ItemEnemigo habilidad) {
        super("Arasaka", 80, 12, habilidad);
    }

    @Override
    public void tomarTurno(Batalla batalla) { }

    @Override
    public String mensajeInicio() { return "Arasaka despliega su " + poderCorporativo; }

    @Override
    public String mensajeDerrota() { return "Arasaka ha sido neutralizada."; }
}
