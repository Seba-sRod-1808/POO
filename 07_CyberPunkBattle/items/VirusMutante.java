package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public class VirusMutante extends ItemEnemigo {
    public VirusMutante() { super("Virus Mutante"); }

    @Override
    public void activar(Combatiente objetivo) {
        objetivo.setVida(objetivo.getVida() - 25);
    }
}
