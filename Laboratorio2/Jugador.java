public class Jugador {
    private String nombre;
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntaje = 0;
    }

    public void incrementarPuntaje() {
        puntaje++;
    }

    public String getNombre() { return nombre; }
    public int getPuntaje() { return puntaje; }
}
