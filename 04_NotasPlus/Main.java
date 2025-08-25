public class Main {
    public static void main(String[] args) {
        NotasPlus sistema = new NotasPlus();
        sistema.iniciar();

        System.out.println("Promedio general: " + sistema.calcularPromedioGeneral());

        for (int i = 0; i < 5; i++) {
            System.out.println("Promedio del estudiante " + i + ": " + sistema.calcularPromedioEstudiante(i));
        }

        for (int j = 0; j < 3; j++) {
            System.out.println("Promedio del curso " + j + ": " + sistema.calcularPromedioCurso(j));
        }
    }
}
