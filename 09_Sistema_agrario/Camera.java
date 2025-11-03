import java.util.ArrayList;
import java.util.List;

public class Camera extends Device implements Measurable, Loggable {
    private final List<String> events = new ArrayList<>();

    public Camera(String id, String name, String manufacturer, double powerWatts) {
        super(id, name, manufacturer, powerWatts);
    }

    @Override
    public String measure() {
        String value = "frame:" + System.currentTimeMillis();
        events.add("capture=" + value);
        return value;
    }

    @Override
    public void log(String event) { events.add(event); }

    @Override
    public List<String> getLog() { return events; }
}
