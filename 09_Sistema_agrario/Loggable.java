import java.util.List;

public interface Loggable {
    void log(String event);
    List<String> getLog();
}
