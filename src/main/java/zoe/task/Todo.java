package zoe.task;

public class Todo extends Task {
    public Todo(String taskName) {
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
