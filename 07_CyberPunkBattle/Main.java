package cyberpunkbattle;

import cyberpunkbattle.modelo.*;
import cyberpunkbattle.items.*;
import cyberpunkbattle.controlador.*;
import cyberpunkbattle.vista.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Se crea el jugador con su rol y su inventario inicial
        Jugador jugador = new Guerrero("V",
                new ArrayList<>(Arrays.asList(new PocionVida(), new BotasSalto(), new Francotirador())));

        // Se generan los enemigos: 1 de cada corporación, cada uno con probabilidad de ser jefe
        List<Enemigo> enemigos = generarEnemigosAleatorios();

        // Se inicia la batalla con el jugador y los enemigos
        Batalla batalla = new Batalla(jugador, enemigos);
        ControladorBatalla controlador = new ControladorBatalla(batalla);
        VistaBatalla vista = new VistaBatalla(controlador);

        // Se lanza el simulador
        vista.mostrarMenu();
    }

    // Genera exactamente 3 enemigos, uno de cada corporación
    // Cada uno tiene probabilidad de 1/3 de aparecer en su versión jefe
    private static List<Enemigo> generarEnemigosAleatorios() {
        Random r = new Random();
        List<Enemigo> lista = new ArrayList<>();

        for (int corp = 0; corp < r.nextInt(3) + 1; corp++) {
            boolean jefe = (r.nextInt(3) == 0); // probabilidad 1/3 de jefe
            switch (corp) {
                case 0 -> {
                    if (jefe) lista.add(new ArasakaJefe(new KatanaLaser()));
                    else lista.add(new Arasaka(new Katana()));
                }
                case 1 -> {
                    if (jefe) lista.add(new BiotechnicaJefe(new VirusMutante()));
                    else lista.add(new Biotechnica(new Virus()));
                }
                case 2 -> {
                    if (jefe) lista.add(new MilitechJefe(new DronAsesino()));
                    else lista.add(new Militech(new Dron()));
                }
            }
        }
        return lista;
    }
}
