import java.util.Scanner;

public class VistaMemoria {
    private ControladorMemoria controlador;
    private Scanner entrada;

    public VistaMemoria(ControladorMemoria controlador) {
        this.controlador = controlador;
        this.entrada = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int n = pedirTamanoTablero();
        controlador.iniciarPartida(n, n);
        System.out.println("¡Juego de Memoria iniciado con tablero " + n + "x" + n + "!");

        while (!controlador.hayGanador()) {
            System.out.println("\nTurno de: " + controlador.obtenerTurno().getNombre());
            imprimirTablero(controlador.obtenerVistaTablero());

            try {
                System.out.print("Fila 1 (1-" + n + "): ");
                int f1 = entrada.nextInt() - 1;
                System.out.print("Columna 1 (1-" + n + "): ");
                int c1 = entrada.nextInt() - 1;
                System.out.print("Fila 2 (1-" + n + "): ");
                int f2 = entrada.nextInt() - 1;
                System.out.print("Columna 2 (1-" + n + "): ");
                int c2 = entrada.nextInt() - 1;

                String resultado = controlador.previsualizarJugada(f1, c1, f2, c2);

                if (!resultado.startsWith("error")) {
                    imprimirTablero(controlador.obtenerVistaTablero());
                }

                switch (resultado) {
                    case "acierto" -> {
                        controlador.confirmarJugada(f1, c1, f2, c2, true);
                        System.out.println("¡Bien hecho! Encontraste un par.");
                    }
                    case "fallo" -> {
                        System.out.println("No coinciden. Se ocultarán las fichas...");
                        controlador.confirmarJugada(f1, c1, f2, c2, false);
 
                    }
                    default -> {
                        if (resultado.startsWith("error")) {
                            System.out.println(resultado);
                            entrada.nextLine(); // limpiar el buffer si hubo error
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
                entrada.nextLine();
            }
        }
        mostrarGanador();
    }

    private int pedirTamanoTablero() {
        int n;
        while (true) {
            try {
                System.out.print("Ingrese el tamaño del tablero NxN: ");
                n = entrada.nextInt();
                if (n <= 1) { System.out.println("Debe ser mayor a 1."); continue; }
                if ((n * n) % 2 != 0) { System.out.println("N^2 debe ser PAR."); continue; }
                return n;
            } catch (Exception e) {
                System.out.println("Ingrese un numero entero válido.");
                entrada.nextLine();
            }
        }
    }

    private void imprimirTablero(String[][] simbolos) {
        for (int i = 0; i < simbolos.length; i++) {
            for (int j = 0; j < simbolos[i].length; j++) {
                System.out.print(simbolos[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void mostrarGanador() {
        Jugador ganador = controlador.getGanador();
        if (ganador == null) {
            System.out.println("Empate");
        } else {
            System.out.println("Ganó: " + ganador.getNombre() + " con " + ganador.getPuntaje() + " pares.");
        }
    }
}
