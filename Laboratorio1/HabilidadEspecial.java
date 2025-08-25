public class HabilidadEspecial {
    private String nombre;
    private String efecto;
    private int probabilidad; 

    public HabilidadEspecial(String nombre, String efecto, int probabilidad) {
        this.nombre = nombre;
        this.efecto = efecto;
        this.probabilidad = probabilidad;
    }

    public void aplicarEfecto(Pokemon dueño) {
        if (efecto.equals("ataque")) {
            dueño.incrementarAtaque(15);
        } else if (efecto.equals("defensa")) {
            dueño.incrementarDefensa(20);
        } else if (efecto.equals("daño enemigo")) {
            dueño.reducirAtaqueEnemigo(10);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getEfecto() {
        return efecto;
    }

    public int getProbabilidad() {
        return probabilidad;
    }
}
