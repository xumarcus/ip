public class ToDo extends Task {
    public ToDo(String taskName) {
        super(taskName);
    }

    @Override
    public String getTypeIcon() {
        return "T";
    }

    @Override
    public String getDescription() {
        return taskName;
    }
}
