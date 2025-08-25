public class NotasPlus {
    private Estudiante[] estudiantes;
    private Curso[] cursos;
    private double[][] calificaciones; // [estudiante][curso]

    public NotasPlus() {
        // el constructor esta vacio
    }

    public void iniciar() {
        cursos = new Curso[] {
            new Curso("Calculo 1", "N/A"),
            new Curso("POO", "N/A"),
            new Curso("Estadistica", "N/A")
        };

        // instancio los estudiantes
        estudiantes = new Estudiante[] {
            new Estudiante("Ana", "202101", "ana@uvg.edu.gt"),
            new Estudiante("Luis", "202102", "luis@uvg.edu.gt"),
            new Estudiante("Carla", "202103", "carla@uvg.edu.gt"),
            new Estudiante("Pedro", "202104", "pedro@uvg.edu.gt"),
            new Estudiante("Laura", "202105", "laura@uvg.edu.gt")
        };

        calificaciones = new double[estudiantes.length][cursos.length];

        calificaciones[0][0] = 85; 
        calificaciones[0][1] = 78; 
        calificaciones[0][2] = 92; 

        calificaciones[1][0] = 66;
        calificaciones[1][1] = 16;
        calificaciones[1][2] = 68;

        calificaciones[2][0] = 90;
        calificaciones[2][1] = 88;
        calificaciones[2][2] = 95;

        calificaciones[3][0] = 56;
        calificaciones[3][1] = 63;
        calificaciones[3][2] = 76;

        calificaciones[4][0] = 60;
        calificaciones[4][1] = 88;
        calificaciones[4][2] = 71;
    }

    public double calcularPromedioGeneral() {
        double suma = 0;
        int total = 0;

        for (int i = 0; i < estudiantes.length; i++) {
            for (int j = 0; j < cursos.length; j++) {
                suma += calificaciones[i][j];
                total++;
            }
        }

        return total > 0 ? suma / total : 0;
    }

    public double calcularPromedioEstudiante(int indiceEstudiante) {
        if (indiceEstudiante < 0 || indiceEstudiante >= estudiantes.length) return 0;

        double suma = 0;
        for (int j = 0; j < cursos.length; j++) {
            suma += calificaciones[indiceEstudiante][j];
        }

        return cursos.length > 0 ? suma / cursos.length : 0;
    }

    public double calcularPromedioCurso(int indiceCurso) {
        if (indiceCurso < 0 || indiceCurso >= cursos.length) return 0;

        double suma = 0;
        for (int i = 0; i < estudiantes.length; i++) {
            suma += calificaciones[i][indiceCurso];
        }

        return estudiantes.length > 0 ? suma / estudiantes.length : 0;
    }
}
