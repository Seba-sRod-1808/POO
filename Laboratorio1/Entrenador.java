public class Entrenador {
    private String nombre;
    private Pokemon[] equipo;
    private boolean[] usados;

    public Entrenador(String nombre, Pokemon[] equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.usados = new boolean[4];
    }

    public Pokemon elegirPokemon(int indice) {
        if (indice >= 0 && indice < 4 && !usados[indice]) {
            usados[indice] = true;
            return equipo[indice];
        } else {
            System.out.println("Ese Pokémon ya fue usado o el índice es inválido.");
            return null;
        }
    }

    public String getNombre() {
        return nombre;
    }
}
