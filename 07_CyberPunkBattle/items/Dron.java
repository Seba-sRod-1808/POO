package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public class Dron extends ItemEnemigo {
    public Dron() { super("Dron"); }

    @Override
    public void activar(Combatiente objetivo) {
        objetivo.setVida(objetivo.getVida() - 15);
    }
}
