package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public class Katana extends ItemEnemigo {
    public Katana() { super("Katana"); }

    @Override
    public void activar(Combatiente objetivo) {
        objetivo.setVida(objetivo.getVida() - 20);
    }
}
