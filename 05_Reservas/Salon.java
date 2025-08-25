public class Salon {
    private int numero;
    private String tipo;
    private int capacidad;
    private double costoHora;

    public Salon(int numero, String tipo, int capacidad, double costoHora) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.costoHora = costoHora;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getCostoHora() {
        return costoHora;
    }
}
