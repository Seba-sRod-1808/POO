package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public class KatanaLaser extends ItemEnemigo {
    public KatanaLaser() { super("Katana Láser"); }

    @Override
    public void activar(Combatiente objetivo) {
        objetivo.setVida(objetivo.getVida() - 35);
    }
}
