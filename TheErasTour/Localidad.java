public class Localidad {
    private String nombre;
    private double precio;
    private int capacidad;
    private int vendidos;

    public Localidad(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.capacidad = 20;
        this.vendidos = 0;
    }

    public boolean validoEspacio(int cantidad) {
        if (vendidos + cantidad <= capacidad) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validoPresupuesto(double presupuesto) {
        if (precio <= presupuesto) {
            return true;
        } else {
            return false;
        }
    }

    public void venderBoleto(int cantidad, double presupuesto) {
        if (validoPresupuesto(presupuesto)) {
            int disponibles = capacidad - vendidos;
            int aVender;

            if (cantidad > disponibles) {
                aVender = disponibles;
            } else {
                aVender = cantidad;
            }

            if (aVender > 0) {
                vendidos = vendidos + aVender;
                System.out.println("Compra realizada: " + aVender + " boletos.");
            } else {
                System.out.println("No hay boletos disponibles para la compra.");
            }
        } else {
            System.out.println("Presupuesto insuficiente para la compra.");
        }
    }

    public boolean disponibleBoleto() {
        return capacidad - vendidos > 0;
    }

    public String getNombre(String nombre) {
        return this.nombre;
    }

    public int getVendidos(int vendidos) {
        return this.vendidos;
    }

    public int getPrecio(int precio) {
        return (int) this.precio;
    }
}