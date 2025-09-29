package cyberpunkbattle.modelo;

public abstract class Combatiente {
    protected String nombre;
    protected int vida;
    protected int ataque;

    public Combatiente(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = Math.max(0, vida); }
    public int getAtaque() { return ataque; }

    public void atacar(Combatiente objetivo) {
        objetivo.setVida(objetivo.getVida() - this.ataque);
    }

    public abstract void tomarTurno(Batalla batalla);
    public abstract String mensajeInicio();
    public abstract String mensajeDerrota();
}
