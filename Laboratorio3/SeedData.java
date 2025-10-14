/**
 * Clase de utilidad para inicializar datos de ejemplo en el repositorio de personal médico.
 * Crea y agrega varios trabajadores médicos con diferentes roles y salarios base.
 */
public class SeedData {
    public static StaffRepository makeRepository() {
        StaffRepository repo = new StaffRepository();
        repo.add(new MedicalWorker("D1", "Dr. Gómez", new DoctorRole(200.0), 8000));
        repo.add(new MedicalWorker("S1", "Dra. Ruiz", new SurgeonRole(500.0, 1500.0), 12000));
        repo.add(new MedicalWorker("N1", "Enf. Soto", new NurseRole(false, 700.0), 5000));
        repo.add(new MedicalWorker("E1", "Lic. Pérez", new SpecialistRole("Radiólogo", 300.0), 7000));
        repo.add(new MedicalWorker("E2", "Lic. Lara", new SpecialistRole("Terapeuta", 250.0), 6800));
        return repo;
    }
}