import java.util.ArrayList;
import java.util.List;

public class Sensor extends Device implements Measurable, Loggable {
    private final List<String> events = new ArrayList<>();

    public Sensor(String id, String name, String manufacturer, double powerWatts) {
        super(id, name, manufacturer, powerWatts);
    }

    @Override
    public String measure() {
        String value = "OK:" + Math.round(Math.random() * 100);
        events.add("measure=" + value);
        return value;
    }

    @Override
    public void log(String event) { events.add(event); }

    @Override
    public List<String> getLog() { return events; }
}
