public class Ronda {
    private int numero;

    public Ronda(int numero) {
        this.numero = numero;
    }

    public Entrenador jugar(Pokemon p1, Pokemon p2, Entrenador e1, Entrenador e2) {
        System.out.println("\nRONDA " + numero);
        System.out.println(e1.getNombre() + " elige a " + p1.getNombre());
        System.out.println(e2.getNombre() + " elige a " + p2.getNombre());

        if (p1.usarHabilidad()) {
            System.out.println(p1.getNombre() + " activa su habilidad: " + p1.getHabilidad().getNombre());
            p1.getHabilidad().aplicarEfecto(p1);
        }

        if (p2.usarHabilidad()) {
            System.out.println(p2.getNombre() + " activa su habilidad: " + p2.getHabilidad().getNombre());
            p2.getHabilidad().aplicarEfecto(p2);
        }

        int total1 = p1.calcularAtaqueTotal(p2);
        int total2 = p2.calcularAtaqueTotal(p1);

        System.out.println("Ataque total de " + p1.getNombre() + ": " + total1);
        System.out.println("Ataque total de " + p2.getNombre() + ": " + total2);

        if (total1 > total2) {
            System.out.println("Ganador de la ronda: " + e1.getNombre());
            return e1;
        } else if (total2 > total1) {
            System.out.println("Ganador de la ronda: " + e2.getNombre());
            return e2;
        } else {
            System.out.println("Empate en esta ronda.");
            return null;
        }
    }
}
