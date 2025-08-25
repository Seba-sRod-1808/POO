import java.util.Random;

public class Cliente {
    private String Nombre;
    private String Email;
    private double Presupuesto;
    private int Ticket;
    private int Cantidad;

    public Cliente(String Nombre, String Email, double Presupuesto, int Cantidad) {
        this.Nombre = Nombre;
        this.Email = Email;
        this.Presupuesto = Presupuesto;
        this.Cantidad = Cantidad;
        generarTicket();
    }

    public void generarTicket() {
        Random rand = new Random();
        this.Ticket = rand.nextInt(15000) + 1;
    }

    public boolean validoCompra(int a, int b) {
        int menor;
        int mayor;

        if (a < b) {
            menor = a;
            mayor = b;
        } else {
            menor = b;
            mayor = a;
        }

        if (Ticket >= menor && Ticket <= mayor) {
            return true;
        } else {
            return false;
        }
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setPresupuesto(double Presupuesto) {
        this.Presupuesto = Presupuesto;
    }

    public void setTicket(int Ticket) {
        this.Ticket = Ticket;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getTicket() {
        return Ticket;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public double getPresupuesto() {
        return Presupuesto;
    }
}
