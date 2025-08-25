public class Main {
    public static void main(String[] args) {
        // habilidades especiales
        HabilidadEspecial marLlamas = new HabilidadEspecial("Mar llamas", "ataque", 35);
        HabilidadEspecial efectoEspora = new HabilidadEspecial("Efecto espora", "defensa", 40);
        HabilidadEspecial torrente = new HabilidadEspecial("Torrente", "daño enemigo", 30);
        HabilidadEspecial mas = new HabilidadEspecial("Más", "ataque", 25);

        // se instancian los pokes con sus habilidades
        Pokemon[] equipo1 = new Pokemon[4];
        equipo1[0] = new Pokemon("Infernape", "Fuego", 60, 35, marLlamas);
        equipo1[1] = new Pokemon("Vaporeon", "Agua", 50, 45, torrente);
        equipo1[2] = new Pokemon("Rillaboom", "Planta", 55, 40, efectoEspora);
        equipo1[3] = new Pokemon("Electrode", "Eléctrico", 58, 30, mas);

        Pokemon[] equipo2 = new Pokemon[4];
        equipo2[0] = new Pokemon("Electrike", "Eléctrico", 54, 32, mas);
        equipo2[1] = new Pokemon("Rowlet", "Planta", 48, 37, efectoEspora);
        equipo2[2] = new Pokemon("Tentacruel", "Agua", 52, 43, torrente);
        equipo2[3] = new Pokemon("Incineroar", "Fuego", 57, 38, marLlamas);

        // instancia de entrenadores
        Entrenador erick = new Entrenador("Erick", equipo1);
        Entrenador cintia = new Entrenador("Cintia", equipo2);

        // se instancia la logica del juego
        Juego juego = new Juego(erick, cintia);
        juego.iniciarJuego();
        juego.mostrarResultados();
    }
}
