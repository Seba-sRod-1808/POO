public class Entrenador {
    private int id;
    private String nombre;
    private boolean activo;

    public Entrenador(int id, String nombre) { // --> Constructor
        this.id = id;
        this.nombre = nombre;
        this.activo = true;
    }

    public void activar() { this.activo = true; }
    public void desactivar() { this.activo = false; }

    public String resumen() {
        return "Entrenador #" + id + " - " + nombre + (activo ? " [Activo]" : " [Inactivo]"); // operador ternario para verificar estado rapidamente
    }

    //getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String n) { this.nombre = n; }
    public boolean isActivo() { return activo; }
}
