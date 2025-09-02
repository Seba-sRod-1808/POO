public class ControladorGimnasio {
    private CentralGimnasio central;

    public ControladorGimnasio(CentralGimnasio central) {
        this.central = central;
    }

    public Socio registrarSocio(String nombre, String tipo) {
        return central.crearSocio(nombre, tipo);
    }

    public Entrenador registrarEntrenador(String nombre) {
        return central.crearEntrenador(nombre);
    }

    public Rutina registrarRutina(String nombre, String objetivo) {
        return central.crearRutina(nombre, objetivo);
    }

    public boolean asignar(int socioId, int rutinaId, int entrenadorId) {
        return central.asignarRutinaASocio(socioId, rutinaId, entrenadorId);
    }

    public boolean desasignar(int socioId) {
        return central.desasignarRutinaDeSocio(socioId);
    }

    public Rutina rutinaMasPopular() { return central.rutinaMasPopular(); }
    public int totalRutinasActivas() { return central.totalRutinasActivas(); }
    public Entrenador entrenadorConMasAlumnos() { return central.entrenadorConMasAlumnos(); }

    public CentralGimnasio getCentral() { return central; }
}
