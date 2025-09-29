package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public class DronAsesino extends ItemEnemigo {
    public DronAsesino() { super("Dron Asesino"); }

    @Override
    public void activar(Combatiente objetivo) {
        objetivo.setVida(objetivo.getVida() - 30);
    }
}
