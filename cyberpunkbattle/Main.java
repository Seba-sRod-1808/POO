package cyberpunkbattle;

import cyberpunkbattle.modelo.*;
import cyberpunkbattle.items.*;
import cyberpunkbattle.controlador.*;
import cyberpunkbattle.vista.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Inventario del jugador
        Jugador jugador = new Guerrero("V", //siempre es guerrero y si se quiere cambiar el nombre se cambia aquí, no hice menu para eso :c
                new ArrayList<>(Arrays.asList(new PocionVida(), new BotasSalto(), new Francotirador())));

        List<Enemigo> enemigos = generarEnemigosAleatorios();
        Batalla batalla = new Batalla(jugador, enemigos);

        ControladorBatalla controlador = new ControladorBatalla(batalla);
        VistaBatalla vista = new VistaBatalla(controlador);
        vista.mostrarMenu();
    }

    private static List<Enemigo> generarEnemigosAleatorios() {
        Random r = new Random();
        List<Enemigo> lista = new ArrayList<>();

        // 0: Arasaka, 1: Biotechnica, 2: Militech
        for (int corp = 0; corp < r.nextInt(3) + 1; corp++) {
            boolean jefe = (r.nextInt(3) == 0); // probabilidad 1/3 de ser jefe

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