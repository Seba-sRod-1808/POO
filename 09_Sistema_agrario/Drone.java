import java.util.ArrayList;
import java.util.List;

public class Drone extends Device implements Measurable, Actionable, Loggable {
    private final List<String> events = new ArrayList<>();

    public Drone(String id, String name, String manufacturer, double powerWatts) {
        super(id, name, manufacturer, powerWatts);
    }

    @Override
    public String measure() {
        String value = "alt:" + (50 + (int)(Math.random() * 50)) + "m";
        events.add("measure=" + value);
        return value;
    }

    @Override
    public boolean perform(String action) {
        events.add("perform:" + action);
        return true;
    }

    @Override
    public boolean perform(String action, double level) {
        events.add("perform:" + action + ":" + level);
        return true;
    }

    @Override
    public void log(String event) { events.add(event); }

    @Override
    public List<String> getLog() { return events; }
}
