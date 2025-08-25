public class LogicaEvento {
    public final int MAX_SALONES;
    public final int MAX_RESERVAS;

    private Salon[] salones;
    private int usadosSalones;

    private Reserva[] reservas;
    private int usadasReservas;

    private int proximoIdReserva;

    public LogicaEvento(int maxSal, int maxRes) {
        this.MAX_SALONES = maxSal;
        this.MAX_RESERVAS = maxRes;
        salones = new Salon[MAX_SALONES];
        reservas = new Reserva[MAX_RESERVAS];
        usadosSalones = 0;
        usadasReservas = 0;
        proximoIdReserva = 1;
    }

    public boolean registrarSalon(Salon s) {
        if (usadosSalones < MAX_SALONES) {
            salones[usadosSalones++] = s;
            return true;
        }
        return false;
    }

    public int registrarReservaYAsignar(Reserva r) {
        if (usadasReservas >= MAX_RESERVAS) return -1;

        r.setId(proximoIdReserva++);

        boolean asignado = intentaAsignar(r);
        reservas[usadasReservas++] = r;
        return r.getId();
    }

    private boolean intentaAsignar(Reserva r) {
        for (int i = 0; i < usadosSalones; i++) {
            if (cumpleReglas(r, salones[i])) {
                r.setNumeroSalonAsignado(salones[i].getNumero());
                return true;
            }
        }
        return false;
    }

    private boolean cumpleReglas(Reserva r, Salon s) {
        if (!r.isDepositoPagado()) return false;
        if (s.getTipo().equals("GRANDE") && !r.getTipoEvento().equals("VIP")) return false;
        if (s.getCapacidad() < r.getAsistentes()) return false;
        if (hayTraslape(r.getFecha(), r.getHoraInicio(), r.getHoraFin(), s.getNumero())) return false;
        return true;
    }

    private boolean hayTraslape(String fecha, String hi, String hf, int numSalon) {
        for (int i = 0; i < usadasReservas; i++) {
            Reserva r = reservas[i];
            if (r.getNumeroSalonAsignado() == numSalon && r.getFecha().equals(fecha)) {
                String hi2 = r.getHoraInicio();
                String hf2 = r.getHoraFin();
                if (hi.compareTo(hf2) < 0 && hi2.compareTo(hf) < 0) return true;
            }
        }
        return false;
    }

    public int getUsadosSalones() {
        return usadosSalones;
    }

    public int getUsadasReservas() {
        return usadasReservas;
    }
}
