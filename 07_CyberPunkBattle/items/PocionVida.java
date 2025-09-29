package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public class PocionVida extends ItemJugador {
    public PocionVida() { super("Poción de Vida"); }

    @Override
    public void usar(Combatiente objetivo) {
        objetivo.setVida(objetivo.getVida() + 30);
    }
}
