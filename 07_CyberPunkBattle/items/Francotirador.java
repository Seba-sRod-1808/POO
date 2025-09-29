package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public class Francotirador extends ItemJugador {
    public Francotirador() { super("Francotirador"); }

    @Override
    public void usar(Combatiente objetivo) {
        objetivo.setVida(objetivo.getVida() - 40);
    }
}
