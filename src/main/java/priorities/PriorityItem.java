package priorities;

public class PriorityItem implements Comparable<PriorityItem> {
    private final String name;
    private final int priority;

    public PriorityItem(String name, int priority) {

        this.name = name;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return name + " - " + priority;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(PriorityItem other) {
        return this.priority - other.priority;
    }
}
