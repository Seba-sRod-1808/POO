import java.util.*;

public class SysController {
    private final Catalog catalog;

    public SysController(Catalog catalog) {
        this.catalog = catalog;
    }

    public void init() {
        catalog.add(new Sensor("S-01", "soil-1", "AgroCo", 3.5));
        catalog.add(new Sensor("S-02", "soil-2", "AgroCo", 3.5));
        catalog.add(new Sensor("S-03", "weather-1", "MeteoInc", 6.0));
        catalog.add(new Controller("C-01", "valve-1", "HydroSys", 12.0));
        catalog.add(new Controller("C-02", "sprink-1", "HydroSys", 10.0));
        catalog.add(new Camera("CAM-01", "cam-east", "Optix", 8.0));
        catalog.add(new Camera("CAM-02", "cam-west", "Optix", 8.0));
        catalog.add(new Drone("D-01", "drone-a", "SkyFarm", 60.0));
        catalog.add(new Drone("D-02", "drone-b", "SkyFarm", 62.0));
        catalog.add(new Drone("D-03", "drone-c", "SkyFarm", 58.0));
    }

    public List<Device> listAll() { return catalog.all(); }
    public Optional<Device> searchById(String id) { return catalog.findById(id); }
    public List<Device> searchByName(String name) { return catalog.findByName(name); }
    public List<Device> orderByConsumption() { return catalog.sortedByConsumption(); }
}
