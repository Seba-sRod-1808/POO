package cyberpunkbattle.vista;

import cyberpunkbattle.controlador.ControladorBatalla;
import cyberpunkbattle.modelo.*;
import cyberpunkbattle.items.*;
import java.util.Scanner;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class VistaBatalla {
    private ControladorBatalla controlador;
    private Scanner scanner;

    public VistaBatalla(ControladorBatalla controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("=== INICIO DE LA BATALLA ===");
        System.out.println(controlador.getBatalla().getJugador().mensajeInicio());
        for (Enemigo e : controlador.getBatalla().getEnemigos()) {
            System.out.println(e.mensajeInicio());
        }

        // 🔹 Bucle principal: jugador → 1 enemigo → repetir
        while (!controlador.getBatalla().estaTerminada()) {
            mostrarEstadoYRegistro();
            turnoJugador();
            mostrarEstadoYRegistro();
            if (controlador.getBatalla().estaTerminada()) break;

            turnoEnemigoAleatorio();
            mostrarEstadoYRegistro();
        }

        // 🔹 Fin de la batalla
        System.out.println("=== FIN DE LA BATALLA ===");
        if (controlador.getBatalla().getJugador().getVida() <= 0) {
            System.out.println(controlador.getBatalla().getJugador().mensajeDerrota());
        } else {
            System.out.println("¡Has ganado!");
        }
    }

    // ----- Turnos -----
    private void turnoJugador() {
        Jugador j = controlador.getBatalla().getJugador();
        System.out.println("\nTurno de " + j.getNombre() + ":");
        System.out.println("1. Atacar");
        System.out.println("2. Usar ítem en ti mismo");
        System.out.println("3. Usar ítem en enemigo");
        System.out.println("4. Pasar turno");
        int opcion = leerOpcion(1, 4);

        Enemigo enemigo = null;
        ItemJugador item = null;

        if (opcion == 1 || opcion == 3) {
            enemigo = seleccionarEnemigoVivo("Elige enemigo objetivo:");
        }
        if (opcion == 2) {
            item = seleccionarItem(true); // solo ítems defensivos
        } else if (opcion == 3) {
            item = seleccionarItem(false); // solo ítems ofensivos
        }

        controlador.procesarAccionJugador(opcion, enemigo, item);
    }

    private void turnoEnemigoAleatorio() {
        List<Enemigo> vivos = controlador.getBatalla().getEnemigos().stream()
                .filter(e -> e.getVida() > 0).collect(Collectors.toList());
        if (vivos.isEmpty()) return;

        Enemigo enemigo = vivos.get(new Random().nextInt(vivos.size()));
        System.out.println("\nTurno de " + enemigo.getNombre() + ":");
        System.out.println("1. Atacar al jugador");
        System.out.println("2. Usar habilidad especial");
        System.out.println("3. Pasar turno");
        int opcion = leerOpcion(1, 3);

        controlador.procesarAccionEnemigo(opcion, enemigo, controlador.getBatalla().getJugador());
    }

    // ----- Helpers de selección -----
    private Enemigo seleccionarEnemigoVivo(String titulo) {
        List<Enemigo> lista = controlador.getBatalla().getEnemigos().stream()
                .filter(e -> e.getVida() > 0).collect(Collectors.toList());
        System.out.println(titulo);
        for (int i = 0; i < lista.size(); i++) {
            Enemigo e = lista.get(i);
            System.out.println((i + 1) + ". " + e.getNombre() + " (Vida: " + e.getVida() + ")");
        }
        int idx = leerOpcion(1, lista.size()) - 1;
        return lista.get(idx);
    }

    private ItemJugador seleccionarItem(boolean selfUse) {
        Jugador j = controlador.getBatalla().getJugador();
        List<ItemJugador> items;

        if (selfUse) {
            items = j.getItems().stream()
                    .filter(i -> i.getNombre().equals("Poción de Vida") || i.getNombre().equals("Botas de Salto"))
                    .collect(Collectors.toList());
        } else {
            items = j.getItems().stream()
                    .filter(i -> i.getNombre().equals("Francotirador"))
                    .collect(Collectors.toList());
        }

        if (items.isEmpty()) {
            System.out.println("No tienes ítems disponibles para esta acción.");
            return null;
        }

        System.out.println("Elige ítem:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getNombre());
        }
        int idx = leerOpcion(1, items.size()) - 1;
        return items.get(idx);
    }

    private int leerOpcion(int min, int max) {
        int op;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un número válido.");
                scanner.next();
            }
            op = scanner.nextInt();
            if (op < min || op > max) {
                System.out.println("Opción inválida. Debe ser entre " + min + " y " + max + ".");
            }
        } while (op < min || op > max);
        return op;
    }

    private void mostrarEstadoYRegistro() {
        Jugador j = controlador.getBatalla().getJugador();
        System.out.println("\nJugador: " + j.getNombre() + " | Vida: " + j.getVida());
        for (Enemigo e : controlador.getBatalla().getEnemigos()) {
            System.out.println("Enemigo: " + e.getNombre() + " | Vida: " + e.getVida());
        }
        System.out.println("\nÚltimas acciones:");
        for (String acc : controlador.getBatalla().getRegistroAcciones()) {
            System.out.println("- " + acc);
        }
    }
}
