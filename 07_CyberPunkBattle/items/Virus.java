package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public class Virus extends ItemEnemigo {
    public Virus() { super("Virus"); }

    @Override
    public void activar(Combatiente objetivo) {
        objetivo.setVida(objetivo.getVida() - 10);
    }
}
