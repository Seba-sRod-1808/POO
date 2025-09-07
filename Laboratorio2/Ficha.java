public class Ficha {
    private String simbolo;
    private boolean emparejada;
    private boolean visible;

    public Ficha(String simbolo) {
        this.simbolo = simbolo;
        this.emparejada = false;
        this.visible = false;
    }

    public void revelar() {
        if (!emparejada) visible = true;
    }

    public void ocultar() {
        if (!emparejada) visible = false;
    }

    public void emparejar() {
        emparejada = true;
        visible = true;
    }

    public String getSimbolo() {
        return visible ? simbolo : "X";
    }

    public boolean isEmparejada() { return emparejada; }
    public boolean isVisible() { return visible; }
}
