import java.util.*;

public class Catalog {
    private final List<Device> items = new ArrayList<>();

    public void add(Device d) { items.add(d); }

    public List<Device> all() {
        return Collections.unmodifiableList(items);
    }

    public Optional<Device> findById(String id) {
        for (Device d : items) if (d.getId().equalsIgnoreCase(id)) return Optional.of(d);
        return Optional.empty();
    }

    public List<Device> findByName(String name) {
        List<Device> out = new ArrayList<>();
        for (Device d : items) {
            if (d.getName().toLowerCase().contains(name.toLowerCase())) out.add(d);
        }
        return out;
    }

    public List<Device> sortedByConsumption() {
        List<Device> copy = new ArrayList<>(items);
        Collections.sort(copy); // Comparable<Device> en Device
        return copy;
    }
}
