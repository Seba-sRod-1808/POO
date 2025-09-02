import java.util.ArrayList;
import java.util.List;

public class Rutina {
    private int id;
    private String nombre;
    private String objetivo;
    private boolean activa;
    private ArrayList<Ejercicio> ejercicios;

    public Rutina(int id, String nombre, String objetivo) {
        this.id = id;
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.activa = true;
        this.ejercicios = new ArrayList<>(); // arreglo dinámico de ejercicios
    }

    public void activar() { this.activa = true; }
    public void desactivar() { this.activa = false; }

    public boolean agregarEjercicio(Ejercicio e) {
        if (e == null) return false; // verificación rapida de ejercicio con valor nulo
        return ejercicios.add(e);
    }

    public boolean eliminarEjercicioPorNombre(String nombre) {
        for (int i = 0; i < ejercicios.size(); i++) { // for i in len(ejercicios)
            Ejercicio ex = ejercicios.get(i); // obtener ejercicio en la posición i
            if (ex.getNombre().equalsIgnoreCase(nombre)) { // verificar si el nombre coincide
                ejercicios.remove(i); // eliminar ejercicio
                return true;
            }
        }
        return false;
    }

    public int totalEjercicios() { return ejercicios.size(); }

    // getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String n) { this.nombre = n; }
    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String o) { this.objetivo = o; }
    public boolean isActiva() { return activa; }
    public List<Ejercicio> getEjercicios() { return ejercicios; }
}
