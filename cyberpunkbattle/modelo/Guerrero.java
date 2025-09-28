package cyberpunkbattle.modelo;

import cyberpunkbattle.items.ItemJugador;
import java.util.List;

public class Guerrero extends Jugador {
    public Guerrero(String nombre, List<ItemJugador> items) {
        super(nombre, 120, 15, items);
    }

    @Override
    public void tomarTurno(Batalla batalla) { }

    @Override
    public String mensajeInicio() { return nombre + " entra en la batalla como Guerrero."; }

    @Override
    public String mensajeDerrota() { return nombre + " ha caído en combate."; }
}
