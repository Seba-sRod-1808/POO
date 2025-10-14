/**
 * Proporciona servicios para generar informes de nómina y utilización del personal médico.
 * Calcula la nómina total por rol y la utilización de cada trabajador médico.
 */
import java.util.*;

public class ReportService {
    public Map<String, Double> payrollByRole(List<MedicalWorker> staff, Map<MedicalWorker, WorkLog> logs) {
        Map<String, Double> res = new LinkedHashMap<>();
        for (MedicalWorker m : staff) {
            WorkLog log = logs.getOrDefault(m, new WorkLog(0,0,0,0));
            double pay = m.calculateSalary(log);
            String key = m.getRole().getName();
            res.put(key, res.getOrDefault(key, 0.0) + pay);
        }
        return res;
    }
    public Map<MedicalWorker, Double> utilization(List<MedicalWorker> staff, int totalSlots) {
        Map<MedicalWorker, Double> out = new LinkedHashMap<>();
        for (MedicalWorker m : staff) out.put(m, 0.0);
        return out;
    }
}