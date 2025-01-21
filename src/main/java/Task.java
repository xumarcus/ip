public abstract class Task {
    public enum TaskStatus {
        DONE,
        UNDONE
    }
    protected String taskName;
    protected TaskStatus status;

    public Task(String taskName) {
        this.taskName = taskName;
        this.status = TaskStatus.UNDONE;
    }

    public String getStatusIcon() {
        return switch (status) {
            case DONE -> "X";
            case UNDONE -> " ";
        };
    }

    public abstract String getTypeIcon();

    public abstract String getDescription();

    public void markAsDone() {
        status = TaskStatus.DONE;
    }

    public void markAsUndone() {
        status = TaskStatus.UNDONE;
    }

    @Override
    public String toString() {
        return String.format("[%s][%s] %s", getTypeIcon(), getStatusIcon(), getDescription());
    }
}