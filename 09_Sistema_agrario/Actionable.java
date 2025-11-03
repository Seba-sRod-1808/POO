public interface Actionable {
    boolean perform(String action);
    boolean perform(String action, double level);
}
