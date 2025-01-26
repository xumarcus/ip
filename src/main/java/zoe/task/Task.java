package zoe.task;

import lombok.Data;

@Data
public abstract class Task {
    public enum TaskStatus {
        DONE,
        UNDONE
    }
    protected TaskStatus status = TaskStatus.UNDONE;

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

    public String getFullDescription() {
        return String.format("[%s][%s] %s", getTypeIcon(), getStatusIcon(), getDescription());
    }
}