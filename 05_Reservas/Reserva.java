public class Reserva {
    private int id;
    private String encargado;
    private String tipoEvento;
    private String fecha;
    private String horaInicio;
    private String horaFin;
    private int asistentes;
    private boolean depositoPagado;
    private int numeroSalonAsignado = -1;

    public Reserva(String encargado, String tipoEvento, String fecha,
                   String horaInicio, String horaFin, int asistentes, boolean depositoPagado) {
        this.encargado = encargado;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.asistentes = asistentes;
        this.depositoPagado = depositoPagado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public int getAsistentes() {
        return asistentes;
    }

    public boolean isDepositoPagado() {
        return depositoPagado;
    }

    public int getNumeroSalonAsignado() {
        return numeroSalonAsignado;
    }

    public void setNumeroSalonAsignado(int numeroSalonAsignado) {
        this.numeroSalonAsignado = numeroSalonAsignado;
    }
}