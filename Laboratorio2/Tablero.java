import java.util.*;

public class Tablero {
    private Ficha[][] fichas;
    private int filas;
    private int columnas;

    public Tablero(int filas, int columnas, List<String> simbolos) {
        this.filas = filas;
        this.columnas = columnas;
        this.fichas = new Ficha[filas][columnas];
        inicializar(simbolos);
    }

    private void inicializar(List<String> simbolos) {
        Collections.shuffle(simbolos);
        Iterator<String> it = simbolos.iterator();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                fichas[i][j] = new Ficha(it.next());
            }
        }
    }

    public Ficha revelarFicha(int f, int c) throws CasillaFueraDeRangoException, JugadaInvalidaException {
        if (f < 0 || f >= filas || c < 0 || c >= columnas)
            throw new CasillaFueraDeRangoException("Coordenadas fuera de rango.");
        Ficha ficha = fichas[f][c];
        if (ficha.isEmparejada() || ficha.isVisible())
            throw new JugadaInvalidaException("Ficha ya visible o emparejada.");
        ficha.revelar();
        return ficha;
    }

    public void ocultarFicha(int f, int c) { fichas[f][c].ocultar(); }

    public boolean todasEmparejadas() {
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                if (!fichas[i][j].isEmparejada()) return false;
        return true;
    }

    public String[][] vistaSimbolos() {
        String[][] out = new String[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                out[i][j] = fichas[i][j].getSimbolo();
            }
        }
        return out;
    }

   public Ficha obtenerFicha(int f, int c) { return fichas[f][c]; }

    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
}
