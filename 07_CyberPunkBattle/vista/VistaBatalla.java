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

    // metodo principal que gestiona el flujo del juego
    public void mostrarMenu() {
        System.out.println("=== INICIO DE LA BATALLA ===");
        System.out.println(controlador.getBatalla().getJugador().mensajeInicio());
        for (Enemigo e : controlador.getBatalla().getEnemigos()) {
            System.out.println(e.mensajeInicio());
        }

        // Bucle principal, jugador y un enemigo se alternan hasta que la batalla termine
        while (!controlador.getBatalla().estaTerminada()) {
            mostrarEstadoYRegistro();   // Mostrar estado actual y últimas acciones
            turnoJugador();              // Turno del jugador
            mostrarEstadoYRegistro();
            if (controlador.getBatalla().estaTerminada()) break;

            turnoEnemigoAleatorio();    // Un enemigo aleatorio toma su turno
            mostrarEstadoYRegistro();
        }

        // mensaje final de la batalla
        System.out.println("=== FIN DE LA BATALLA ===");
        if (controlador.getBatalla().getJugador().getVida() <= 0) {
            System.out.println(controlador.getBatalla().getJugador().mensajeDerrota());
        } else {
            System.out.println("¡Has ganado!");
        }
    }

    // === Turnos ===

    // Turno del jugador con su menu de acciones
    private void turnoJugador() {
        Jugador j = controlador.getBatalla().getJugador();
        System.out.println("\nTurno de " + j.getNombre() + ":");
        System.out.println("1. Atacar");
        System.out.println("2. Usar item en ti mismo");
        System.out.println("3. Usar item en enemigo");
        System.out.println("4. Pasar turno");
        int opcion = leerOpcion(1, 4);

        Enemigo enemigo = null;
        ItemJugador item = null;

        // Si ataca o usa item ofensivo, debe elegir un enemigo
        if (opcion == 1 || opcion == 3) {
            enemigo = seleccionarEnemigoVivo("Elige enemigo objetivo:");
        }
        // Si usa item en si mismo, se filtran solo los defensivos
        if (opcion == 2) {
            item = seleccionarItem(true);
        // Si usa item en un enemigo, se filtran solo los ofensivos
        } else if (opcion == 3) {
            item = seleccionarItem(false);
        }

        // se le pasa la accion al controlador
        controlador.procesarAccionJugador(opcion, enemigo, item);
    }

    // Turno de un enemigo aleatorio entre los que siguen vivos
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

        // Se le pasa la acción al controlador
        controlador.procesarAccionEnemigo(opcion, enemigo, controlador.getBatalla().getJugador());
    }

    // === Helpers ===

    // le deja al jugador seleccionar un enemigo vivo de la lista
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

    // deja elegir un item según el contexto, selfuse y ofensivos
    private ItemJugador seleccionarItem(boolean selfUse) {
        Jugador j = controlador.getBatalla().getJugador();
        List<ItemJugador> items;

        if (selfUse) {
            // Solo pocion y botas aparecen como opciones, hardcodeado lo siento :c
            items = j.getItems().stream()
                    .filter(i -> i.getNombre().equals("Pocion de Vida") || i.getNombre().equals("Botas de Salto"))
                    .collect(Collectors.toList());
        } else {
            // Solo francotirador aparece como ofensivo, hardcodeado lo siento :c
            items = j.getItems().stream()
                    .filter(i -> i.getNombre().equals("Francotirador"))
                    .collect(Collectors.toList());
        }

        if (items.isEmpty()) {
            System.out.println("No tenes items disponibles para esta accion");
            return null;
        }

        System.out.println("Elige item:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getNombre());
        }
        int idx = leerOpcion(1, items.size()) - 1;
        return items.get(idx);
    }

    // metodo auxiliar para validar entrada de opciones de menu
    private int leerOpcion(int min, int max) {
        int op;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Ingrese un numero valido.");
                scanner.next();
            }
            op = scanner.nextInt();
            if (op < min || op > max) {
                System.out.println("Opcion invalida. Debe ser entre " + min + " y " + max + ".");
            }
        } while (op < min || op > max);
        return op;
    }

    // Muestra el estado actual de la batalla y las ultimas 3 acciones registradas
    private void mostrarEstadoYRegistro() {
        Jugador j = controlador.getBatalla().getJugador();
        System.out.println("\nJugador: " + j.getNombre() + " | Vida: " + j.getVida());
        for (Enemigo e : controlador.getBatalla().getEnemigos()) {
            System.out.println("Enemigo: " + e.getNombre() + " | Vida: " + e.getVida());
        }
        System.out.println("\nUltimas acciones:");
        for (String acc : controlador.getBatalla().getRegistroAcciones()) {
            System.out.println("- " + acc);
        }
    }
}