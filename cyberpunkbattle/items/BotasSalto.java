package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;

public class BotasSalto extends ItemJugador {
    public BotasSalto() { super("Botas de Salto"); }

    @Override
    public void usar(Combatiente objetivo) {
        // Podría marcar al jugador como esquivar próximo ataque
    }
}
