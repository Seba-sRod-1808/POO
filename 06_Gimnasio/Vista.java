import java.util.Scanner;
import java.util.ArrayList;

public class Vista {
    private Scanner entrada;
    private ControladorGimnasio controlador;

    public Vista(ControladorGimnasio controlador) { //se le pasa el controlador
        this.controlador = controlador;
        this.entrada = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() {
        int opcion = -1;
        do { // bucle principal del menu con do while
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Registrar socio");
            System.out.println("2. Listar socios");
            System.out.println("3. Registrar entrenador");
            System.out.println("4. Listar entrenadores");
            System.out.println("5. Registrar rutina");
            System.out.println("6. Listar rutinas");
            System.out.println("7. Asignar rutina a socio");
            System.out.println("8. Desasignar rutina de socio");
            System.out.println("9. Listar ejercicios de una rutina");
            System.out.println("10. Eliminar ejercicio de una rutina");
            System.out.println("11. Reportes");
            System.out.println("0. Salir");
            System.out.print("Elegí una opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // limpiar salto de línea

            switch (opcion) { // switch basico para el menu
                case 1: registrarSocio(); break;
                case 2: listarSocios(); break;
                case 3: registrarEntrenador(); break;
                case 4: listarEntrenadores(); break;
                case 5: registrarRutina(); break;
                case 6: listarRutinas(); break;
                case 7: asignarRutinaASocio(); break;
                case 8: desasignarRutinaDeSocio(); break;
                case 9: listarEjerciciosDeRutina(); break;
                case 10: eliminarEjercicioDeRutina(); break;
                case 11: mostrarMenuReportes(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida."); break;
            }
        } while (opcion != 0); // condicion de salida del do while
    }

    private void registrarSocio() {
        System.out.print("Nombre del socio: "); 
        String nombre = entrada.nextLine();
        System.out.print("Tipo de membresía: ");
        String tipo = entrada.nextLine();
        Socio s = controlador.registrarSocio(nombre, tipo);
        System.out.println("Socio registrado con ID " + s.getId());
    }

    private void listarSocios() {
        ArrayList<Socio> lista = controlador.getCentral().listarSocios(false);
        for (Socio s : lista) { // para cada socio en la lista de socios
            System.out.println(s.resumen()); // mostrar resumen del socio
        }
    }

    private void registrarEntrenador() {
        System.out.print("Nombre del entrenador: ");
        String nombre = entrada.nextLine();
        Entrenador e = controlador.registrarEntrenador(nombre);
        System.out.println("Entrenador registrado con ID " + e.getId());
    }

    private void listarEntrenadores() {
        ArrayList<Entrenador> lista = controlador.getCentral().listarEntrenadores(false);
        for (Entrenador e : lista) {
            System.out.println(e.resumen()); // mostrar resumen del entrenador para cada entrenador en la lista
        }
    }

    private void registrarRutina() {
        System.out.print("Nombre de la rutina: ");
        String nombre = entrada.nextLine();
        System.out.print("Objetivo de la rutina: ");
        String objetivo = entrada.nextLine();
        Rutina r = controlador.registrarRutina(nombre, objetivo);
        System.out.println("Rutina registrada con ID " + r.getId());

        System.out.print("¿Desea agregar ejercicios a esta rutina? (1=Sí, 0=No): ");
        int op = entrada.nextInt();
        entrada.nextLine();

        while (op == 1) {
            agregarEjercicioARutina(r.getId());
            System.out.print("¿Agregar otro ejercicio? (1=Sí, 0=No): ");
            op = entrada.nextInt();
            entrada.nextLine();
        }
    }

    private void agregarEjercicioARutina(int rutinaId) {
        System.out.print("Nombre del ejercicio: ");
        String nombre = entrada.nextLine();
        System.out.print("Series: ");
        int series = entrada.nextInt();
        System.out.print("Repeticiones: ");
        int repeticiones = entrada.nextInt();
        System.out.print("Duración (minutos, 0 si no aplica): ");
        int duracion = entrada.nextInt();
        entrada.nextLine();

        Ejercicio e = new Ejercicio(nombre, series, repeticiones, duracion);
        boolean ok = controlador.getCentral().agregarEjercicioARutina(rutinaId, e);
        System.out.println(ok ? "Ejercicio agregado." : "Error al agregar ejercicio.");
    }

    private void listarEjerciciosDeRutina() {
        System.out.print("ID de la rutina: ");
        int rutinaId = entrada.nextInt();
        entrada.nextLine();
        Rutina r = controlador.getCentral().buscarRutina(rutinaId);

        if (r == null) {
            System.out.println("Rutina no encontrada.");
            return;
        }
        if (r.getEjercicios().isEmpty()) {
            System.out.println("La rutina no tiene ejercicios.");
        } else {
            System.out.println("Ejercicios de la rutina " + r.getNombre() + ":");
            for (Ejercicio e : r.getEjercicios()) {
                System.out.println(" - " + e.detalle());
            }
        }
    }

    private void eliminarEjercicioDeRutina() {
        System.out.print("ID de la rutina: ");
        int rutinaId = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Nombre del ejercicio a eliminar: ");
        String nombre = entrada.nextLine();

        boolean ok = controlador.getCentral().eliminarEjercicioDeRutina(rutinaId, nombre);
        System.out.println(ok ? "Ejercicio eliminado." : "No se encontró el ejercicio.");
    }


    private void listarRutinas() {
        ArrayList<Rutina> lista = controlador.getCentral().listarRutinas(null);
        for (Rutina r : lista) {
            System.out.println("Rutina #" + r.getId() + " - " + r.getNombre()
                    + " (" + r.getObjetivo() + "), Ejercicios: " + r.totalEjercicios());
        }
    }

    private void asignarRutinaASocio() {
        System.out.print("ID socio: ");
        int socioId = entrada.nextInt();
        System.out.print("ID rutina: ");
        int rutinaId = entrada.nextInt();
        System.out.print("ID entrenador: ");
        int entrenadorId = entrada.nextInt();
        entrada.nextLine();

        boolean ok = controlador.asignar(socioId, rutinaId, entrenadorId);
        System.out.println(ok ? "Asignación exitosa." : "Error en la asignación.");
    }

    private void desasignarRutinaDeSocio() {
        System.out.print("ID socio: ");
        int socioId = entrada.nextInt();
        entrada.nextLine();
        boolean ok = controlador.desasignar(socioId);
        System.out.println(ok ? "Rutina desasignada." : "Error al desasignar.");
    }

    private void mostrarMenuReportes() {
        System.out.println("\n--- Reportes ---");
        System.out.println("1. Rutina más popular");
        System.out.println("2. Total de rutinas activas");
        System.out.println("3. Entrenador con más alumnos");
        System.out.print("Elija opción: ");
        int op = entrada.nextInt();
        entrada.nextLine();

        switch (op) {
            case 1: mostrarRutinaMasPopular(); break;
            case 2: mostrarTotalRutinasActivas(); break;
            case 3: mostrarEntrenadorConMasAlumnos(); break;
            default: System.out.println("Opción inválida.");
        }
    }

    private void mostrarRutinaMasPopular() {
        Rutina r = controlador.rutinaMasPopular();
        if (r != null) System.out.println("La rutina más popular es: " + r.getNombre());
        else System.out.println("No hay rutinas asignadas.");
    }

    private void mostrarTotalRutinasActivas() {
        System.out.println("Total de rutinas activas: " + controlador.totalRutinasActivas());
    }

    private void mostrarEntrenadorConMasAlumnos() {
        Entrenador e = controlador.entrenadorConMasAlumnos();
        if (e != null) System.out.println("El entrenador con más alumnos es: " + e.getNombre());
        else System.out.println("No hay entrenadores con alumnos.");
    }
}
