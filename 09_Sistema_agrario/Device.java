import java.util.Objects;

public abstract class Device implements Comparable<Device> {
    private final String id;
    private final String name;
    private final String manufacturer;
    private final double powerWatts;

    protected Device(String id, String name, String manufacturer, double powerWatts) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.powerWatts = powerWatts;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getManufacturer() { return manufacturer; }
    public double getPowerWatts() { return powerWatts; }

    @Override
    public int compareTo(Device o) {
        return Double.compare(this.powerWatts, o.powerWatts);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) %.1fW", getClass().getSimpleName(), name, id, powerWatts);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Device d) && Objects.equals(id, d.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
