public class Ejercicio {
    private String nombre;
    private int series;
    private int repeticiones;
    private int duracionMin;

    public Ejercicio(String nombre, int series, int repeticiones, int duracionMin) { // --> Constructor
        this.nombre = nombre;
        this.series = series;
        this.repeticiones = repeticiones;
        this.duracionMin = duracionMin;
    }

    public String detalle() {
        return nombre + " - " + series + "x" + repeticiones + " (" + duracionMin + " min)";
    }

    // Getters/Setters
    public String getNombre() { return nombre; }
    public void setNombre(String n) { this.nombre = n; }
    public int getSeries() { return series; }
    public void setSeries(int s) { this.series = s; }
    public int getRepeticiones() { return repeticiones; }
    public void setRepeticiones(int r) { this.repeticiones = r; }
    public int getDuracionMin() { return duracionMin; }
    public void setDuracionMin(int m) { this.duracionMin = m; }
}
