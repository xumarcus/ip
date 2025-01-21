public class Deadline extends Task {
    private final String by;
    public Deadline(String taskName, String by) {
        super(taskName);
        this.by = by;
    }

    @Override
    public String getTypeIcon() {
        return "D";
    }

    @Override
    public String getDescription() {
        return String.format("%s (by: %s)", taskName, by);
    }
}
