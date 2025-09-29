package cyberpunkbattle.modelo;

import cyberpunkbattle.items.ItemEnemigo;

public class Militech extends Enemigo {
    protected String poderCorporativo = "Poder militar";

    public Militech(ItemEnemigo habilidad) {
        super("Militech", 90, 14, habilidad);
    }

    @Override
    public void tomarTurno(Batalla batalla) { }

    @Override
    public String mensajeInicio() { return "Militech despliega su " + poderCorporativo; }

    @Override
    public String mensajeDerrota() { return "Militech ha sido destruida."; }
}
