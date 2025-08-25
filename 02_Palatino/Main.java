public class Main 
{
    public static void main(String[] args)
    {
        Torneo palatino = new Torneo("Torneo Palatino", 5);

        Equipo t1 = new Equipo("Barca");
        Equipo t2 = new Equipo("Madrid");
        Equipo t3 = new Equipo("Atletic");
        Equipo t4 = new Equipo("Betis");
        Equipo t5 = new Equipo("Sevilla");

        palatino.addEquipo(0, t1);
        palatino.addEquipo(1, t2);
        palatino.addEquipo(2, t3);
        palatino.addEquipo(3, t4);
        palatino.addEquipo(4, t5);

        System.out.println(palatino.getResumen());

        }
    }
