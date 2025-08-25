import java.util.Random;

public class Pokemon {
    private String nombre;
    private String tipo;
    private int ataque;
    private int defensa;
    private HabilidadEspecial habilidad;

    private int ataqueExtra = 0;
    private int defensaExtra = 0; //no se usa :c
    private int penalizacionAlEnemigo = 0;

    public Pokemon(String nombre, String tipo, int ataque, int defensa, HabilidadEspecial habilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.habilidad = habilidad;
    }

    public boolean usarHabilidad() {
        Random r = new Random();
        int numero = r.nextInt(101); 
        return numero <= habilidad.getProbabilidad();
    }

    private int calcularEfectividad(String tipoDefensor) {
        if (tipo.equals("Fuego") && tipoDefensor.equals("Planta")) return 20;
        if (tipo.equals("Fuego") && tipoDefensor.equals("Agua")) return -10;
        if (tipo.equals("Planta") && tipoDefensor.equals("Agua")) return 20;
        if (tipo.equals("Planta") && tipoDefensor.equals("Fuego")) return -10;
        if (tipo.equals("Agua") && tipoDefensor.equals("Fuego")) return 20;
        if (tipo.equals("Agua") && tipoDefensor.equals("Planta")) return -10;
        if (tipo.equals("Eléctrico") && tipoDefensor.equals("Agua")) return 20;
        return 0;
    }

    public int calcularAtaqueTotal(Pokemon enemigo) {
        int tipoBonus = calcularEfectividad(enemigo.getTipo());
        return ataque + ataqueExtra + tipoBonus - enemigo.penalizacionAlEnemigo;
    }

    public void incrementarAtaque(int extra) {
        ataqueExtra += extra;
    }

    public void incrementarDefensa(int extra) {
        defensaExtra += extra;
    }

    public void reducirAtaqueEnemigo(int penalizacion) {
        this.penalizacionAlEnemigo = penalizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public HabilidadEspecial getHabilidad() {
        return habilidad;
    }
}
