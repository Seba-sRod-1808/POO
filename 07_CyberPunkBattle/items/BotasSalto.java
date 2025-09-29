package cyberpunkbattle.items;

import cyberpunkbattle.modelo.Combatiente;
import cyberpunkbattle.modelo.Jugador;

public class BotasSalto extends ItemJugador {
    public BotasSalto() {
        super("Botas de Salto");
    }

    @Override
    public void usar(Combatiente objetivo) {
        if (objetivo instanceof Jugador j) {
            if (j.botasDisponibles()) {
                j.activarEvasion();
            } else {
                System.out.println("Las Botas de Salto ya fueron usadas en esta batalla.");
            }
        }
    }
}
