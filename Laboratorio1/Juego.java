public class Juego {
    private Entrenador e1;
    private Entrenador e2;
    private int ganadas1 = 0;
    private int ganadas2 = 0;

    public Juego(Entrenador e1, Entrenador e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    public void iniciarJuego() {
        for (int i = 0; i < 4; i++) {
            Ronda ronda = new Ronda(i + 1);
            Pokemon p1 = e1.elegirPokemon(i);
            Pokemon p2 = e2.elegirPokemon(i);
            Entrenador ganador = ronda.jugar(p1, p2, e1, e2);
            if (ganador == e1) {
                ganadas1++;
            } else if (ganador == e2) {
                ganadas2++;
            }
        }
    }

    public void mostrarResultados() {
        System.out.println("\nRESULTADOS FINALES:");
        System.out.println(e1.getNombre() + " ganó " + ganadas1 + " ronda(s)");
        System.out.println(e2.getNombre() + " ganó " + ganadas2 + " ronda(s)");

        if (ganadas1 > ganadas2) {
            System.out.println("GANADOR: " + e1.getNombre());
        } else if (ganadas2 > ganadas1) {
            System.out.println("GANADOR: " + e2.getNombre());
        } else {
            System.out.println("EMPATE GENERAL");
        }
    }
}
