import java.util.ArrayList;
import java.util.List;

public class CentralGimnasio {
    private ArrayList<Socio> socios = new ArrayList<>();
    private ArrayList<Entrenador> entrenadores = new ArrayList<>();
    private ArrayList<Rutina> rutinas = new ArrayList<>();
    private int nextSocioId = 1;
    private int nextEntrenadorId = 1;
    private int nextRutinaId = 1;

    public Socio crearSocio(String nombre, String tipoMembresia) {
        Socio s = new Socio(nextSocioId++, nombre, tipoMembresia);
        socios.add(s);
        return s;
    }

    public Socio buscarSocio(int id) {
        for (Socio s : socios) if (s.getId() == id) return s;
        return null;
    }

    public boolean editarSocio(int id, String nombre, String tipo, boolean activo) {
        Socio s = buscarSocio(id);
        if (s == null) return false;
        s.setNombre(nombre);
        s.setTipoMembresia(tipo);
        if (activo) s.activar(); else s.desactivar();
        return true;
    }

    public boolean eliminarSocio(int id) {
        for (int i = 0; i < socios.size(); i++) {
            if (socios.get(i).getId() == id) {
                socios.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Socio> listarSocios(boolean soloActivos) {
        ArrayList<Socio> out = new ArrayList<>();
        for (Socio s : socios) {
            if (!soloActivos || s.isActivo()) out.add(s);
        }
        return out;
    }

    public Entrenador crearEntrenador(String nombre) {
        Entrenador e = new Entrenador(nextEntrenadorId++, nombre);
        entrenadores.add(e);
        return e;
    }

    public Entrenador buscarEntrenador(int id) {
        for (Entrenador e : entrenadores) if (e.getId() == id) return e;
        return null;
    }

    public boolean editarEntrenador(int id, String nombre, boolean activo) {
        Entrenador e = buscarEntrenador(id);
        if (e == null) return false;
        e.setNombre(nombre);
        if (activo) e.activar(); else e.desactivar();
        return true;
    }

    public boolean eliminarEntrenador(int id) {
        for (int i = 0; i < entrenadores.size(); i++) {
            if (entrenadores.get(i).getId() == id) {
                entrenadores.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Entrenador> listarEntrenadores(boolean soloActivos) {
        ArrayList<Entrenador> out = new ArrayList<>();
        for (Entrenador e : entrenadores) {
            if (!soloActivos || e.isActivo()) out.add(e);
        }
        return out;
    }

    public Rutina crearRutina(String nombre, String objetivo) {
        Rutina r = new Rutina(nextRutinaId++, nombre, objetivo);
        rutinas.add(r);
        return r;
    }

    public Rutina buscarRutina(int id) {
        for (Rutina r : rutinas) if (r.getId() == id) return r;
        return null;
    }

    public boolean editarRutina(int id, String nombre, String objetivo, boolean activa) {
        Rutina r = buscarRutina(id);
        if (r == null) return false;
        r.setNombre(nombre);
        r.setObjetivo(objetivo);
        if (activa) r.activar(); else r.desactivar();
        return true;
    }

    public boolean eliminarRutina(int id) {
        for (int i = 0; i < rutinas.size(); i++) {
            if (rutinas.get(i).getId() == id) {
                rutinas.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Rutina> listarRutinas(Boolean soloActivas) {
        ArrayList<Rutina> out = new ArrayList<>();
        boolean filtrar = Boolean.TRUE.equals(soloActivas);
        for (Rutina r : rutinas) {
            if (!filtrar || r.isActiva()) out.add(r);
        }
        return out;
    }

    public boolean agregarEjercicioARutina(int rutinaId, Ejercicio e) {
        Rutina r = buscarRutina(rutinaId);
        if (r == null) return false;
        return r.agregarEjercicio(e);
    }

    public boolean eliminarEjercicioDeRutina(int rutinaId, String nombreEjercicio) {
        Rutina r = buscarRutina(rutinaId);
        if (r == null) return false;
        return r.eliminarEjercicioPorNombre(nombreEjercicio);
    }

    public boolean asignarRutinaASocio(int socioId, int rutinaId, int entrenadorId) {
        Socio s = buscarSocio(socioId);
        Rutina r = buscarRutina(rutinaId);
        Entrenador e = buscarEntrenador(entrenadorId);
        if (s == null || r == null || e == null) return false;
        if (!s.isActivo() || !r.isActiva() || !e.isActivo()) return false;

        s.setIdRutinaAsignada(r.getId());
        s.setIdEntrenadorAsignado(e.getId());
        return true;
    }

    public boolean desasignarRutinaDeSocio(int socioId) {
        Socio s = buscarSocio(socioId);
        if (s == null) return false;
        s.setIdRutinaAsignada(null);
        s.setIdEntrenadorAsignado(null);
        return true;
    }

    public Rutina rutinaMasPopular() {
        int max = -1;
        Rutina mejor = null;
        for (Rutina r : rutinas) {
            int conteo = contarSociosPorRutina(r.getId());
            if (conteo > max) {
                max = conteo;
                mejor = r;
            }
        }
        return mejor;
    }

    private int contarSociosPorRutina(int rutinaId) {
        int c = 0;
        for (Socio s : socios) {
            Integer rid = s.getIdRutinaAsignada();
            if (rid != null && rid == rutinaId) c++;
        }
        return c;
    }

    public int totalRutinasActivas() {
        int c = 0;
        for (Rutina r : rutinas) if (r.isActiva()) c++;
        return c;
    }

    public Entrenador entrenadorConMasAlumnos() {
        int max = -1;
        Entrenador top = null;
        for (Entrenador e : entrenadores) {
            int conteo = contarAlumnosDeEntrenador(e.getId());
            if (conteo > max) {
                max = conteo;
                top = e;
            }
        }
        return top;
    }

    private int contarAlumnosDeEntrenador(int entrenadorId) {
        int c = 0;
        for (Socio s : socios) {
            Integer eid = s.getIdEntrenadorAsignado();
            if (eid != null && eid == entrenadorId) c++;
        }
        return c;
    }

    public List<Socio> getSocios() { return socios; }
    public List<Entrenador> getEntrenadores() { return entrenadores; }
    public List<Rutina> getRutinas() { return rutinas; }
}
