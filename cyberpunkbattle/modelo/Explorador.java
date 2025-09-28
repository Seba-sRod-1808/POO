package cyberpunkbattle.modelo;

import cyberpunkbattle.items.ItemJugador;
import java.util.List;

public class Explorador extends Jugador {
    public Explorador(String nombre, List<ItemJugador> items) {
        super(nombre, 100, 12, items);
    }

    @Override
    public void tomarTurno(Batalla batalla) { }

    @Override
    public String mensajeInicio() { return nombre + " aparece sigilosamente como Explorador."; }

    @Override
    public String mensajeDerrota() { return nombre + " ha sido derrotado."; }
}
