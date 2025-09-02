public class Socio {
    private int id;
    private String nombre;
    private String tipoMembresia;
    private boolean activo;
    private Integer idRutinaAsignada;      // null si no tiene
    private Integer idEntrenadorAsignado;  // null si no tiene

    public Socio(int id, String nombre, String tipoMembresia) {
        this.id = id;
        this.nombre = nombre;
        this.tipoMembresia = tipoMembresia;
        this.activo = true;
        this.idRutinaAsignada = null;
        this.idEntrenadorAsignado = null;
    }

    public void activar() { this.activo = true; }
    public void desactivar() { this.activo = false; }

    public String resumen() {
        String base = "Socio #" + id + " - " + nombre + " (" + tipoMembresia + ")";
        String estado = activo ? " [Activo]" : " [Inactivo]";
        String asign = "";
        if (idRutinaAsignada != null) {
            asign += " | Rutina=" + idRutinaAsignada;
        }
        if (idEntrenadorAsignado != null) {
            asign += " | Entrenador=" + idEntrenadorAsignado;
        }
        return base + estado + asign;
    }

    // formato de metodo mas legible y compacto :D
    // getters y setters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String n) { this.nombre = n; }
    public String getTipoMembresia() { return tipoMembresia; }
    public void setTipoMembresia(String t) { this.tipoMembresia = t; }
    public boolean isActivo() { return activo; }
    public Integer getIdRutinaAsignada() { return idRutinaAsignada; }
    public void setIdRutinaAsignada(Integer idRutinaAsignada) { this.idRutinaAsignada = idRutinaAsignada; }
    public Integer getIdEntrenadorAsignado() { return idEntrenadorAsignado; }
    public void setIdEntrenadorAsignado(Integer idEntrenadorAsignado) { this.idEntrenadorAsignado = idEntrenadorAsignado; }
}
